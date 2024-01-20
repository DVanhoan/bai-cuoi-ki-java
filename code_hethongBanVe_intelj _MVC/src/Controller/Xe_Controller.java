package Controller;

import DAO.Dao_Xe;
import Model.Xe_Model;
import View.Home_Vieww;
import View.Xe_View;
import database.JDBCUTill;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;

public class Xe_Controller implements ActionListener, MouseListener {
    private Xe_View xeView;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public Xe_Controller(Xe_View xeView){
        this.xeView = xeView;
    }


    public void selectAll_Xe(){
        try {
            con = JDBCUTill.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from xe");

            xeView.tableModel_xe.setRowCount(0);
            while (rs.next()) {
                Object[] rowdata = new Object[2];
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                xeView.tableModel_xe.addRow(rowdata);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }




    public Xe_Model getInfo(){
        String maXe = xeView.txt_maXe.getText();
        String tenXe = xeView.txt_tenXe.getText();

        Xe_Model xeModel = new Xe_Model(maXe, tenXe);
        return xeModel;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == xeView.btn_them){
            if (xeView.txt_maXe.getText().isEmpty() || xeView.txt_tenXe.getText().isEmpty()){
                JOptionPane.showMessageDialog(xeView, "Vui lòng nhập đầy đủ thông tin!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            }
            else {
                Xe_Model xeModel = getInfo();
                Dao_Xe daoXe = new Dao_Xe();

                if (daoXe.findXe(xeModel.getMaXe())){
                    JOptionPane.showMessageDialog(xeView, "xe này đã có trước đó!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    daoXe.insert(xeModel);
                    selectAll_Xe();
                    JOptionPane.showMessageDialog(xeView, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

//-----------------------------------------------------------------------------------------------------------------------------------------------

        else if (e.getSource()==xeView.btn_xoa){
            if (xeView.txt_maXe.getText().isEmpty() || xeView.txt_tenXe.getText().isEmpty()){
                JOptionPane.showMessageDialog(xeView, "Vui lòng nhập đầy đủ thông tin", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            }

            else {
                Xe_Model xeModel = getInfo();
                Dao_Xe daoXe = new Dao_Xe();

                if (daoXe.findXe(xeModel.getMaXe())==false){
                    JOptionPane.showMessageDialog(xeView, "xe này chưa tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
                else {

                    daoXe.delete(xeModel);
                    selectAll_Xe();
                    JOptionPane.showMessageDialog(xeView, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

//-----------------------------------------------------------------------------------------------------------------------------------------------


        else if (e.getSource()==xeView.btn_capnhat){
            if (xeView.txt_maXe.getText().isEmpty() || xeView.txt_tenXe.getText().isEmpty()){
                JOptionPane.showMessageDialog(xeView, "Vui lòng nhập đầy đủ thông tin", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            }
            else {
                Xe_Model xeModel = getInfo();
                Dao_Xe daoXe = new Dao_Xe();

                if (daoXe.findXe(xeModel.getMaXe())==false){
                    JOptionPane.showMessageDialog(xeView, "xe này chưa tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    daoXe.update(xeModel);
                    selectAll_Xe();
                    JOptionPane.showMessageDialog(xeView, "Chỉnh sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

//-----------------------------------------------------------------------------------------------------------------------------------------------

        else if (e.getSource()==xeView.btn_trangchu){
            xeView.setVisible(false);

            Home_Vieww homeVieww = new Home_Vieww();
            homeVieww.setVisible(true);
            homeVieww.setLocationRelativeTo(null);
        }

    }






    @Override
    public void mouseClicked(MouseEvent e) {
        int vitri = xeView.table.getSelectedRow();
        System.out.println("vị trí " + vitri);

        Object maxe = xeView.tableModel_xe.getValueAt(vitri, 0);
        xeView.txt_maXe.setText(maxe.toString());

        Object tenxe = xeView.tableModel_xe.getValueAt(vitri, 1);
        xeView.txt_tenXe.setText(tenxe.toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

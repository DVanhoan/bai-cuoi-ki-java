package Controller;

import View.Home_Vieww;
import View.VeXeView;
import database.JDBCUTill;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class VeXe_Controller implements ActionListener , MouseListener {
    VeXeView veXeView;
    public VeXe_Controller(VeXeView veXeView){
        this.veXeView = veXeView;
    }

    public void selectAll(){
        try {
            Connection con = JDBCUTill.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct * from danhsachve");
            veXeView.tableModel.setRowCount(0);
            while (rs.next()){
                Object[] rowdata = new Object[9];
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getInt(5);
                rowdata[5] = rs.getInt(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);

                veXeView.tableModel.addRow(rowdata);
            }
            con.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==veXeView.btnTrangCh){
            veXeView.setVisible(false);

            Home_Vieww homeVieww = new Home_Vieww();
            homeVieww.setVisible(true);
            homeVieww.setLocationRelativeTo(null);
        }




        if(e.getSource()==veXeView.btnfind){
            String ma = veXeView.textField.getText();
            if (ma.isEmpty()){
                JOptionPane.showMessageDialog(veXeView ,"Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    Connection con = JDBCUTill.getConnection();
                    String sql = "select * from danhsachve where MaDat like '"+ ma +"'";
                    PreparedStatement st = con.prepareStatement(sql);
                    ResultSet rs = st.executeQuery();

                    veXeView.tableModel.setRowCount(0);

                    while (rs.next()){
                        Object[] rowdata = new Object[9];
                        rowdata[0] = rs.getString(1);
                        rowdata[1] = rs.getString(2);
                        rowdata[2] = rs.getString(3);
                        rowdata[3] = rs.getString(4);
                        rowdata[4] = rs.getInt(5);
                        rowdata[5] = rs.getInt(6);
                        rowdata[6] = rs.getString(7);
                        rowdata[7] = rs.getString(8);
                        rowdata[8] = rs.getString(9);

                        veXeView.tableModel.addRow(rowdata);
                    }

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==veXeView.lbl_reload){
            selectAll();
        }
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

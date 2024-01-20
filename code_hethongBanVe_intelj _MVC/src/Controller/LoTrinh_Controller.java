package Controller;

import DAO.Dao_LoTrinh;
import Model.LoTrinh_model;
import View.Home_Vieww;
import View.LoTrinh_View;
import database.JDBCUTill;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Vector;

public class LoTrinh_Controller implements ActionListener, MouseListener {
    private LoTrinh_View loTrinhView;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    Vector<String> luachon;
    public LoTrinh_Controller(LoTrinh_View loTrinhView){
        this.loTrinhView = loTrinhView;
        luachon = new Vector<>();
    }

    public void addXe_luachon(){
        try {
            con = JDBCUTill.getConnection();
            Statement statement = con.createStatement();
            String sql = "select * from xe";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                luachon.add(rs.getString("TenXe"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Vector<String> getluachon(){
        return luachon;
    }


    //HÀM THÊM DỮ LIỆU VÀO BẢNG
    public void selectAll() {
        try {
            con = JDBCUTill.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from lotrinh");

            loTrinhView.tableModel.setRowCount(0);
            while (rs.next()) {
                Object[] rowdata = new Object[5];
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                loTrinhView.tableModel.addRow(rowdata);
            }
        } catch(SQLException e){
                e.printStackTrace();
            }
        }




    public LoTrinh_model getInfor(){
        String maLotrinh = loTrinhView.txt_maLotrinh_QLLT.getText();
        String lotrinh = loTrinhView.txt_lotrinh_QLLT.getText();
        int  soLuong = Integer.parseInt(loTrinhView.txt_soLuong_lotrinh_QLLT.getText());
        String ngaykhoihanh =loTrinhView.txt_ngayKhoiHanh_QLLT.getText();
        String loaiXe = loTrinhView.MaXe_cb_QLLT.getSelectedItem().toString();
        LoTrinh_model loTrinhModel = new LoTrinh_model(maLotrinh, lotrinh, soLuong, ngaykhoihanh, loaiXe);
        return loTrinhModel;
    }



        @Override
    public void actionPerformed(ActionEvent e) {

        //Xử lí sự kiện để thêm lộ trình đi
        if (e.getSource() == loTrinhView.btn_them) {
            if (loTrinhView.txt_maLotrinh_QLLT.getText().isEmpty() ||
                loTrinhView.txt_lotrinh_QLLT.getText().isEmpty() ||
                loTrinhView.txt_soLuong_lotrinh_QLLT.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(loTrinhView, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            else {
                LoTrinh_model loTrinhModel = getInfor();
                Dao_LoTrinh daoLoTrinh = new Dao_LoTrinh();

                if (daoLoTrinh.findLotrinh(loTrinhModel.getMaLoTrinh())){
                    JOptionPane.showMessageDialog(loTrinhView, "Lộ trình đã có trước đó!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    daoLoTrinh.insert(loTrinhModel);
                    selectAll();
                    JOptionPane.showMessageDialog(loTrinhView, "Thêm lộ trình thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }



        if (e.getSource()==loTrinhView.btn_trangchu){
            loTrinhView.setVisible(false);
            Home_Vieww homeVieww = new Home_Vieww();
            homeVieww.setVisible(true);
            homeVieww.setLocationRelativeTo(null);
        }


        //Xử lí sự kiện để xóa lộ trình đi
        if (e.getSource() == loTrinhView.btn_xoa) {
            if (loTrinhView.txt_maLotrinh_QLLT.getText().isEmpty() ||
                loTrinhView.txt_lotrinh_QLLT.getText().isEmpty() ||
                loTrinhView.txt_soLuong_lotrinh_QLLT.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(loTrinhView, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            else {
                LoTrinh_model loTrinhModel = getInfor();
                Dao_LoTrinh daoLoTrinh = new Dao_LoTrinh();

                if (daoLoTrinh.findLotrinh(loTrinhModel.getMaLoTrinh())==false){
                    JOptionPane.showMessageDialog(loTrinhView, "Lộ trình chưa tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    daoLoTrinh.delete(loTrinhModel);
                    selectAll();
                    JOptionPane.showMessageDialog(loTrinhView, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }



        // xử lí sự kiện chỉnh sửa lộ trình đi
        if (e.getSource()==loTrinhView.btn_capnhat){
            if (loTrinhView.txt_maLotrinh_QLLT.getText().isEmpty() ||
                loTrinhView.txt_lotrinh_QLLT.getText().isEmpty() ||
                loTrinhView.txt_soLuong_lotrinh_QLLT.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(loTrinhView, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            else {
                LoTrinh_model loTrinhModel = getInfor();
                Dao_LoTrinh daoLoTrinh = new Dao_LoTrinh();

                if (daoLoTrinh.findLotrinh(loTrinhModel.getMaLoTrinh())==false){
                    JOptionPane.showMessageDialog(loTrinhView, "Lộ trình chưa tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
                else{
                daoLoTrinh.update(loTrinhModel);
                selectAll();
                JOptionPane.showMessageDialog(loTrinhView, "Chỉnh sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }




    @Override
    public void mouseClicked(MouseEvent e) {
        int vitri = loTrinhView.table.getSelectedRow();
        System.out.println("vi tri "+ vitri);

        Object maLoTrinh = loTrinhView.tableModel.getValueAt(vitri, 0);
        loTrinhView.txt_maLotrinh_QLLT.setText(maLoTrinh.toString());

        Object loTrinh = loTrinhView.tableModel.getValueAt(vitri, 1);
        loTrinhView.txt_lotrinh_QLLT.setText(loTrinh.toString());

        Object soLuongVe = loTrinhView.tableModel.getValueAt(vitri, 2);
        loTrinhView.txt_soLuong_lotrinh_QLLT.setText(soLuongVe.toString());

        Object ngayKhoiHanh = loTrinhView.tableModel.getValueAt(vitri, 3);
        loTrinhView.txt_ngayKhoiHanh_QLLT.setText(ngayKhoiHanh.toString());

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

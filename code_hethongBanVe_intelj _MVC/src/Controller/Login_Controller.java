package Controller;

import View.Home_Vieww;
import View.Login_View;
import database.JDBCUTill;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login_Controller implements ActionListener {
    Login_View loginView;
    public Login_Controller(Login_View loginView){
        this.loginView = loginView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginView.btn_dangNhap) {
            String username = loginView.txt_taiKhoan.getText();
            String password = new String (loginView.txt_matKhau.getPassword());


            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(loginView, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    Connection con = JDBCUTill.getConnection();
                    String sql = "select * from taikhoan where tenTaiKhoan = ? and matKhau = ?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(loginView, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        con.close();
                        stmt.close();
                        rs.close();
                        loginView.setVisible(false);

                        Home_Vieww homeVieww = new Home_Vieww();
                        homeVieww.setVisible(true);
                        homeVieww.setLocationRelativeTo(null);
                    } else {
                        JOptionPane.showMessageDialog(loginView, "Đăng nhập thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(loginView, "Lỗi kết nối cơ sở dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    ex.printStackTrace();
                }
            }
        }
    }
}

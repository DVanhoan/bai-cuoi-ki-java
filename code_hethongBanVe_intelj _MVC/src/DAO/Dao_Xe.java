package DAO;


import Model.Xe_Model;
import database.JDBCUTill;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Dao_Xe{
    Connection con;


    public Xe_Model insert(Xe_Model xeModel){
        try {
            con = JDBCUTill.getConnection();
            String sql = "insert into xe(MaXe, TenXe) values(?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, xeModel.getMaXe());
            stmt.setString(2, xeModel.getTenXe());
            stmt.executeUpdate();
            con.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return xeModel;
    }

    public Xe_Model delete(Xe_Model xeModel){
        try {
            con = JDBCUTill.getConnection();
            String sql = "delete from xe where MaXe = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, xeModel.getMaXe());
            stmt.executeUpdate();
            con.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return xeModel;
    }


    public Xe_Model update(Xe_Model xeModel){
        try {
            con = JDBCUTill.getConnection();
            String sql = "update xe set TenXe = '"+xeModel.getTenXe()+"'  where MaXe = '"+xeModel.getMaXe()+"'";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            con.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return xeModel;
    }

    public boolean findXe(String maXe) {
        try {
            con = JDBCUTill.getConnection();
            String sql = "SELECT * FROM xe WHERE MaXe = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maXe); // Sử dụng PreparedStatement để tránh SQL injection

            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Trả về true nếu có ít nhất một kết quả, ngược lại trả về false
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

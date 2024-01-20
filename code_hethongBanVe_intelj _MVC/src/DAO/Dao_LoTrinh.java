package DAO;

import Model.LoTrinh_model;
import database.JDBCUTill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_LoTrinh {
    Connection con;

    public LoTrinh_model insert(LoTrinh_model loTrinhModel){
        try {
            con = JDBCUTill.getConnection();
            String sql = "insert into LOTRINH(MaLoTrinh, LoTrinh, SoLuong, NgayKhoiHanh, LoaiXe) values(?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, loTrinhModel.getMaLoTrinh());
            stmt.setString(2, loTrinhModel.getLoTrinh());
            stmt.setInt(3, loTrinhModel.getSoLuong());
            stmt.setString(4,loTrinhModel.getNgayKhoiHanh());
            stmt.setString(5, loTrinhModel.getLoaiXe());
            stmt.executeUpdate();
            con.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loTrinhModel;
    }

    public LoTrinh_model delete(LoTrinh_model loTrinhModel){
        try {
            con = JDBCUTill.getConnection();
            String sql = "delete from lotrinh where MaLoTrinh = ?";
            PreparedStatement xoa = con.prepareStatement(sql);
            xoa.setString(1, loTrinhModel.getMaLoTrinh());
            xoa.executeUpdate();
            con.close();
            xoa.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loTrinhModel;
    }

    public LoTrinh_model update(LoTrinh_model loTrinhModel){
        try {
            con = JDBCUTill.getConnection();
            String sql = "update lotrinh set LoTrinh = ?, SoLuong = ?, NgayKhoiHanh = ?, LoaiXe = ? where MaLoTrinh = ?";
            PreparedStatement capnhat = con.prepareStatement(sql);
            capnhat.setString(1, loTrinhModel.getLoTrinh());
            capnhat.setInt(2, loTrinhModel.getSoLuong());
            capnhat.setString(3, loTrinhModel.getNgayKhoiHanh());
            capnhat.setString(4, loTrinhModel.getLoaiXe());
            capnhat.setString(5, loTrinhModel.getMaLoTrinh());
            capnhat.executeUpdate();
            con.close();
            capnhat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loTrinhModel;
    }

    public boolean findLotrinh(String malotrinh) {
        try {
            con = JDBCUTill.getConnection();
            String sql = "SELECT * FROM lotrinh WHERE MaLoTrinh = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, malotrinh); // Sử dụng PreparedStatement để tránh SQL injection

            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Trả về true nếu có ít nhất một kết quả, ngược lại trả về false
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}

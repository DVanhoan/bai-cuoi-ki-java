package DAO;

import Model.LoTrinh_model;
import Model.VeXe_model;
import database.JDBCUTill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao_BanVe {
        Connection con;

        public VeXe_model insert(VeXe_model veXeModel){
            try {
                con = JDBCUTill.getConnection();
                String sql = "insert into danhsachve(MaDat, MaLoTrinh, HoVaTen, SoDienThoai, SoVe, TongTien, NgayDat, NgayKhoiHanh, ThanhToan) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, veXeModel.getMaDat());
                stmt.setString(2, veXeModel.getMaLoTrinh());
                stmt.setString(3, veXeModel.getHoVaTen());
                stmt.setInt(4,veXeModel.getSoDienThoai());
                stmt.setInt(5,veXeModel.getSoVe());
                stmt.setInt(6,veXeModel.getGiaTien());
                stmt.setString(7,veXeModel.getNgayDat());
                stmt.setString(8,veXeModel.getNgayKhoiHanh());
                stmt.setString(9, veXeModel.getThanhToan());
                stmt.executeUpdate();
                con.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return veXeModel;
        }

        public void delete(String maLoTrinh){
            try {
                con = JDBCUTill.getConnection();
                String sql = "delete from lotrinh where MaLoTrinh = ?";
                PreparedStatement xoa = con.prepareStatement(sql);
                xoa.setString(1, maLoTrinh);
                xoa.executeUpdate();
                con.close();
                xoa.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void update(String maLoTrinh, int soveconlai){
            try {
                con = JDBCUTill.getConnection();
                String sql = "update lotrinh set SoLuong = ? where MaLoTrinh = ?" ;
                PreparedStatement capnhat = con.prepareStatement(sql);
                capnhat.setInt(1, soveconlai);
                capnhat.setString(2, maLoTrinh);
                capnhat.executeUpdate();
                con.close();
                capnhat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



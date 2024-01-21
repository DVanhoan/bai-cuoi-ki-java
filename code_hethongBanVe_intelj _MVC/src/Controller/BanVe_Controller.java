package Controller;

import DAO.Dao_BanVe;
import Model.VeXe_model;
import View.BanVe_View;
import View.Home_Vieww;
import database.JDBCUTill;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BanVe_Controller implements ActionListener, MouseListener {
    private BanVe_View banVeView;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String maLoTrinh;
    String ngayKhoiHanh;
    int soLuong;

    public BanVe_Controller(BanVe_View banVeView){
        this.banVeView = banVeView;
    }
    public void selectAll() {
        try {
            con = JDBCUTill.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from lotrinh");

            banVeView.tableModel1.setRowCount(0);
            while (rs.next()) {
                Object[] rowdata = new Object[5];
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                banVeView.tableModel1.addRow(rowdata);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Hàm để lấy giá trị từ người dùng nhập vào
    public VeXe_model getInfor(){
        String maDat = banVeView.txt_MaDat.getText();
        String hoten = banVeView.txt_TenKH.getText();
        int sodt  = Integer.parseInt(banVeView.txt_sdt.getText());
        int sove = Integer.parseInt(banVeView.txt_sove.getText());
        String ngaydat = banVeView.lbl_Ngaydat2.getText();
        String trangThai = banVeView.comboBox.getSelectedItem().toString();

        VeXe_model veXeModel = new VeXe_model(maDat, maLoTrinh, hoten, sodt, sove, tonghoadon, ngaydat, ngayKhoiHanh, trangThai);
        return veXeModel;
    }


    //Hàm để lấy ngày đặt vé
    public void getDate(){
        // xét định danh ngày
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD");

        // lấy ngày hiện  tại
        LocalDateTime now = LocalDateTime.now();

        //gán nó vào lbl_ngaydat
        banVeView.lbl_Ngaydat2.setText(dtf.format(now));
    }

    //Hàm giảm số lượng số vé đã mua
    public void Descending(){
        int sove = Integer.parseInt(banVeView.txt_sove.getText());
        int soconlai = soLuong-sove;

        Dao_BanVe daoBanVe = new Dao_BanVe();
        daoBanVe.update(maLoTrinh, soconlai);

        //Nếu số vé còn lại chạm đến 0 thì nó sẽ bị xóa đi
        if(soconlai <= 0){
            daoBanVe.delete(maLoTrinh);
        }
        //đổ dữ liệu mới lên bảng đồ họa
        selectAll();
    }


    // Tạo sự kiện cho nút Trang chủ
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==banVeView.btn_trangchu){
            banVeView.setVisible(false);

            Home_Vieww homeVieww = new Home_Vieww();
            homeVieww.setVisible(true);
            homeVieww.setLocationRelativeTo(null);
        }
    }




    int giave, tonghoadon, so = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
        //Khi chuột click vào bảng, nó sẽ lấy giá trị của dòng nó click vô đó
        if (e.getSource() == banVeView.table_1){
            int vitri = banVeView.table_1.getSelectedRow();
            System.out.println("vi tri "+ vitri);
            maLoTrinh = banVeView.tableModel1.getValueAt(vitri, 0).toString();
            soLuong = (int) banVeView.tableModel1.getValueAt(vitri, 2);
            ngayKhoiHanh = banVeView.tableModel1.getValueAt(vitri, 3).toString();

            so = 1;
        }


        if (e.getSource()==banVeView.btn_tinhTien){
            //Khi nhấn nút tính tiền mà vẫn chưa nhập dữ liệu thì sẽ báo cho người dùng
            //ở đây nếu chưa click vào bảng có nghĩa là giá trị số vẫn bằng 0 nên sẽ báo lỗi
            if (so==0 || banVeView.txt_sove.getText().isEmpty() || banVeView.txt_giaTien.getText().isEmpty()){
                JOptionPane.showMessageDialog(banVeView, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }

            //Nếu đã nhập đầy đủ thông tin thì bắt đầu tính toán
            else {
                giave = Integer.parseInt(banVeView.txt_giaTien.getText());
                tonghoadon = giave * Integer.parseInt(banVeView.txt_sove.getText());

                //in tổng tiền đã tính được vào lblTongtien
                banVeView.lbl_tongTienVe.setText(tonghoadon+"");
            }
        }


        //Xử lí khi nhấn nút mua
        if (e.getSource()==banVeView.btn_mua){
            //Kiểm tra đã nhập thông tin chưa
            if (banVeView.txt_MaDat.getText().isEmpty()||
                banVeView.txt_TenKH.getText().isEmpty()||
                banVeView.txt_sdt.getText().isEmpty()  ||
                banVeView.txt_sove.getText().isEmpty() ||
                banVeView.txt_giaTien.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(banVeView, "Vui lòng nhập đầy đủ thông tin!","Thông báo", JOptionPane.WARNING_MESSAGE);
            }

            //Nếu nhập rồi thì thêm vào csdl
            else{
                VeXe_model veXeModel = getInfor();
                Dao_BanVe daoBanVe = new Dao_BanVe();
                daoBanVe.insert(veXeModel);
                JOptionPane.showMessageDialog(banVeView, "Mua thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Descending();
            }
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

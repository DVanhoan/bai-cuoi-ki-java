package View;


import Controller.BanVe_Controller;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;

public class BanVe_View extends JFrame {

    private static final long serialVersionUID = 1L;
    public final JButton btn_mua;
    public final JButton btn_trangchu;
    public final JButton btn_tinhTien;
    public final JLabel lbl_Ngaydat2;
    public final JLabel lbl_tongtienve_td;
    public final JLabel lbl_tongTienVe;
    public final JComboBox comboBox;
    private JPanel contentPane;
    public JTextField txt_TenKH;
    public JTextField txt_MaDat;
    public JTextField txt_sdt;
    public DefaultTableModel tableModel1;
    public JTable table_1;
    public JTextField txt_sove;
    public DefaultTableModel tableModel2;
    public JTable table_2;
    public JTextField txt_giaTien;

    public BanVe_View() {
        setTitle("Hệ Thống Quản Lý Bán Vé");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\car_128.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1129, 614);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        BanVe_Controller ac = new BanVe_Controller(this);


        JPanel contentPane_1 = new JPanel();
        contentPane_1.setLayout(null);
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_1.setBackground(new Color(255, 165, 0));
        contentPane_1.setBounds(0, 0, 1115, 577);
        contentPane.add(contentPane_1);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 73, 1115, 504);
        contentPane_1.add(panel);

        JLabel lblThngTinKhch = new JLabel("Thông Tin Khách Hàng");
        lblThngTinKhch.setForeground(new Color(0, 0, 0));
        lblThngTinKhch.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblThngTinKhch.setBounds(111, 10, 285, 39);
        panel.add(lblThngTinKhch);


        JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
        lblTnKhchHng.setForeground(new Color(0, 0, 0));
        lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTnKhchHng.setBounds(37, 143, 154, 28);
        panel.add(lblTnKhchHng);

        txt_TenKH = new JTextField();
        txt_TenKH.setForeground(new Color(0, 0, 0));
        txt_TenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txt_TenKH.setColumns(10);
        txt_TenKH.setBounds(195, 144, 239, 28);
        panel.add(txt_TenKH);


        JLabel lblSinThoi = new JLabel("Số Điện Thoại");
        lblSinThoi.setForeground(new Color(0, 0, 0));
        lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSinThoi.setBounds(37, 206, 154, 28);
        panel.add(lblSinThoi);

        txt_sdt = new JTextField();
        txt_sdt.setForeground(new Color(0, 0, 0));
        txt_sdt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txt_sdt.setColumns(10);
        txt_sdt.setBounds(195, 206, 239, 28);
        panel.add(txt_sdt);



        JLabel lbl_NgayDat = new JLabel("Ngày Đặt");
        lbl_NgayDat.setForeground(new Color(0, 0, 0));
        lbl_NgayDat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_NgayDat.setBounds(37, 267, 128, 28);
        panel.add(lbl_NgayDat);







        JLabel lblDanhSchL = new JLabel("DANH SÁCH LỘ TRÌNH");
        lblDanhSchL.setForeground(new Color(0, 0, 0));
        lblDanhSchL.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblDanhSchL.setBounds(683, 10, 285, 39);
        panel.add(lblDanhSchL);


        btn_mua = new JButton("Mua");
        btn_mua.addMouseListener(ac);
        btn_mua.setForeground(new Color(0, 0, 0));
        btn_mua.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn_mua.setBounds(798, 401, 128, 35);
        panel.add(btn_mua);

        btn_trangchu = new JButton("Trang Chủ");
        btn_trangchu.addActionListener(ac);
        btn_trangchu.setForeground(new Color(0, 0, 0));
        btn_trangchu.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn_trangchu.setBounds(630, 401, 128, 35);
        panel.add(btn_trangchu);





        txt_MaDat = new JTextField();
        txt_MaDat.setForeground(new Color(0, 0, 0));
        txt_MaDat.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txt_MaDat.setColumns(10);
        txt_MaDat.setBounds(195, 86, 239, 28);
        panel.add(txt_MaDat);

        JLabel lblMtV = new JLabel("Mã Đặt Vé");
        lblMtV.setForeground(new Color(0, 0, 0));
        lblMtV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMtV.setBounds(37, 86, 154, 28);
        panel.add(lblMtV);






        tableModel1 = new DefaultTableModel();

        tableModel1.addColumn("Mã Lộ Trình");
        tableModel1.addColumn("Lộ Trình");
        tableModel1.addColumn("Số Lượng");
        tableModel1.addColumn("Ngày Khởi Hành");
        tableModel1.addColumn("Loại Xe");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(569, 46, 514, 141);
        panel.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(514,171));

        table_1 = new JTable(tableModel1);
        table_1.addMouseListener(ac);
        table_1.getColumnModel().getColumn(0).setPreferredWidth(64);
        table_1.getColumnModel().getColumn(1).setPreferredWidth(120);
        table_1.getColumnModel().getColumn(2).setPreferredWidth(53);
        table_1.getColumnModel().getColumn(3).setPreferredWidth(70);
        table_1.getColumnModel().getColumn(4).setPreferredWidth(70);
        scrollPane.setViewportView(table_1);


        // them du lieu vao bang lo trinh
        ac.selectAll();





        btn_tinhTien = new JButton("Tính Tiền");
        btn_tinhTien.addMouseListener(ac);
        btn_tinhTien.setForeground(new Color(0, 0, 0));
        btn_tinhTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn_tinhTien.setBounds(875, 220, 117, 35);
        panel.add(btn_tinhTien);

        lbl_Ngaydat2 = new JLabel("dd/mm/yyyy");
        lbl_Ngaydat2.setForeground(new Color(0, 0, 0));
        lbl_Ngaydat2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_Ngaydat2.setBounds(195, 267, 239, 28);
        panel.add(lbl_Ngaydat2);


        JLabel lbl_soVe = new JLabel("Số Vé");
        lbl_soVe.setForeground(Color.BLACK);
        lbl_soVe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_soVe.setBounds(579, 246, 59, 28);
        panel.add(lbl_soVe);

        txt_sove = new JTextField();
        txt_sove.setForeground(new Color(0, 0, 0));
        txt_sove.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txt_sove.setColumns(10);
        txt_sove.setBounds(683, 247, 137, 28);
        panel.add(txt_sove);


        JLabel lbl_tenxe_3 = new JLabel("Giá Tiền");
        lbl_tenxe_3.setForeground(Color.BLACK);
        lbl_tenxe_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_tenxe_3.setBounds(579, 206, 86, 28);
        panel.add(lbl_tenxe_3);

        txt_giaTien = new JTextField();
        txt_giaTien.setForeground(Color.BLACK);
        txt_giaTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txt_giaTien.setColumns(10);
        txt_giaTien.setBounds(683, 207, 137, 28);
        panel.add(txt_giaTien);

        lbl_tongtienve_td = new JLabel("Thành Tiền:");
        lbl_tongtienve_td.setForeground(Color.BLACK);
        lbl_tongtienve_td.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_tongtienve_td.setBounds(579, 308, 111, 28);
        panel.add(lbl_tongtienve_td);

        lbl_tongTienVe = new JLabel("");
        lbl_tongTienVe.setForeground(Color.BLACK);
        lbl_tongTienVe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_tongTienVe.setBounds(700, 308, 128, 28);
        panel.add(lbl_tongTienVe);

        JLabel lbl_trangthai = new JLabel("Thanh Toán");
        lbl_trangthai.setForeground(Color.BLACK);
        lbl_trangthai.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_trangthai.setBounds(881, 279, 111, 28);
        panel.add(lbl_trangthai);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chưa", "Đã trả"}));
        comboBox.setBounds(881, 312, 111, 29);
        panel.add(comboBox);


        JLabel lblQuanlydatve = new JLabel("QUẢN LÝ ĐẶT VÉ");
        lblQuanlydatve.setForeground(new Color(255, 250, 250));
        lblQuanlydatve.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblQuanlydatve.setBounds(430, 21, 217, 39);
        contentPane_1.add(lblQuanlydatve);




        //Them du lieu ngay vao lbl ngay
        ac.getDate();



    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            BanVe_View banVeView = new BanVe_View();
            banVeView.setVisible(true);
            banVeView.setLocationRelativeTo(null);
            banVeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

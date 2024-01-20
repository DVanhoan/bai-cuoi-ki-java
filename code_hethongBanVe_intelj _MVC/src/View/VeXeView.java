package View;

import Controller.VeXe_Controller;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

public class VeXeView extends JFrame {

    private static final long serialVersionUID = 1L;
    public final DefaultTableModel tableModel;
    public final JButton btnTrangCh;
    public final JButton btnfind;
    public final JLabel lbl_reload;
    private JPanel contentPane;
    public JTable table;
    public JTextField textField;

    public VeXeView() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\car_128.png"));
        setTitle("Hệ Thống Quản Lý Bán Vé");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1129, 614);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 165, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        VeXe_Controller ac = new VeXe_Controller(this);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 73, 1115, 504);
        contentPane.add(panel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(92, 103, 933, 338);
        panel.add(scrollPane);

        tableModel = new DefaultTableModel();

        tableModel.addColumn("MaDat");
        tableModel.addColumn("MaLoTrinh");
        tableModel.addColumn("HoVaTen");
        tableModel.addColumn("SoDienThoai");
        tableModel.addColumn("SoVe");
        tableModel.addColumn("TongTien");
        tableModel.addColumn("NgayDat");
        tableModel.addColumn("NgayKhoiHanh");
        tableModel.addColumn("Thanh Toán");


        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField.setBounds(92, 57, 213, 25);
        panel.add(textField);
        textField.setColumns(10);

        lbl_reload = new JLabel("");
        lbl_reload.addMouseListener(ac);
        lbl_reload.setIcon(new ImageIcon("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\reload.png"));
        lbl_reload.setBounds(314, 57, 24, 24);
        panel.add(lbl_reload);

        btnfind = new JButton("Tìm kiếm");
        btnfind.addActionListener(ac);
        btnfind.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnfind.setBounds(350, 57, 145, 28);
        panel.add(btnfind);

        JLabel lblQunLV = new JLabel("DANH SÁCH VÉ XE");
        lblQunLV.setForeground(new Color(255, 250, 250));
        lblQunLV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblQunLV.setBounds(455, 24, 225, 39);
        contentPane.add(lblQunLV);


        btnTrangCh = new JButton("Trang Chủ");
        btnTrangCh.addActionListener(ac);
        btnTrangCh.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnTrangCh.setBounds(25, 466, 145, 28);
        panel.add(btnTrangCh);

        ac.selectAll();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            VeXeView veXeView = new VeXeView();
            veXeView.setVisible(true);
            veXeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            veXeView.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package View;

import Controller.Xe_Controller;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Xe_View extends JFrame {

	private static final long serialVersionUID = 1L;
	public  DefaultTableModel tableModel_xe;
	public  JButton btn_them;
	public  JButton btn_capnhat;
	public  JButton btn_xoa;
	public  JButton btn_trangchu;
	private JPanel contentPane;
	public JTextField txt_maXe;
	public JTextField txt_tenXe;
	public JTable table;


	public Xe_View() {
		setTitle("Hệ Thống Quản Lý Bán Vé");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\car_128.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 614);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		Xe_Controller ac = new Xe_Controller(this);



		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 73, 1115, 504);
		contentPane.add(panel);

		JLabel lblMaXe = new JLabel("Mã Xe");
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaXe.setBounds(31, 72, 128, 28);
		panel.add(lblMaXe);

		txt_maXe = new JTextField();
		txt_maXe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_maXe.setColumns(10);
		txt_maXe.setBounds(156, 73, 239, 28);
		panel.add(txt_maXe);

		JLabel lbl_tenxe = new JLabel("Tên Xe");
		lbl_tenxe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_tenxe.setBounds(31, 129, 128, 28);
		panel.add(lbl_tenxe);

		txt_tenXe = new JTextField();txt_tenXe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_tenXe.setColumns(10);
		txt_tenXe.setBounds(156, 130, 239, 28);
		panel.add(txt_tenXe);
		
		btn_them = new JButton("Thêm");
		btn_them.addActionListener(ac);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_them.setBounds(181, 299, 115, 35);
		panel.add(btn_them);

		btn_capnhat = new JButton("Cập Nhật");
		btn_capnhat.addActionListener(ac);
		btn_capnhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_capnhat.setBounds(45, 299, 115, 35);
		panel.add(btn_capnhat);

		btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(ac);
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_xoa.setBounds(325, 299, 95, 35);
		panel.add(btn_xoa);

		btn_trangchu = new JButton("Trang Chủ");
		btn_trangchu.addActionListener(ac);
		btn_trangchu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_trangchu.setBounds(181, 355, 117, 35);
		panel.add(btn_trangchu);



		tableModel_xe = new DefaultTableModel();

		tableModel_xe.addColumn("Mã Xe");
		tableModel_xe.addColumn("Tên Xe");

		table = new JTable(tableModel_xe);
		table.addMouseListener(ac);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(486, 72, 605, 363);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		scrollPane.setPreferredSize(new Dimension(605,363));




		JLabel lblDanhSchxe = new JLabel("DANH SÁCH XE");
		lblDanhSchxe.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDanhSchxe.setBounds(701, 23, 205, 39);
		panel.add(lblDanhSchxe);

		JLabel lblQunLXe = new JLabel("QUẢN LÝ XE");
		lblQunLXe.setForeground(new Color(255, 250, 250));
		lblQunLXe.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblQunLXe.setBounds(472, 24, 151, 39);
		contentPane.add(lblQunLXe);

		ac.selectAll_Xe();

		setVisible(true);
		setLocationRelativeTo(null);
	}

}

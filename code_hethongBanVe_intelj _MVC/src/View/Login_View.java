package View;

import Controller.Login_Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class Login_View extends JFrame {

	private static final long serialVersionUID = 1L;
	public final JButton btn_dangNhap;
	private JPanel contentPane;
	public JTextField txt_taiKhoan;
	public JPasswordField txt_matKhau;

	public Login_View() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\car_128.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hệ Thống Quản Lý Bán Vé");
		setBounds(100, 100, 418, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		Login_Controller ac = new Login_Controller(this);


		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 404, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("HỆ THỐNG QUẢN LÝ BÁN VÉ XE");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBounds(52, 10, 315, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl_taiKhoan = new JLabel("Tài Khoản");
		lbl_taiKhoan.setForeground(new Color(255, 165, 0));
		lbl_taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_taiKhoan.setBounds(33, 154, 88, 28);
		contentPane.add(lbl_taiKhoan);

		txt_taiKhoan = new JTextField();
		txt_taiKhoan.setForeground(new Color(255, 165, 0));
		txt_taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_taiKhoan.setBounds(139, 158, 205, 28);
		contentPane.add(txt_taiKhoan);
		txt_taiKhoan.setColumns(10);

		JLabel lbl_matKhau = new JLabel("Mật Khẩu");
		lbl_matKhau.setForeground(new Color(255, 165, 0));
		lbl_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_matKhau.setBounds(33, 196, 88, 28);
		contentPane.add(lbl_matKhau);

		btn_dangNhap = new JButton("Đăng Nhập");
		btn_dangNhap.addActionListener(ac);
		btn_dangNhap.setForeground(new Color(255, 165, 0));
		btn_dangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_dangNhap.setBounds(197, 278, 127, 35);
		contentPane.add(btn_dangNhap);

		txt_matKhau = new JPasswordField();
		txt_matKhau.setForeground(new Color(255, 165, 0));
		txt_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_matKhau.setBounds(139, 196, 205, 28);
		contentPane.add(txt_matKhau);
	}
}

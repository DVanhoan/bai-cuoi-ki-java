package View;

import Controller.Home_Controller;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Home_Vieww extends JFrame {

	private static final long serialVersionUID = 1L;
	public final JLabel lbl_anhxe;
	public final JLabel lbl_anhLoTrinh;
	public final JLabel lbl_anhVe;
	public final JLabel lbl_anhdatve;
	public final JButton btn_dangXuat;
	private JPanel contentPane;


	public Home_Vieww() {
		setTitle("Hệ Thống Quản Lý Bán Vé");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\car_128.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		Home_Controller ac = new Home_Controller(this);

		
		JPanel panel = new JPanel();
		panel.setBounds(0, 54, 924, 409);
		contentPane.add(panel);
		panel.setLayout(null);

		lbl_anhxe = new JLabel("");
		lbl_anhxe.addMouseListener(ac);
		lbl_anhxe.setIcon(new ImageIcon("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\car_128.png"));
		lbl_anhxe.setBounds(133, 61, 139, 99);
		panel.add(lbl_anhxe);
		
		lbl_anhLoTrinh = new JLabel("");
		lbl_anhLoTrinh.addMouseListener(ac);
		lbl_anhLoTrinh.setIcon(new ImageIcon("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\lotrinh_128.png"));
		lbl_anhLoTrinh.setBounds(628, 77, 154, 109);
		panel.add(lbl_anhLoTrinh);
		
		lbl_anhVe = new JLabel("");
		lbl_anhVe.addMouseListener(ac);
		lbl_anhVe.setIcon(new ImageIcon("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\ve_128.png"));
		lbl_anhVe.setBounds(652, 248, 139, 128);
		panel.add(lbl_anhVe);
		
		lbl_anhdatve = new JLabel("");
		lbl_anhdatve.addMouseListener(ac);
		lbl_anhdatve.setIcon(new ImageIcon("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\dặtve_128.png"));
		lbl_anhdatve.setBounds(145, 248, 139, 128);
		panel.add(lbl_anhdatve);

		JLabel lblDnhachsXe = new JLabel("XE");
		lblDnhachsXe.setForeground(new Color(255, 165, 0));
		lblDnhachsXe.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDnhachsXe.setBounds(172, 32, 48, 39);
		panel.add(lblDnhachsXe);

		JLabel lbl_lotrinh = new JLabel("LỘ TRÌNH");
		lbl_lotrinh.setForeground(new Color(255, 165, 0));
		lbl_lotrinh.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbl_lotrinh.setBounds(630, 32, 129, 39);
		panel.add(lbl_lotrinh);
		
		JLabel lbltV = new JLabel("ĐẶT VÉ");
		lbltV.setForeground(new Color(255, 165, 0));
		lbltV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbltV.setBounds(158, 216, 103, 39);
		panel.add(lbltV);
		
		JLabel lblV = new JLabel("VÉ");
		lblV.setForeground(new Color(255, 165, 0));
		lblV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblV.setBounds(702, 216, 57, 39);
		panel.add(lblV);
		
		btn_dangXuat = new JButton("Đăng Xuất");
		btn_dangXuat.addMouseListener(ac);
		btn_dangXuat.setForeground(new Color(255, 165, 0));
		btn_dangXuat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_dangXuat.setBounds(387, 190, 127, 35);
		panel.add(btn_dangXuat);
		
		JLabel lblNewLabel = new JLabel("TRANG CHỦ");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(366, 5, 149, 39);
		contentPane.add(lblNewLabel);

	}

}

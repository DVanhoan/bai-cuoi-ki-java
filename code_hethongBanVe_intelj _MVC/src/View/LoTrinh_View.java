package View;

import Controller.LoTrinh_Controller;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoTrinh_View extends JFrame {

	public static final long serialVersionUID = 1L;
	public final JButton btn_capnhat;
	public final JButton btn_them;
	public final JButton btn_xoa;
	public final JButton btn_trangchu;
	public final DefaultTableModel tableModel;
	private  Vector<String> luachon;

	public JPanel contentPane;
	public JTextField txt_maLotrinh_QLLT;
	public JTextField txt_lotrinh_QLLT;
	public JTextField txt_soLuong_lotrinh_QLLT;
	public JTable table;
	public JTextField txt_ngayKhoiHanh_QLLT;
	public JComboBox<String> MaXe_cb_QLLT;


	public LoTrinh_View() {
		setTitle("Hệ Thống Quản Lý Bán Vé");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HOAN\\Downloads\\ảnh làm bài cuối kì java\\car_128.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 614);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		//Tạo sự kiện cho các nút
		LoTrinh_Controller ac = new LoTrinh_Controller(this);



		
		JPanel panel = new JPanel();
		panel.setBounds(0, 73, 1115, 504);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaLoTrinh = new JLabel("Mã Lộ Trình");
		lblMaLoTrinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaLoTrinh.setBounds(31, 72, 128, 28);
		panel.add(lblMaLoTrinh);
		
		txt_maLotrinh_QLLT = new JTextField();
		txt_maLotrinh_QLLT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_maLotrinh_QLLT.setColumns(10);
		txt_maLotrinh_QLLT.setBounds(181, 73, 239, 28);
		panel.add(txt_maLotrinh_QLLT);
		
		JLabel lbl_giaVe = new JLabel("Số Lượng");
		lbl_giaVe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_giaVe.setBounds(31, 181, 128, 28);
		panel.add(lbl_giaVe);
		
		JLabel lblLoTrinh = new JLabel("Lộ Trình");
		lblLoTrinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoTrinh.setBounds(31, 129, 128, 28);
		panel.add(lblLoTrinh);
		
		txt_lotrinh_QLLT = new JTextField();
		txt_lotrinh_QLLT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_lotrinh_QLLT.setColumns(10);
		txt_lotrinh_QLLT.setBounds(181, 130, 239, 28);
		panel.add(txt_lotrinh_QLLT);
		
		JLabel lbl_maXe2 = new JLabel("Loại Xe");
		lbl_maXe2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_maXe2.setBounds(31, 282, 128, 28);
		panel.add(lbl_maXe2);


		ac.addXe_luachon();
		luachon = ac.getluachon();



		MaXe_cb_QLLT = new JComboBox<String>(luachon);
		MaXe_cb_QLLT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MaXe_cb_QLLT.setBounds(181, 286, 239, 29);
		panel.add(MaXe_cb_QLLT);



		
		txt_soLuong_lotrinh_QLLT = new JTextField();
		txt_soLuong_lotrinh_QLLT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_soLuong_lotrinh_QLLT.setColumns(10);
		txt_soLuong_lotrinh_QLLT.setBounds(181, 182, 239, 28);
		panel.add(txt_soLuong_lotrinh_QLLT);
		
		btn_capnhat = new JButton("Cập Nhật");
		btn_capnhat.addActionListener(ac);
		btn_capnhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_capnhat.setBounds(52, 402, 107, 35);
		panel.add(btn_capnhat);
		
		btn_them = new JButton("Thêm");
		btn_them.addActionListener(ac);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_them.setBounds(181, 402, 115, 35);
		panel.add(btn_them);

		btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(ac);
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_xoa.setBounds(313, 402, 107, 35);
		panel.add(btn_xoa);
		
		btn_trangchu = new JButton("Trang Chủ");
		btn_trangchu.addActionListener(ac);
		btn_trangchu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_trangchu.setBounds(179, 447, 117, 35);
		panel.add(btn_trangchu);



		tableModel = new DefaultTableModel();

		tableModel.addColumn("Mã Lộ Trình");
		tableModel.addColumn("Lộ Trình");
		tableModel.addColumn("Số Lượng Vé");
		tableModel.addColumn("Ngày Khởi Hành");
		tableModel.addColumn("Loại Xe");

		table = new JTable(tableModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.addMouseListener(ac);

		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(45);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(486, 72, 605, 363);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		scrollPane.setPreferredSize(new Dimension(605,363));




		JLabel lblDanhSchL = new JLabel("DANH SÁCH LỘ TRÌNH");
		lblDanhSchL.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDanhSchL.setBounds(645, 20, 298, 39);
		panel.add(lblDanhSchL);
		
		JLabel lbl_ngayKhoiHanh = new JLabel("Ngày Khởi Hành");
		lbl_ngayKhoiHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_ngayKhoiHanh.setBounds(31, 231, 143, 28);
		panel.add(lbl_ngayKhoiHanh);
		
		txt_ngayKhoiHanh_QLLT = new JTextField();
		txt_ngayKhoiHanh_QLLT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_ngayKhoiHanh_QLLT.setColumns(10);
		txt_ngayKhoiHanh_QLLT.setBounds(181, 232, 239, 28);
		panel.add(txt_ngayKhoiHanh_QLLT);
		
		JLabel lblQunLL = new JLabel("QUẢN LÝ LỘ TRÌNH");
		lblQunLL.setForeground(new Color(255, 250, 250));
		lblQunLL.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblQunLL.setBounds(422, 24, 238, 39);
		contentPane.add(lblQunLL);

		ac.selectAll();



	}


}

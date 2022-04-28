package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class BANHANG extends JPanel {
	private JTextField txtTKHD;
	private JTextField txtMaHD;
	private JTextField textField_3;
	private JTextField txtSL;
	private JTextField txtThanhTien;
	private JTable JTableHD;
	private JTextField txtDonGia;
	private JTextField textField;
	

	/**
	 * Create the panel.
	 */
	
	
	
	
	public BANHANG() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 931, 695);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_10_2 = new JLabel("TÌM KIẾM");
		lblNewLabel_10_2.setForeground(Color.BLUE);
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_2.setBounds(20, 27, 89, 20);
		panel.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(222, 22, 117, 29);
		panel.add(lblNewLabel_1);
		
		txtTKHD = new JTextField();
		txtTKHD.setColumns(10);
		txtTKHD.setBounds(349, 22, 149, 29);
		panel.add(txtTKHD);
		
		JButton btnFind = new JButton("Tìm kiếm");
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFind.setBounds(509, 22, 148, 31);
		panel.add(btnFind);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setBounds(10, 63, 900, 2);
		panel.add(separator_2_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 10, 900, 2);
		panel.add(separator_2_1);
		
		JLabel lblNewLabel_10 = new JLabel("THÔNG TIN HÓA ĐƠN");
		lblNewLabel_10.setForeground(Color.BLUE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(20, 75, 203, 20);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel = new JLabel("Mã hóa đơn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(111, 105, 117, 29);
		panel.add(lblNewLabel);
		
		txtMaHD = new JTextField();
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(238, 107, 214, 29);
		panel.add(txtMaHD);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNhnVin.setBounds(111, 144, 117, 29);
		panel.add(lblTnNhnVin);
		
		JLabel lblNgyLp = new JLabel("Ngày lập");
		lblNgyLp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgyLp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyLp.setBounds(440, 105, 117, 29);
		panel.add(lblNgyLp);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(557, 105, 236, 29);
		panel.add(textField_3);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(111, 189, 117, 29);
		panel.add(lblTnKhchHng);
		
		JComboBox<String> cmbTenNV = new JComboBox<String>();
		cmbTenNV.setBounds(238, 146, 555, 29);
		panel.add(cmbTenNV);
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			String sqlString = "select * from NHANVIEN ";
			PreparedStatement st = cons.prepareStatement(sqlString);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String name = rs.getString("TENNV");
				cmbTenNV.addItem(name);
			}
		} catch (SQLException e) {
		}
		
		
		JLabel lblTnXe = new JLabel("Tên xe");
		lblTnXe.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnXe.setBounds(111, 236, 56, 29);
		panel.add(lblTnXe);
		
		JComboBox cmbTenXe = new JComboBox();
		cmbTenXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
					String sql = "select GIABAN from XEMAY where TENXE = ?";
					PreparedStatement st = cons.prepareStatement(sql);
					st.setString(1, (String) cmbTenXe.getSelectedItem());
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						txtDonGia.setText(rs.getString("GIABAN"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		cmbTenXe.setBounds(238, 238, 214, 29);
		panel.add(cmbTenXe);
		
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			String sqlString = "select * from XEMAY ";
			PreparedStatement st = cons.prepareStatement(sqlString);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String name = rs.getString("TENXE");
				cmbTenXe.addItem(name);
			}
		} catch (SQLException e) {
		}
		
		JLabel lblMuSc = new JLabel("Màu sắc");
		lblMuSc.setHorizontalAlignment(SwingConstants.LEFT);
		lblMuSc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMuSc.setBounds(481, 240, 65, 29);
		panel.add(lblMuSc);
		
		JComboBox cmbMau = new JComboBox();
		cmbMau.setBounds(557, 240, 236, 29);
		panel.add(cmbMau);
		
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			String sqlString = "select * from MAUSAC ";
			PreparedStatement st = cons.prepareStatement(sqlString);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String name = rs.getString("TENMAU");
				cmbMau.addItem(name);
			}
		} catch (SQLException e) {
		}
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setHorizontalAlignment(SwingConstants.LEFT);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(111, 289, 117, 29);
		panel.add(lblSLng);
		
		txtSL = new JTextField();
		txtSL.setColumns(10);
		txtSL.setBounds(238, 291, 214, 29);
		panel.add(txtSL);
		
		JLabel lblThnhTin = new JLabel("Thành tiền");
		lblThnhTin.setHorizontalAlignment(SwingConstants.LEFT);
		lblThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThnhTin.setBounds(481, 344, 89, 29);
		panel.add(lblThnhTin);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThanhTien.setEnabled(false);
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(557, 344, 236, 29);
		panel.add(txtThanhTien);
		
		JButton btnCount = new JButton("Tính tiền");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double soluong, dongia, thanhtien;
				
				soluong = Double.parseDouble(txtSL.getText());
				dongia = Double.parseDouble(txtDonGia.getText());
				
				thanhtien = soluong * dongia;
				
				txtThanhTien.setText(String.format("%.2f", thanhtien));
			}
		});
		btnCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCount.setBounds(197, 407, 97, 31);
		panel.add(btnCount);
		
		JButton btnNew = new JButton("Nhập mới");
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNew.setBounds(411, 407, 122, 31);
		panel.add(btnNew);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(549, 407, 117, 31);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(676, 407, 97, 31);
		panel.add(btnDelete);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(171, 395, 629, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(171, 448, 629, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("DANH SÁCH HÓA ĐƠN");
		lblNewLabel_10_1.setForeground(Color.BLUE);
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_1.setBounds(34, 460, 228, 20);
		panel.add(lblNewLabel_10_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 490, 866, 196);
		panel.add(scrollPane);
		
		JTableHD = new JTable();
		JTableHD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "T\u00EAn nh\u00E2n vi\u00EAn", "T\u00EAn kh\u00E1ch h\u00E0ng"
			}
		));
		JTableHD.getColumnModel().getColumn(0).setPreferredWidth(72);
		JTableHD.getColumnModel().getColumn(1).setPreferredWidth(130);
		JTableHD.getColumnModel().getColumn(2).setPreferredWidth(158);
		JTableHD.getColumnModel().getColumn(3).setPreferredWidth(165);
		scrollPane.setViewportView(JTableHD);
		
		JComboBox<String> cmbTenKH = new JComboBox<String>();
		cmbTenKH.setBounds(238, 195, 555, 29);
		panel.add(cmbTenKH);
		
		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setHorizontalAlignment(SwingConstants.LEFT);
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnGi.setBounds(481, 287, 65, 29);
		panel.add(lblnGi);
		
		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDonGia.setEnabled(false);
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(557, 289, 236, 29);
		panel.add(txtDonGia);
		
		JLabel lblThu = new JLabel("Thuế");
		lblThu.setHorizontalAlignment(SwingConstants.LEFT);
		lblThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThu.setBounds(111, 344, 89, 29);
		panel.add(lblThu);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(238, 344, 214, 29);
		panel.add(textField);
		
		JButton btnSave = new JButton("Lưu");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(304, 407, 97, 31);
		panel.add(btnSave);
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			String sqlString = "select * from KHACHHANG ";
			PreparedStatement st = cons.prepareStatement(sqlString);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String name = rs.getString("TENKH");
				cmbTenKH.addItem(name);
			}
		} catch (SQLException e) {
		}
		

		DefaultTableModel model = (DefaultTableModel) JTableHD.getModel();
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("  Select MAHD,NGAYLAP,TENNV,TENKH from KHACHHANG,NHANVIEN, HOADON where HOADON.MAKH = KHACHHANG.MAKH AND HOADON.MANV = NHANVIEN.MANV ");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Object objList[] = {rs.getString("MAHD"), rs.getDate("NGAYLAP"), rs.getString("TENNV"), rs.getString("TENKH")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(KHACHHANG.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}

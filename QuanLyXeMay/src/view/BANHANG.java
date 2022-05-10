package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Dao.BanHangDao;
import Dao.KhachHangDao;
import model.CTHOADON;
import model.HOADON;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BANHANG extends JPanel {
	private JTextField txtTKHD;
	private JTextField txtMaHD;
	private JTextField txtSL;
	private JTextField txtThanhTien;
	private JTable JTableHD;
	private JTextField txtDonGia;
	private JTextField textField;
	private JTextField txtMaXe;
	private JTextField txtMau;
	private JTextField txtMaNV;
	private JTextField txtMaKH;
	private JTextField txtNCC;
	private JTextField txtNgayLap;
	private JTextField txtNCCC;

	/**
	 * Create the panel.
	 */
	
	
	
	
	public BANHANG() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 932, 695);
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

		JComboBox<String> cmbTenNV = new JComboBox<String>();
		JComboBox<String> cmbTenKH = new JComboBox<String>();
		JComboBox<String> cmbMau = new JComboBox<String>();
		JComboBox<String> cmbTenXe = new JComboBox<String>();
		
		JButton btnFind = new JButton("Tìm kiếm");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTKHD.getText().equals("")) {
					JOptionPane.showMessageDialog(btnFind, "Nhập mã khách hàng cần tìm kiếm");
					return;
				}
				try {
					BanHangDao dao = new BanHangDao();
					
					model.CTHOADON hoadon = dao.FindbyID(txtTKHD.getText());
					model.CTHOADON hCthoadon = dao.FindByID(txtTKHD.getText());
					
					if(hoadon != null) {
						txtMaHD.setText(hoadon.getMa_hd());
						txtNgayLap.setText(hCthoadon.getNgay_lap());
						txtSL.setText(hoadon.getSo_luong());
						txtThanhTien.setText(hoadon.getDon_gia());
						cmbTenNV.setSelectedItem(hoadon.getMa_nv());
						cmbTenKH.setSelectedItem(hoadon.getMa_kh());
						cmbMau.setSelectedItem(hoadon.getMa_mau());
						txtNCCC.setText(hoadon.getMa_ncc());
						cmbTenXe.setSelectedItem(hoadon.getMa_xe());
					}
					else {
						JOptionPane.showMessageDialog(btnFind, "Không tìm thấy khách hàng");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnFind, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
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
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(111, 189, 117, 29);
		panel.add(lblTnKhchHng);
		
		cmbTenNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
					String sql = "select MANV from NHANVIEN where TENNV = ?";
					PreparedStatement st = cons.prepareStatement(sql);
					st.setString(1, (String) cmbTenNV.getSelectedItem());
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						txtMaNV.setText(rs.getString("MANV"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
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

				cmbMau.removeAllItems();
				try {
					Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
					String sql = "select top 5 TENMAU, XEMAY.MAMAU from  XEMAY, MAUSAC where TENXE = ? and MAUSAC.MAMAU = XEMAY.MAMAU";
					PreparedStatement st = cons.prepareStatement(sql);
					st.setString(1, (String) cmbTenXe.getSelectedItem());
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						cmbMau.addItem(rs.getString("TENMAU"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				try {
					Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
					String sql = "select TENNCC from XEMAY, NCC where TENXE = ? AND XEMAY.MANCC = NCC.MANCC";
					PreparedStatement st = cons.prepareStatement(sql);
					st.setString(1, (String) cmbTenXe.getSelectedItem());
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						txtNCCC.setText(rs.getString("TENNCC"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				try {
					Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
					String sql = "select MANCC from XEMAY where TENXE = ?";
					PreparedStatement st = cons.prepareStatement(sql);
					st.setString(1, (String) cmbTenXe.getSelectedItem());
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						txtNCC.setText(rs.getString("MANCC"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				try {
					Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
					String sql = "select MAXE from XEMAY where TENXE = ?";
					PreparedStatement st = cons.prepareStatement(sql);
					st.setString(1, (String) cmbTenXe.getSelectedItem());
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						txtMaXe.setText(rs.getString("MAXE"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		cmbTenXe.setBounds(238, 238, 126, 29);
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
		lblMuSc.setBounds(374, 236, 65, 29);
		panel.add(lblMuSc);
		
		
		cmbMau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
					String sql = "select MAMAU from MAUSAC where TENMAU = ?";
					PreparedStatement st = cons.prepareStatement(sql);
					st.setString(1, (String) cmbMau.getSelectedItem());
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						txtMau.setText(rs.getString("MAMAU"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		cmbMau.setBounds(449, 238, 89, 29);
		panel.add(cmbMau);
		
		
		
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
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaHD.setText("");
				txtNgayLap.setText("");
				txtSL.setText("");
				txtThanhTien.setText("");
				txtDonGia.setText("");
				cmbMau.setSelectedIndex(0);
				txtNCCC.setText("");
				cmbTenNV.setSelectedIndex(0);
				cmbTenXe.setSelectedIndex(0);
				cmbTenKH.setSelectedIndex(0);
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNew.setBounds(411, 407, 122, 31);
		panel.add(btnNew);
		
		
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMaHD.getText().equals("")) {
					sb.append("Mã đơn hàng không được để trống");
					txtMaHD.setBackground(Color.red);
				}
				else {
					txtMaHD.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showConfirmDialog(btnUpdate, sb);
					return;
				}
				
				if(JOptionPane.showConfirmDialog(btnUpdate, "Bạn có muốn thay đổi thông tin của đơn hàng này không?") == JOptionPane.NO_OPTION) {
					return;
				}
				
				try {
					model.CTHOADON hoadon = new CTHOADON(TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY);
					hoadon.setMa_hd(txtMaHD.getText());
					hoadon.setMa_kh(txtMaKH.getText());
					hoadon.setMa_mau(txtMau.getText());
					hoadon.setMa_nv(txtMaNV.getText());
					hoadon.setMa_xe(txtMaXe.getText());
					hoadon.setDon_gia(txtThanhTien.getText());
					hoadon.setMa_ncc(txtNCC.getText());
					hoadon.setSo_luong(txtSL.getText());	
					hoadon.setNgay_lap(txtNgayLap.getText());
					BanHangDao dao = new BanHangDao();
					dao.update(hoadon);
					dao.capnhat(hoadon);
					
					JOptionPane.showMessageDialog(btnUpdate, "Đã cập nhật đơn hàng");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnUpdate, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(549, 407, 117, 31);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMaHD.getText().equals("")) {
					sb.append("Mã hóa đơn không được để trống");
					txtMaHD.setBackground(Color.red);
				}
				else {
					txtMaHD.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showConfirmDialog(btnDelete, sb);
					return;
				}
				
				if(JOptionPane.showConfirmDialog(btnDelete, "Bạn có muốn xóa hóa đơn này không?") == JOptionPane.NO_OPTION) {
					return;
				}
				
				try {
					BanHangDao dao = new BanHangDao();
					dao.delete(txtMaHD.getText()); 
					dao.delete1(txtMaHD.getText());
					
					JOptionPane.showMessageDialog(btnDelete, "Đã xóa đơn hàng");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnDelete, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
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
		JTableHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		JTableHD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "T\u00EAn nh\u00E2n vi\u00EAn", "T\u00EAn kh\u00E1ch h\u00E0ng", "T\u00EAn xe", "M\u00E0u s\u1EAFc", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n"
			}
		));
		JTableHD.getColumnModel().getColumn(0).setPreferredWidth(72);
		JTableHD.getColumnModel().getColumn(2).setPreferredWidth(158);
		JTableHD.getColumnModel().getColumn(3).setPreferredWidth(165);
		JTableHD.getColumnModel().getColumn(6).setPreferredWidth(55);
		JTableHD.getColumnModel().getColumn(7).setPreferredWidth(111);
		scrollPane.setViewportView(JTableHD);
		
		
		cmbTenKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
					String sql = "select MAKH from KHACHHANG where TENKH = ?";
					PreparedStatement st = cons.prepareStatement(sql);
					st.setString(1, (String) cmbTenKH.getSelectedItem());
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						txtMaKH.setText(rs.getString("MAKH"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		cmbTenKH.setBounds(238, 191, 555, 29);
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
				StringBuilder sb = new StringBuilder();
				if (txtMaHD.getText().equals("")) {
					sb.append("Mã đơn hàng không được để trống");
					txtMaHD.setBackground(Color.red);
				}
				else {
					txtMaHD.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showConfirmDialog(btnSave, sb);
					return;
				}
				
				try {
					model.CTHOADON hoadon = new CTHOADON(TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY);
					hoadon.setMa_hd(txtMaHD.getText());
					hoadon.setMa_kh(txtMaKH.getText());
					hoadon.setMa_mau(txtMau.getText());
					hoadon.setMa_nv(txtMaNV.getText());
					hoadon.setMa_xe(txtMaXe.getText());
					hoadon.setDon_gia(txtThanhTien.getText());
					hoadon.setMa_ncc(txtNCC.getText());
					hoadon.setSo_luong(txtSL.getText());
					hoadon.setNgay_lap(txtNgayLap.getText());
					BanHangDao dao = new BanHangDao();
					dao.insert(hoadon);
					dao.ThemHD(hoadon);
					JOptionPane.showMessageDialog(btnSave, "Đã thêm đơn hàng thành công");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(btnSave, "Error: " + e2.getMessage());
						e2.printStackTrace();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(304, 407, 97, 31);
		panel.add(btnSave);
		
		JLabel lblNhCungCp = new JLabel("Nhà cung cấp");
		lblNhCungCp.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhCungCp.setBounds(557, 236, 89, 29);
		panel.add(lblNhCungCp);
		
		JLabel lblNga = new JLabel("Ngày lập");
		lblNga.setHorizontalAlignment(SwingConstants.LEFT);
		lblNga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNga.setBounds(481, 105, 65, 29);
		panel.add(lblNga);
		
		txtNgayLap = new JTextField();
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(557, 107, 236, 29);
		panel.add(txtNgayLap);
		
		txtNCCC = new JTextField();
		txtNCCC.setEnabled(false);
		txtNCCC.setColumns(10);
		txtNCCC.setBounds(656, 236, 137, 29);
		panel.add(txtNCCC);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(803, 147, 78, 27);
		panel.add(txtMaNV);
		txtMaNV.setEnabled(false);
		txtMaNV.setColumns(10);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(803, 191, 78, 29);
		panel.add(txtMaKH);
		txtMaKH.setEnabled(false);
		txtMaKH.setColumns(10);
		
		txtMau = new JTextField();
		txtMau.setBounds(803, 239, 78, 27);
		panel.add(txtMau);
		txtMau.setEnabled(false);
		txtMau.setColumns(10);
		txtNCC = new JTextField();
		txtNCC.setBounds(803, 292, 78, 27);
		panel.add(txtNCC);
		txtNCC.setEnabled(false);
		txtNCC.setColumns(10);
		
		txtMaXe = new JTextField();
		txtMaXe.setBounds(803, 346, 78, 29);
		panel.add(txtMaXe);
		txtMaXe.setEnabled(false);
		txtMaXe.setColumns(10);
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
			PreparedStatement st = cons.prepareStatement("  SELECT distinct  CTHOADON.MAHD, NGAYLAP , TENNV, TENKH, TENXE, TENMAU, CTHOADON.SOLUONG, CTHOADON.DONGIA from KHACHHANG,NHANVIEN, CTHOADON, MAUSAC, XEMAY, HOADON where CTHOADON.MAKH = KHACHHANG.MAKH AND CTHOADON.MANV = NHANVIEN.MANV AND CTHOADON.MAXE = XEMAY.MAXE AND CTHOADON.MAMAU = MAUSAC.MAMAU AND CTHOADON.MAHD = HOADON.MAHD ");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Object objList[] = {rs.getString("MAHD"),rs.getString("NGAYLAP"), rs.getString("TENNV"), rs.getString("TENKH"), rs.getString("TENXE"), rs.getString("TENMAU"), rs.getString("SOLUONG"), rs.getString("DONGIA")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(KHACHHANG.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}

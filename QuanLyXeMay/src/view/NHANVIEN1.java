package view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.KhachHangDao;
import Dao.NhanVienDao;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NHANVIEN1 extends JPanel {
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JPasswordField pwPass;
	private JTextField txtSDT;
	private JTextField txtLuong;
	private JTextField txtUsername;
	private JTextField txtNamSinh;
	private JTextField txtNVTK;
	private JTable JTableNV;

	/**
	 * Create the panel.
	 */
	public NHANVIEN1() {
		setLayout(null);
		
		JPanel JPanel = new JPanel();
		JPanel.setLayout(null);
		JPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPanel.setBounds(10, 10, 1026, 581);
		add(JPanel);
		
		JLabel lblNewLabel = new JLabel("Mã NV");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 146, 45, 19);
		JPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên NV");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(235, 146, 63, 19);
		JPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Năm Sinh");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(223, 192, 75, 19);
		JPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Chức Vụ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(579, 232, 69, 19);
		JPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lương CB");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(579, 146, 69, 19);
		JPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Địa Chỉ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 232, 55, 19);
		JPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("SĐT");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 192, 35, 19);
		JPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Giới Tính");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(579, 192, 63, 19);
		JPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("UserName");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(784, 143, 69, 24);
		JPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Password");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(784, 192, 69, 19);
		JPanel.add(lblNewLabel_9);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(65, 141, 124, 29);
		JPanel.add(txtMaNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(308, 141, 214, 29);
		JPanel.add(txtTenNV);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(65, 227, 457, 29);
		JPanel.add(txtDiaChi);
		
		JComboBox cmbGioiTinh = new JComboBox();
		cmbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cmbGioiTinh.setForeground(Color.BLACK);
		cmbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbGioiTinh.setBounds(656, 187, 96, 29);
		JPanel.add(cmbGioiTinh);
		
		JComboBox cmbChucVu = new JComboBox();
		cmbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Quản lý", "Bán hàng", "Tư vấn"}));
		cmbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbChucVu.setBounds(656, 227, 96, 29);
		JPanel.add(cmbChucVu);
		
		pwPass = new JPasswordField();
		pwPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pwPass.setBounds(863, 188, 153, 27);
		JPanel.add(pwPass);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setColumns(10);
		txtSDT.setBounds(65, 187, 124, 29);
		JPanel.add(txtSDT);
		
		txtLuong = new JTextField();
		txtLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLuong.setColumns(10);
		txtLuong.setBounds(656, 141, 94, 29);
		JPanel.add(txtLuong);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		txtUsername.setBounds(863, 141, 153, 29);
		JPanel.add(txtUsername);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(308, 187, 214, 29);
		JPanel.add(txtNamSinh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 361, 1006, 170);
		JPanel.add(scrollPane);
		
		JTableNV = new JTable();
		JTableNV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "N\u0103m sinh", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "S\u0110T", "Ch\u1EE9c v\u1EE5", "L\u01B0\u01A1ng", "Username", "Password"
			}
		));
		scrollPane.setViewportView(JTableNV);
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaNV.setText("");
				txtTenNV.setText("");
				txtNamSinh.setText("");
				txtDiaChi.setText("");
				txtSDT.setText("");
				txtUsername.setText("");
				pwPass.setText("");
				txtLuong.setText("");
				
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(206, 280, 112, 29);
		JPanel.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StringBuilder sb = new StringBuilder();
				if (txtMaNV.getText().equals("")) {
					sb.append("Mã khách hàng không được để trống");
					txtMaNV.setBackground(Color.red);
				}
				else {
					txtMaNV.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showConfirmDialog(btnXoa, sb);
					return;
				}
				
				if(JOptionPane.showConfirmDialog(btnXoa, "Bạn có muốn xóa nhân viên này không?") == JOptionPane.NO_OPTION) {
					return;
				}
				
				try {
					NhanVienDao dao = new NhanVienDao();
					dao.delete(txtMaNV.getText()); 
					
					JOptionPane.showMessageDialog(btnXoa, "Đã xóa khách hàng");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnXoa, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(366, 279, 112, 31);
		JPanel.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if(txtMaNV.getText().equals(""))
				{
					sb.append("Mã nhân viên không được null");
					txtMaNV.setBackground(Color.red);
				}
				else
				{
					txtMaNV.setBackground(Color.white);
				}
				
				if(sb.length()> 0)
				{
					JOptionPane.showConfirmDialog(btnSua, sb);
					return;
				}
				
				try {
					model.NHANVIEN nv = new model.NHANVIEN();
					nv.setMa_nv(txtMaNV.getText());
					nv.setTen_nv(txtTenNV.getText());
					nv.setNam_sinh(txtNamSinh.getText());
					nv.setGioi_tinh((String) cmbGioiTinh.getSelectedItem());
					nv.setDia_chi(txtDiaChi.getText());
					nv.setSdt(txtSDT.getText());
					nv.setChuc_vu((String)cmbChucVu.getSelectedItem());
					nv.setLuong_cb(txtLuong.getText());
					nv.setUsername(txtUsername.getText());
					nv.setPassword(pwPass.getText());
					
					NhanVienDao dao = new NhanVienDao();
					dao.update(nv);
					
					JOptionPane.showMessageDialog(btnSua, "Nhân viên được lưu.");
				}
				catch(Exception ex) {
					JOptionPane.showConfirmDialog(btnSua, "Error: "+ ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(533, 280, 106, 29);
		JPanel.add(btnSua);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(892, 545, 124, 29);
		JPanel.add(btnThoat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(206, 267, 629, 2);
		JPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(206, 320, 629, 2);
		JPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 98, 1006, 2);
		JPanel.add(separator_2);
		
		JLabel lblNewLabel_10 = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblNewLabel_10.setForeground(Color.BLUE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(10, 110, 179, 20);
		JPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("DANH SÁCH NHÂN VIÊN");
		lblNewLabel_10_1.setForeground(Color.BLUE);
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_1.setBounds(10, 330, 185, 20);
		JPanel.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_2 = new JLabel("TÌM KIẾM");
		lblNewLabel_10_2.setForeground(Color.BLUE);
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_2.setBounds(10, 23, 89, 20);
		JPanel.add(lblNewLabel_10_2);
		
		txtNVTK = new JTextField();
		txtNVTK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNVTK.setColumns(10);
		txtNVTK.setBounds(308, 49, 214, 29);
		JPanel.add(txtNVTK);
		
		JLabel lblMNhnVin = new JLabel("Mã Nhân Viên");
		lblMNhnVin.setForeground(Color.BLACK);
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhnVin.setBackground(Color.WHITE);
		lblMNhnVin.setBounds(192, 49, 106, 24);
		JPanel.add(lblMNhnVin);
		
		JButton btnTimKiem = new JButton("TÌM");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNVTK.getText().equals("")) {
					JOptionPane.showMessageDialog(btnTimKiem, "Nhập mã khách hàng cần tìm kiếm");
					return;
				}
				try {
					NhanVienDao dao = new NhanVienDao();
					
					model.NHANVIEN nhanvien = dao.FindbyID(txtNVTK.getText());
					
					if(nhanvien != null) {
						txtMaNV.setText(nhanvien.getMa_nv());
						txtTenNV.setText(nhanvien.getTen_nv());
						txtNamSinh.setText(nhanvien.getNam_sinh());
						cmbGioiTinh.setSelectedItem(cmbGioiTinh);
						txtDiaChi.setText(nhanvien.getDia_chi());
						txtSDT.setText(nhanvien.getSdt());
						cmbChucVu.setSelectedItem(cmbChucVu);
						txtLuong.setText(nhanvien.getLuong_cb());
						txtUsername.setText(nhanvien.getUsername());
						pwPass.setText(nhanvien.getPassword());
					}
					else {
						JOptionPane.showMessageDialog(btnTimKiem, "Không tìm thấy nhân viên");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnTimKiem, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(553, 46, 106, 35);
		JPanel.add(btnTimKiem);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 10, 1006, 2);
		JPanel.add(separator_2_1);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						StringBuilder sb = new StringBuilder();
						if(txtMaNV.getText().equals(""))
						{
							sb.append("Mã nhân viên không được null");
							txtMaNV.setBackground(Color.red);
						}
						else
						{
							txtMaNV.setBackground(Color.white);
						}
						
						if(sb.length()> 0)
						{
							JOptionPane.showConfirmDialog(btnLuu, sb);
							return;
						}
						
						try {
							model.NHANVIEN nv = new model.NHANVIEN();
							nv.setMa_nv(txtMaNV.getText());
							nv.setTen_nv(txtTenNV.getText());
							nv.setNam_sinh(txtNamSinh.getText());
							nv.setGioi_tinh((String) cmbGioiTinh.getSelectedItem());
							nv.setDia_chi(txtDiaChi.getText());
							nv.setSdt(txtSDT.getText());
							nv.setChuc_vu((String)cmbChucVu.getSelectedItem());
							nv.setLuong_cb(txtLuong.getText());
							nv.setUsername(txtUsername.getText());
							nv.setPassword(pwPass.getText());
							
							NhanVienDao dao = new NhanVienDao();
							dao.insert(nv);
							
							JOptionPane.showMessageDialog(btnLuu, "Nhân viên được lưu.");
						}
						catch(Exception ex) {
							JOptionPane.showConfirmDialog(btnLuu, "Error: "+ ex.getMessage());
							ex.printStackTrace();
						}
					}
				});
				btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnLuu.setBounds(723, 280, 112, 29);
				JPanel.add(btnLuu);
		
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("Select * from NHANVIEN");
			ResultSet rs = st.executeQuery();
			DefaultTableModel model = (DefaultTableModel) JTableNV.getModel();
			while (rs.next()) {
				Object objList[] = {rs.getString("MANV"), rs.getString("TENNV"), rs.getInt("NAMSINH"), rs.getString("GIOITINH"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("CHUCVU"), rs.getString("LUONGCOBAN"), rs.getString("USERNAME"), rs.getString("PASSWORD")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(NHANVIEN1.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}

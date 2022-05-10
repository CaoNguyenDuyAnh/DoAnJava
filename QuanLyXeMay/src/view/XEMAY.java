package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.XeDao;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.awt.event.ActionEvent;

public class XEMAY extends JPanel {
	private JTextField txtMAXE;
	private JTextField txtMaXe;
	private JTextField txtTenXe;
	private JComboBox CBLoaiXe;
	private JTextField txtMoTa;
	private JComboBox CBDungTich;
	private JTextField txtSoLuong;
	private JTextField txtGiaBan;
	private JComboBox CBMaMau;
	private JComboBox CBMaNcc;
	
	
	private JTable JTableXe;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public XEMAY() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00CCM KI\u1EBEM XE M\u00C1Y");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 132, 19);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 xe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(166, 15, 34, 13);
		add(lblNewLabel_1);
		
		txtMAXE = new JTextField();
		txtMAXE.setBounds(220, 12, 132, 19);
		add(txtMAXE);
		txtMAXE.setColumns(10);
		
		JButton btnTimKiem = new JButton("T\u00ECm ki\u1EBFm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMAXE.getText().equals("")) {
					JOptionPane.showMessageDialog(btnTimKiem, "Nhập mã xe cần tìm kiếm?");
					return;
				}
				try {
					XeDao dao = new XeDao();
					
					model.XEMAY xemay = dao.FindbyID(txtMAXE.getText());
					
					if(xemay != null) {
						txtMaXe.setText(xemay.getMa_xe());
						txtTenXe.setText(xemay.getTen_xe());
						CBLoaiXe.getSelectedItem();
						txtMoTa.setText(xemay.getMo_ta());
						txtSoLuong.setText(xemay.getSo_luong());
						txtGiaBan.setText(xemay.getGia_ban());
						CBLoaiXe.getSelectedItem();
						CBDungTich.getSelectedItem();
						CBMaMau.getSelectedItem();
						CBMaNcc.getSelectedItem();
					}
					else {
						JOptionPane.showMessageDialog(btnTimKiem, "Không tìm thấy xe!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnTimKiem, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}		
			}
		
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimKiem.setBounds(365, 10, 85, 21);
		add(btnTimKiem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 51, 806, 2);
		add(separator);
		
		JLabel lblQungLXe = new JLabel("TH\u00D4NG TIN XE M\u00C1Y");
		lblQungLXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQungLXe.setBounds(10, 63, 146, 26);
		add(lblQungLXe);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u00E3 xe");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(54, 99, 34, 13);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("T\u00EAn xe");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(274, 99, 70, 13);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Lo\u1EA1i xe");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(495, 99, 49, 13);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("M\u00F4 t\u1EA3");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(54, 122, 34, 13);
		add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(54, 145, 49, 13);
		add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Gi\u00E1 b\u00E1n");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_6.setBounds(278, 145, 49, 13);
		add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Dung t\u00EDch");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_7.setBounds(499, 145, 61, 13);
		add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("M\u00E3 m\u00E0u");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_8.setBounds(54, 168, 49, 13);
		add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("M\u00E3 NCC");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_9.setBounds(278, 168, 49, 13);
		add(lblNewLabel_1_9);
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(132, 120, 572, 19);
		add(txtMoTa);
		
		txtMaXe = new JTextField();
		txtMaXe.setColumns(10);
		txtMaXe.setBounds(132, 97, 132, 19);
		add(txtMaXe);
		
		txtTenXe = new JTextField();
		txtTenXe.setColumns(10);
		txtTenXe.setBounds(328, 97, 132, 19);
		add(txtTenXe);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(54, 218, 668, 2);
		add(separator_1);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(132, 143, 132, 19);
		add(txtSoLuong);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(328, 143, 132, 19);
		add(txtGiaBan);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMaXe.getText().equals("")) {
					sb.append("Mã xe không được để trống");
					txtMaXe.setBackground(Color.red);
				}
				else {
					txtMaXe.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showMessageDialog(btnLuu, sb);
					return;
				}
				
				try {
					model.XEMAY xemay = new model.XEMAY();
					txtMaXe.setText(xemay.getMa_xe());
					txtTenXe.setText(xemay.getTen_xe());
					CBLoaiXe.getSelectedItem();
					txtMoTa.setText(xemay.getMo_ta());
					txtSoLuong.setText(xemay.getSo_luong());
					txtGiaBan.setText(xemay.getGia_ban());
					CBLoaiXe.getSelectedItem();
					CBDungTich.getSelectedItem();
					CBMaMau.getSelectedItem();
					CBMaNcc.getSelectedItem();
					
					
					XeDao dao = new XeDao();
					dao.insert(xemay);
					
					JOptionPane.showMessageDialog(btnLuu, "Lưu thành công");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLuu, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(83, 230, 85, 21);
		add(btnLuu);
		
		JButton btnNhapMoi = new JButton("Nh\u1EADp m\u1EDBi");
		btnNhapMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaXe.setText("");
				txtTenXe.setText("");
				CBLoaiXe.getSelectedItem();
				txtMoTa.setText("");
				txtSoLuong.setText("");
				txtGiaBan.setText("");
				CBLoaiXe.getSelectedItem();
				CBDungTich.getSelectedItem();
				CBMaMau.getSelectedItem();
				CBMaNcc.getSelectedItem();
			}
		});
		btnNhapMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNhapMoi.setBounds(274, 230, 85, 21);
		add(btnNhapMoi);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMaXe.getText().equals("")) {
					sb.append("Mã xe không được để trống");
					txtMaXe.setBackground(Color.red);
				}
				else {
					txtMaXe.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showMessageDialog(btnLuu, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(btnCapNhat, "Bạn có muốn cập nhật xe này không") == JOptionPane.NO_OPTION) {
					return;
				}
				
				try {
					model.XEMAY xemay = new model.XEMAY();
					txtMaXe.setText(xemay.getMa_xe());
					txtTenXe.setText(xemay.getTen_xe());
					CBLoaiXe.getSelectedItem();
					txtMoTa.setText(xemay.getMo_ta());
					txtSoLuong.setText(xemay.getSo_luong());
					txtGiaBan.setText(xemay.getGia_ban());
					CBLoaiXe.getSelectedItem();
					CBDungTich.getSelectedItem();
					CBMaMau.getSelectedItem();
					CBMaNcc.getSelectedItem();
					
					
					XeDao dao = new XeDao();
					dao.update(xemay);
					
					JOptionPane.showMessageDialog(btnLuu, "Cập nhật thành công");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLuu, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}
			
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCapNhat.setBounds(460, 230, 85, 21);
		add(btnCapNhat);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMaXe.getText().equals("")) {
					sb.append("Mã xe không được để trống");
					txtMaXe.setBackground(Color.red);
				}
				else {
					txtMaXe.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showMessageDialog(btnLuu, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(btnXoa, "Bạn có muốn xóa xe này không?") == JOptionPane.NO_OPTION) {
					return;
				}

				
				try {
					
					
					XeDao dao = new XeDao();
					dao.delete(txtMaXe.getText());					
					JOptionPane.showMessageDialog(btnLuu, "Xóa thành công");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLuu, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(619, 230, 85, 21);
		add(btnXoa);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(54, 265, 668, 2);
		add(separator_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 295, 721, 184);
		add(scrollPane);
		
		JTableXe = new JTable();
		JTableXe.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 xe", "T\u00EAn xe", "Lo\u1EA1i xe", "M\u00F4 t\u1EA3", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 b\u00E1n", "Dung t\u00EDch", "M\u00E3 m\u00E0u", "M\u00E3 NCC"
			}
		));
		scrollPane.setViewportView(JTableXe);
		
		JComboBox CBMaMau = new JComboBox();
		CBMaMau.setEditable(true);
		CBMaMau.setBackground(Color.WHITE);
		CBMaMau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CBMaMau.setModel(new DefaultComboBoxModel(new String[] {"", "MAU01", "MAU02", "MAU03", "MAU04", "MAU05", "MAU06"}));
		CBMaMau.setBounds(132, 165, 132, 21);
		add(CBMaMau);
		
		JComboBox CBDungTich = new JComboBox();
		CBDungTich.setModel(new DefaultComboBoxModel(new String[] {"", "50cc", "100cc", "125cc", "150cc", "155cc"}));
		CBDungTich.setSelectedIndex(0);
		CBDungTich.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CBDungTich.setBackground(Color.WHITE);
		CBDungTich.setBounds(572, 142, 132, 21);
		add(CBDungTich);
		
		JComboBox CBMaNcc = new JComboBox();
		CBMaNcc.setModel(new DefaultComboBoxModel(new String[] {"", "NCC01", "NCC02", "NCC03", "NCC04"}));
		CBMaNcc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CBMaNcc.setEditable(true);
		CBMaNcc.setBackground(Color.WHITE);
		CBMaNcc.setBounds(328, 165, 132, 21);
		add(CBMaNcc);
		
		JComboBox CBLoaiXe = new JComboBox();
		CBLoaiXe.setModel(new DefaultComboBoxModel(new String[] {"", "Xe s\u1ED1", "Xe tay ga", "Xe tay c\u00F4n"}));
		CBLoaiXe.setSelectedIndex(0);
		CBLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CBLoaiXe.setBackground(Color.WHITE);
		CBLoaiXe.setBounds(572, 96, 132, 21);
		add(CBLoaiXe);
		
		textField = new JTextField();
		textField.setBounds(132, 196, 96, 19);
		add(textField);
		textField.setColumns(10);

		
		DefaultTableModel model = (DefaultTableModel) JTableXe.getModel();
		
		
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("Select * from XEMAY");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Object objList[] = {rs.getString("MAXE"), rs.getString("TENXE"), rs.getString("LOAIXE"), rs.getString("MOTA"), rs.getString("SLHIENCO"), rs.getString("GIABAN"), rs.getString("DUNGTICH"), rs.getString("MAMAU"), rs.getString("MANCC")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(KHACHHANG.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
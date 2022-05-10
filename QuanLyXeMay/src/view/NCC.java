package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.NCCDao;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.awt.event.ActionEvent;

public class NCC extends JPanel {
	private JTextField txtMaNCC;
	private JTextField txtMaNcc;
	private JTextField txtTenNcc;
	private JTextField txtSdt;
	private JTextField txtDiachi;
	private JTable JTableNCC;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public NCC() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00CCM KI\u1EBEM");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 75, 19);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 NCC");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(197, 12, 45, 13);
		add(lblNewLabel_1);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setBounds(252, 9, 96, 19);
		add(txtMaNCC);
		txtMaNCC.setColumns(10);
		
		JButton btnTimKiem = new JButton("T\u00ECm Ki\u1EBFm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMaNCC.getText().equals("")) {
					JOptionPane.showMessageDialog(btnTimKiem, "Nhập mã nhà cung cấp cần phải tìm kiếm");
					return;
				}
				try {
					NCCDao dao = new NCCDao();
					
					model.NCC ncc = dao.FindbyID(txtMaNCC.getText());
					
					if(ncc != null) {
						txtMaNcc.setText(ncc.getMa_ncc());
						txtTenNcc.setText(ncc.getTen_ncc());
						txtDiachi.setText(ncc.getDia_chi());
						txtSdt.setText(ncc.getSdt());
						txtEmail.setText(ncc.getEmail());
					}
					else {
						JOptionPane.showMessageDialog(btnTimKiem, "Không tìm thấy nhà cung cấp");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnTimKiem, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}		
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimKiem.setBounds(358, 8, 85, 21);
		add(btnTimKiem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 39, 606, 2);
		add(separator);
		
		JLabel lblThngTinNh = new JLabel("TH\u00D4NG TIN NH\u00C0 CUNG C\u1EA4P ");
		lblThngTinNh.setForeground(Color.BLUE);
		lblThngTinNh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThngTinNh.setBounds(10, 56, 236, 19);
		add(lblThngTinNh);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u00E3 NCC");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(197, 95, 45, 13);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("T\u00EAn NCC");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(197, 118, 75, 13);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("S\u0110T");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(197, 170, 45, 13);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(197, 141, 45, 13);
		add(lblNewLabel_1_4);
		
		txtMaNcc = new JTextField();
		txtMaNcc.setBounds(308, 95, 96, 19);
		add(txtMaNcc);
		txtMaNcc.setColumns(10);
		
		txtTenNcc = new JTextField();
		txtTenNcc.setColumns(10);
		txtTenNcc.setBounds(308, 116, 192, 19);
		add(txtTenNcc);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(308, 168, 181, 19);
		add(txtSdt);
		
		txtDiachi = new JTextField();
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(308, 139, 291, 19);
		add(txtDiachi);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMaNcc.getText().equals("")) {
					sb.append("Mã nhà cung cấp không được để trống");
					txtMaNcc.setBackground(Color.red);
				}
				else {
					txtMaNcc.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showMessageDialog(btnLuu, sb);
					return;
				}
				
				try {
					model.NCC ncc = new model.NCC();
					ncc.setMa_ncc(txtMaNcc.getText());
					ncc.setTen_ncc(txtTenNcc.getText());
					ncc.setDia_chi(txtDiachi.getText());
					ncc.setSdt(txtSdt.getText());
					ncc.setSdt(txtEmail.getText());
					
					
					NCCDao dao = new NCCDao();
					dao.insert(ncc);
					
					JOptionPane.showMessageDialog(btnLuu, "Lưu thành công");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLuu, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
			
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(182, 232, 85, 21);
		add(btnLuu);
		
		JButton btnNhapMoi = new JButton("Nh\u1EADp m\u1EDBi");
		btnNhapMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaNcc.setText("");
				txtTenNcc.setText("");
				txtDiachi.setText("");
				txtSdt.setText("");
				txtEmail.setText("");
			}
		});
		btnNhapMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNhapMoi.setBounds(292, 232, 85, 21);
		add(btnNhapMoi);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMaNcc.getText().equals("")) {
					sb.append("Mã nhà cung cấp không được để trống");
					txtMaNcc.setBackground(Color.red);
				}
				else {
					txtMaNcc.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showMessageDialog(btnLuu, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(btnCapNhat, "Bạn có muốn cập nhật nhà cung cấp này không?") == JOptionPane.NO_OPTION) {
					return;
				}
				
				try {
					model.NCC ncc = new model.NCC();
					ncc.setMa_ncc(txtMaNcc.getText());
					ncc.setTen_ncc(txtTenNcc.getText());
					ncc.setDia_chi(txtDiachi.getText());
					ncc.setSdt(txtSdt.getText());
					ncc.setSdt(txtEmail.getText());
					
					
					NCCDao dao = new NCCDao();
					dao.update(ncc);
					
					JOptionPane.showMessageDialog(btnLuu, "Cập nhật thành công");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLuu, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}
			
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCapNhat.setBounds(399, 232, 85, 21);
		add(btnCapNhat);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMaNcc.getText().equals("")) {
					sb.append("Mã nhà cung cấp không được để trống");
					txtMaNcc.setBackground(Color.red);
				}
				else {
					txtMaNcc.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showMessageDialog(btnLuu, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(btnXoa, "Bạn có muốn xóa nhà cung cấp này không?") == JOptionPane.NO_OPTION) {
					return;
				}

				
				try {
					
					
					NCCDao dao = new NCCDao();
					dao.delete(txtMaNcc.getText());					
					JOptionPane.showMessageDialog(btnLuu, "Xóa thành công");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLuu, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(514, 232, 85, 21);
		add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 307, 702, 205);
		add(scrollPane);
		
		JTableNCC = new JTable();
		JTableNCC.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 NCC", "T\u00EAn NCC", "\u0110\u1ECBa ch\u1EC9", "S\u0110T", "Email"
			}
		));
		JTableNCC.getColumnModel().getColumn(0).setPreferredWidth(56);
		JTableNCC.getColumnModel().getColumn(1).setPreferredWidth(122);
		JTableNCC.getColumnModel().getColumn(2).setPreferredWidth(171);
		JTableNCC.getColumnModel().getColumn(3).setPreferredWidth(90);
		JTableNCC.getColumnModel().getColumn(4).setPreferredWidth(170);
		scrollPane.setViewportView(JTableNCC);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Email");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1.setBounds(197, 193, 45, 13);
		add(lblNewLabel_1_3_1);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(308, 191, 181, 19);
		add(txtEmail);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(84, 220, 606, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(84, 263, 606, 2);
		add(separator_2);

		
		
		DefaultTableModel model = (DefaultTableModel) JTableNCC.getModel();
		
		
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("Select * from NCC");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Object objList[] = {rs.getString("MANCC"), rs.getString("TENNCC"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("EMAIL")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(KHACHHANG.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.KhachHangDao;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class KHACHHANG extends JPanel {
	private JTable JTableKH;
	private JTextField txtMa;
	private JTextField txtSDT;
	private JTextField txtTen;
	private JTextField txtDC;
	private JTextField txtEmail;
	private JTextField txtTKKH;

	/**
	 * Create the panel.
	 */
	public KHACHHANG() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 929, 683);
		add(panel);
		panel.setLayout(null);
		
		JButton btnSave = new JButton("Lưu");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMa.getText().equals("")) {
					sb.append("Mã khách hàng không được để trống");
					txtMa.setBackground(Color.red);
				}
				else {
					txtMa.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showConfirmDialog(btnSave, sb);
					return;
				}
				
				try {
					model.KHACHHANG khachhang = new model.KHACHHANG(TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY);
					khachhang.setMa_kh(txtMa.getText());
					khachhang.setTen_kh(txtTen.getText());
					khachhang.setDia_chi(txtDC.getText());
					khachhang.setSdt(txtSDT.getText());
					khachhang.setEmail(txtEmail.getText());
					
					KhachHangDao dao = new KhachHangDao();
					dao.insert(khachhang);
					
					JOptionPane.showMessageDialog(btnSave, "Đã thêm khách hàng thành công");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnSave, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(151, 355, 97, 31);
		panel.add(btnSave);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMa.getText().equals("")) {
					sb.append("Mã khách hàng không được để trống");
					txtMa.setBackground(Color.red);
				}
				else {
					txtMa.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showConfirmDialog(btnSave, sb);
					return;
				}
				
				if(JOptionPane.showConfirmDialog(btnDelete, "Bạn có muốn xóa khách hàng này không?") == JOptionPane.NO_OPTION) {
					return;
				}
				
				try {
					KhachHangDao dao = new KhachHangDao();
					dao.delete(txtMa.getText()); 
					
					JOptionPane.showMessageDialog(btnSave, "Đã xóa khách hàng");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnSave, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(658, 355, 97, 31);
		panel.add(btnDelete);
		
		JButton btnNew = new JButton("Nhập mới");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMa.setText("");
				txtTen.setText("");
				txtDC.setText("");
				txtEmail.setText("");
				txtSDT.setText("");
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNew.setBounds(269, 355, 174, 31);
		panel.add(btnNew);
		
		JButton btnFind = new JButton("Tìm kiếm");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTKKH.getText().equals("")) {
					JOptionPane.showMessageDialog(btnFind, "Nhập mã khách hàng cần tìm kiếm");
					return;
				}
				try {
					KhachHangDao dao = new KhachHangDao();
					
					model.KHACHHANG khachhang = dao.FindbyID(txtTKKH.getText());
					
					if(khachhang != null) {
						txtMa.setText(khachhang.getMa_kh());
						txtTen.setText(khachhang.getTen_kh());
						txtDC.setText(khachhang.getDia_chi());
						txtSDT.setText(khachhang.getSdt());
						txtEmail.setText(khachhang.getEmail());
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
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (txtMa.getText().equals("")) {
					sb.append("Mã khách hàng không được để trống");
					txtMa.setBackground(Color.red);
				}
				else {
					txtMa.setBackground(Color.white);
				}
				if (sb.length()>0) {
					JOptionPane.showConfirmDialog(btnSave, sb);
					return;
				}
				
				if(JOptionPane.showConfirmDialog(btnUpdate, "Bạn có muốn thay đổi thông tin của khách hàng này không?") == JOptionPane.NO_OPTION) {
					return;
				}
				
				try {
					model.KHACHHANG khachhang = new model.KHACHHANG(TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY);
					khachhang.setMa_kh(txtMa.getText());
					khachhang.setTen_kh(txtTen.getText());
					khachhang.setDia_chi(txtDC.getText());
					khachhang.setSdt(txtSDT.getText());
					khachhang.setEmail(txtEmail.getText());
					
					KhachHangDao dao = new KhachHangDao();
					dao.update(khachhang);
					
					JOptionPane.showMessageDialog(btnSave, "Đã cập nhật khách hàng thành công");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnSave, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(463, 355, 174, 31);
		panel.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 442, 866, 196);
		panel.add(scrollPane);
		
		JTableKH = new JTable();
		scrollPane.setViewportView(JTableKH);
		JTableKH.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "\u0110\u1ECBa ch\u1EC9 ", " S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email"
			}
		));
		JTableKH.getColumnModel().getColumn(0).setPreferredWidth(80);
		JTableKH.getColumnModel().getColumn(1).setPreferredWidth(160);
		JTableKH.getColumnModel().getColumn(2).setPreferredWidth(160);
		JTableKH.getColumnModel().getColumn(3).setPreferredWidth(135);
		JTableKH.getColumnModel().getColumn(4).setPreferredWidth(135);
		
		JLabel lblNewLabel = new JLabel("Mã khách hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(72, 121, 117, 29);
		panel.add(lblNewLabel);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(199, 123, 149, 29);
		panel.add(txtMa);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(363, 121, 104, 29);
		panel.add(lblSinThoi);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(467, 123, 287, 29);
		panel.add(txtSDT);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(199, 173, 555, 29);
		panel.add(txtTen);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(72, 173, 117, 29);
		panel.add(lblTnKhchHng);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setHorizontalAlignment(SwingConstants.CENTER);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(72, 223, 117, 29);
		panel.add(lblaCh);
		
		txtDC = new JTextField();
		txtDC.setColumns(10);
		txtDC.setBounds(199, 225, 555, 29);
		panel.add(txtDC);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(199, 277, 555, 29);
		panel.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(72, 275, 117, 29);
		panel.add(lblEmail);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 10, 900, 2);
		panel.add(separator_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(222, 22, 117, 29);
		panel.add(lblNewLabel_1);
		
		txtTKKH = new JTextField();
		txtTKKH.setColumns(10);
		txtTKKH.setBounds(349, 22, 149, 29);
		panel.add(txtTKKH);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setBounds(10, 63, 900, 2);
		panel.add(separator_2_1_1);
		
		JLabel lblNewLabel_10_2 = new JLabel("TÌM KIẾM");
		lblNewLabel_10_2.setForeground(Color.BLUE);
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_2.setBounds(20, 27, 89, 20);
		panel.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10 = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblNewLabel_10.setForeground(Color.BLUE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(20, 75, 203, 20);
		panel.add(lblNewLabel_10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(141, 343, 629, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(141, 396, 629, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel_10_1.setForeground(Color.BLUE);
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_1.setBounds(20, 412, 228, 20);
		panel.add(lblNewLabel_10_1);
		DefaultTableModel model = (DefaultTableModel) JTableKH.getModel();
		
		
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("Select * from KHACHHANG");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Object objList[] = {rs.getString("MAKH"), rs.getString("TENKH"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("EMAIL")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(KHACHHANG.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}

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

public class KHACHHANG extends JPanel {
	private JTable JTableKH;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDC;
	private JTextField txtSDT;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public KHACHHANG() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 962, 683);
		add(panel);
		panel.setLayout(null);
		
		JTableKH = new JTable();
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
		JTableKH.setBounds(10, 384, 875, 289);
		panel.add(JTableKH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 51, 875, 323);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Mã khách hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 40, 117, 29);
		panel_1.add(lblNewLabel);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(137, 40, 149, 29);
		panel_1.add(txtMa);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(10, 107, 117, 29);
		panel_1.add(lblTnKhchHng);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setHorizontalAlignment(SwingConstants.CENTER);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(10, 179, 117, 29);
		panel_1.add(lblaCh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(296, 40, 117, 29);
		panel_1.add(lblSinThoi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 243, 117, 29);
		panel_1.add(lblEmail);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(137, 107, 555, 29);
		panel_1.add(txtTen);
		
		txtDC = new JTextField();
		txtDC.setColumns(10);
		txtDC.setBounds(137, 186, 555, 29);
		panel_1.add(txtDC);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(405, 42, 287, 29);
		panel_1.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(137, 245, 555, 29);
		panel_1.add(txtEmail);
		
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
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(10, 10, 97, 31);
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
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(643, 10, 97, 31);
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
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNew.setBounds(117, 10, 174, 31);
		panel.add(btnNew);
		
		JButton btnFind = new JButton("Tìm kiếm");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMa.getText().equals("")) {
					JOptionPane.showMessageDialog(btnFind, "Nhập mã khách hàng cần tìm kiếm");
					return;
				}
				try {
					KhachHangDao dao = new KhachHangDao();
					
					model.KHACHHANG khachhang = dao.FindbyID(txtMa.getText());
					
					if(khachhang != null) {
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
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFind.setBounds(485, 10, 148, 31);
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
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(301, 10, 174, 31);
		panel.add(btnUpdate);
		
		
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("Select * from KHACHHANG");
			ResultSet rs = st.executeQuery();
			DefaultTableModel model = (DefaultTableModel) JTableKH.getModel();
			while (rs.next()) {
				Object objList[] = {rs.getString("MAKH"), rs.getString("TENKH"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("EMAIL")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(NHANVIEN.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}

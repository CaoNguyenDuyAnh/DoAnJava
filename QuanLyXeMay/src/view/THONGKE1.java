package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.CTHDDao;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class THONGKE1 extends JPanel {
	private JTextField txtMaXe;
	private JTextField txtSL;
	private JTextField txtMaHD;
	private JTextField txtDonGia;
	private JTextField txtThue;
	private JTextField txtTimKiem;
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	public THONGKE1() {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Mã xe");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(391, 174, 43, 20);
		add(lblNewLabel);
		
		
		JLabel lblThngTinChi = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblThngTinChi.setForeground(Color.BLUE);
		lblThngTinChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinChi.setBounds(325, 10, 198, 27);
		add(lblThngTinChi);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 43, 898, 2);
		add(separator);
		
		txtMaXe = new JTextField();
		txtMaXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaXe.setColumns(10);
		txtMaXe.setBounds(460, 174, 124, 20);
		add(txtMaXe);
		
		JLabel lblMHan = new JLabel("Mã hóa đơn");
		lblMHan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMHan.setBounds(74, 174, 85, 20);
		add(lblMHan);
		
		txtSL = new JTextField();
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSL.setColumns(10);
		txtSL.setBounds(180, 241, 124, 20);
		add(txtSL);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSLng.setBounds(84, 241, 75, 20);
		add(lblSLng);
		
		JLabel lblnGia = new JLabel("Đơn giá");
		lblnGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnGia.setBounds(369, 241, 63, 20);
		add(lblnGia);
		
		JLabel lblThu = new JLabel("Thuế");
		lblThu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThu.setBounds(659, 174, 43, 20);
		add(lblThu);
		
		txtMaHD = new JTextField();
		txtMaHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(180, 174, 124, 20);
		add(txtMaHD);
		
		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(460, 241, 124, 20);
		add(txtDonGia);
		
		txtThue = new JTextField();
		txtThue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtThue.setColumns(10);
		txtThue.setBounds(708, 174, 124, 20);
		add(txtThue);
		
		JButton btnPrint = new JButton("In danh sách");
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrint.setBounds(10, 311, 124, 37);
		add(btnPrint);
		
		JButton btnTroVe = new JButton("Trở về");
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTroVe.setBounds(823, 311, 85, 37);
		add(btnTroVe);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 298, 898, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 87, 898, 2);
		add(separator_2);
		
		JLabel lblNhpMHa = new JLabel("Nhập mã hóa đơn");
		lblNhpMHa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhpMHa.setBounds(156, 56, 137, 20);
		add(lblNhpMHa);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(325, 58, 198, 20);
		add(txtTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTimKiem.getText().equals("")) {
					JOptionPane.showMessageDialog(btnTimKiem, "Nhập mã hóa đơn cần tìm");
					return;
				}
				try {
					CTHDDao dao = new CTHDDao();
					
					model.ChiTietHoaDon ct = dao.FindbyID(txtTimKiem.getText());
					
					if(ct != null) {
						txtMaHD.setText(ct.getMAHD());
						txtMaXe.setText(ct.getMAXE());
						txtSL.setText(ct.getSOLUONG());
						txtDonGia.setText(ct.getDONGIA());
						txtThue.setText(ct.getTHUE());
					}
					else {
						JOptionPane.showMessageDialog(btnTimKiem, "Không tìm thấy");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnTimKiem, "Error: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(573, 53, 85, 27);
		add(btnTimKiem);
		
		JLabel lblThngTin = new JLabel("THÔNG TIN");
		lblThngTin.setForeground(Color.BLUE);
		lblThngTin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblThngTin.setBounds(369, 122, 95, 20);
		add(lblThngTin);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 153, 898, 2);
		add(separator_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 359, 898, 165);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 xe", " M\u00E3 h\u00F3a \u0111\u01A1n", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Thu\u1EBF"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JLabel JlabelDoanhThu = new JLabel("Tổng doanh thu");
		JlabelDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JlabelDoanhThu.setBounds(598, 535, 310, 20);
		add(JlabelDoanhThu);
		
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("Select MAXE, MAHD, SOLUONG, DONGIA, THUE from CTHOADON");
			ResultSet rs = st.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			while (rs.next()) {
				Object objList[] = {rs.getString("MAXE"), rs.getString("MAHD"), rs.getInt("SOLUONG"), rs.getLong("DONGIA"), rs.getInt("THUE")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(THONGKE1.class.getName()).log(Level.SEVERE, null, e);
		}	
		DecimalFormat xDecimalFormat = new DecimalFormat("###,###,###");
		int tong = 0;
		for( int i = 0 ; i < table.getRowCount(); i++) {
			tong+= Integer.parseInt(table.getValueAt(i,3).toString());
		}
		JlabelDoanhThu.setText("Tổng doanh thu:"+"  " +xDecimalFormat.format(tong) + " VNĐ");

	}
}


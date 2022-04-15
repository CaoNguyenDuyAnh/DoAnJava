package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NHANVIEN extends JPanel {
	private JTable JTableNV;

	/**
	 * Create the panel.
	 */
	public NHANVIEN() {
		setLayout(null);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 859, 515);
		add(panel);
		panel.setLayout(null);
		
		JTableNV = new JTable();
		JTableNV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 NV", "T\u00EAn NV", "N\u0103m sinh", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "S\u0110T", "Ch\u1EE9c v\u1EE5", "L\u01B0\u01A1ng c\u01A1 b\u1EA3ng", "USERNAME", "PASSWORD"
			}
		));
		JTableNV.getColumnModel().getColumn(0).setPreferredWidth(45);
		JTableNV.getColumnModel().getColumn(1).setPreferredWidth(120);
		JTableNV.getColumnModel().getColumn(2).setPreferredWidth(52);
		JTableNV.getColumnModel().getColumn(3).setPreferredWidth(47);
		JTableNV.getColumnModel().getColumn(4).setPreferredWidth(300);
		JTableNV.getColumnModel().getColumn(5).setPreferredWidth(85);
		JTableNV.getColumnModel().getColumn(6).setPreferredWidth(80);
		JTableNV.getColumnModel().getColumn(7).setPreferredWidth(80);
		JTableNV.setBounds(10, 254, 875, 251);
		panel.add(JTableNV);
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("Select * from NHANVIEN");
			ResultSet rs = st.executeQuery();
			DefaultTableModel model = (DefaultTableModel) JTableNV.getModel();
			while (rs.next()) {
				Object objList[] = {rs.getString("MANV"), rs.getString("TENNV"), rs.getInt("NAMSINH"), rs.getString("GIOITINH"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("CHUCVU"), rs.getInt("LUONGCOBAN"), rs.getString("USERNAME"), rs.getString("PASSWORD")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(NHANVIEN.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}

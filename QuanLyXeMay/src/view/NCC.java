package view;

import javax.swing.JPanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NCC extends JPanel {
	private JTable JTableNCC;

	/**
	 * Create the panel.
	 */
	public NCC() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 522);
		add(panel);
		panel.setLayout(null);
		
		JTableNCC = new JTable();
		JTableNCC.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 NCC", "T\u00EAn NCC", "\u0110\u1ECBa ch\u1EC9", "S\u0110T", "Email"
			}
		));
		JTableNCC.getColumnModel().getColumn(0).setPreferredWidth(49);
		JTableNCC.getColumnModel().getColumn(1).setPreferredWidth(140);
		JTableNCC.getColumnModel().getColumn(2).setPreferredWidth(300);
		JTableNCC.getColumnModel().getColumn(3).setPreferredWidth(80);
		JTableNCC.getColumnModel().getColumn(4).setPreferredWidth(150);
		JTableNCC.setBounds(10, 254, 875, 251);
		panel.add(JTableNCC);
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("Select * from NCC");
			ResultSet rs = st.executeQuery();
			DefaultTableModel model = (DefaultTableModel) JTableNCC.getModel();
			while (rs.next()) {
				Object objList[] = {rs.getString("MANCC"), rs.getString("TENNCC"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("EMAIL")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(NHANVIEN.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}

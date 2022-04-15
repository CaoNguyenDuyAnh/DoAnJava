package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class XEMAY extends JPanel {
	private JTable JTableXe;

	/**
	 * Create the panel.
	 */
	public XEMAY() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 877, 523);
		add(panel);
		panel.setLayout(null);
		
		JTableXe = new JTable();
		JTableXe.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 xe", "T\u00EAn xe", "Lo\u1EA1i xe", "M\u00F4 t\u1EA3", "SL hi\u1EC7n c\u00F3", "Gi\u00E1 b\u00E1n", "Dung t\u00EDch", "M\u00E3 m\u00E0u", "M\u00E3 NCC"
			}
		));
		JTableXe.getColumnModel().getColumn(0).setPreferredWidth(50);
		JTableXe.getColumnModel().getColumn(1).setPreferredWidth(120);
		JTableXe.getColumnModel().getColumn(2).setPreferredWidth(100);
		JTableXe.getColumnModel().getColumn(3).setPreferredWidth(500);
		JTableXe.getColumnModel().getColumn(4).setPreferredWidth(30);
		JTableXe.getColumnModel().getColumn(5).setPreferredWidth(70);
		JTableXe.getColumnModel().getColumn(6).setPreferredWidth(50);
		JTableXe.getColumnModel().getColumn(7).setPreferredWidth(50);
		JTableXe.getColumnModel().getColumn(8).setPreferredWidth(60);
		JTableXe.setBounds(10, 254, 875, 251);
		panel.add(JTableXe);
		
		try {
			Connection cons = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLXEMAY1;user=sa;password=123456");
			PreparedStatement st = cons.prepareStatement("Select * from XEMAY");
			ResultSet rs = st.executeQuery();
			DefaultTableModel model = (DefaultTableModel) JTableXe.getModel();
			while (rs.next()) {
				Object objList[] = {rs.getString("MAXE"), rs.getString("TENXE"), rs.getString("LOAIXE"), rs.getString("MOTA"), rs.getInt("SLHIENCO"), rs.getInt("GIABAN"), rs.getString("DUNGTICH"), rs.getString("MAMAU"), rs.getString("MANCC")};
				model.addRow(objList);
				
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(NHANVIEN.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}

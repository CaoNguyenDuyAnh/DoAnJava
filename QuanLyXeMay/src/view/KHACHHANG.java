package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

public class KHACHHANG extends JPanel {
	private JTable JTableKH;

	/**
	 * Create the panel.
	 */
	public KHACHHANG() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 962, 527);
		add(panel);
		panel.setLayout(null);
		
		JTableKH = new JTable();
		JTableKH.setBounds(10, 254, 875, 251);
		panel.add(JTableKH);

	}

}

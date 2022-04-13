package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class THONGKE extends JPanel {

	/**
	 * Create the panel.
	 */
	public THONGKE() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 966, 536);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống kê");
		lblNewLabel.setBounds(600, 209, 149, 83);
		panel.add(lblNewLabel);

	}

}

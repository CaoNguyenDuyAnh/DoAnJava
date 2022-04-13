package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class KHACHHANG extends JPanel {

	/**
	 * Create the panel.
	 */
	public KHACHHANG() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 962, 527);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KHACHHANG");
		lblNewLabel.setBounds(283, 161, 190, 142);
		panel.add(lblNewLabel);

	}

}

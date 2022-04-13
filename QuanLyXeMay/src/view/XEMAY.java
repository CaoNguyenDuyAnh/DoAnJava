package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class XEMAY extends JPanel {

	/**
	 * Create the panel.
	 */
	public XEMAY() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 877, 482);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("XeMay");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(416, 5, 103, 128);
		panel.add(lblNewLabel);

	}

}

package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class BANHANG extends JPanel {

	/**
	 * Create the panel.
	 */
	public BANHANG() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 975, 542);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BANHANG");
		lblNewLabel.setBounds(525, 199, 173, 124);
		panel.add(lblNewLabel);

	}

}

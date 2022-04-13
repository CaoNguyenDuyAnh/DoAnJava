package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class NCC extends JPanel {

	/**
	 * Create the panel.
	 */
	public NCC() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 522);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHACUNGCAP");
		lblNewLabel.setBounds(569, 127, 121, 69);
		panel.add(lblNewLabel);

	}

}

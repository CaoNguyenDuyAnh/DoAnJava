package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class NHANVIEN extends JPanel {

	/**
	 * Create the panel.
	 */
	public NHANVIEN() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 859, 515);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHANVIEN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(617, 158, 111, 63);
		panel.add(lblNewLabel);

	}

}

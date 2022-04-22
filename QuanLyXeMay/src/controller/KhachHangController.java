package controller;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.KHACHHANG;

public class KhachHangController {
	private JButton btnAdd;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	public KhachHangController(JButton btnAdd, JTextField txtMaKH, JTextField txtTenKH, JTextField txtSDT,
			JTextField txtEmail, JTextField txtDiaChi) {
		super();
		this.btnAdd = btnAdd;
		this.txtMaKH = txtMaKH;
		this.txtTenKH = txtTenKH;
		this.txtSDT = txtSDT;
		this.txtEmail = txtEmail;
		this.txtDiaChi = txtDiaChi;
	}
	
	public void setView(KHACHHANG khachhang) {
		txtMaKH.setText(khachhang.getMa_kh());
		txtTenKH.setText(khachhang.getTen_kh());
		txtTenKH.setText(khachhang.getSdt());
		txtTenKH.setText(khachhang.getDia_chi());
		txtTenKH.setText(khachhang.getEmail());
	}
}

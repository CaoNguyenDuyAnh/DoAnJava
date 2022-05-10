package model;


import java.awt.Stroke;

import javax.swing.JComboBox;

public class HOADON {
	private String ma_hd;
	private	String ngay_lap;
	private JComboBox <String> ten_kh;
	private JComboBox <String> ten_nv;
	private JComboBox<String> ten_xe;
	private JComboBox<String> mau;
	public HOADON(String ma_hd, String ngay_lap, JComboBox<String> ten_kh, JComboBox<String> ten_nv,
			JComboBox<String> ten_xe, JComboBox<String> mau) {
		super();
		this.ma_hd = ma_hd;
		this.ngay_lap = ngay_lap;
		this.ten_kh = ten_kh;
		this.ten_nv = ten_nv;
		this.ten_xe = ten_xe;
		this.mau = mau;
	}
	public String getMa_hd() {
		return ma_hd;
	}
	public void setMa_hd(String ma_hd) {
		this.ma_hd = ma_hd;
	}
	public String getNgay_lap() {
		return ngay_lap;
	}
	public void setNgay_lap(String ngay_lap) {
		this.ngay_lap = ngay_lap;
	}
	public JComboBox<String> getTen_kh() {
		return ten_kh;
	}
	public void setTen_kh(JComboBox<String> ten_kh) {
		this.ten_kh = ten_kh;
	}
	public JComboBox<String> getTen_nv() {
		return ten_nv;
	}
	public void setTen_nv(JComboBox<String> ten_nv) {
		this.ten_nv = ten_nv;
	}
	public JComboBox<String> getTen_xe() {
		return ten_xe;
	}
	public void setTen_xe(JComboBox<String> ten_xe) {
		this.ten_xe = ten_xe;
	}
	public JComboBox<String> getMau() {
		return mau;
	}
	public void setMau(JComboBox<String> mau) {
		this.mau = mau;
	}
	public static HOADON get(int selectedIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

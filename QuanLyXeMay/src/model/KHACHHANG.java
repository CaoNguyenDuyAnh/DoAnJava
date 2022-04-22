package model;

public class KHACHHANG {
	private String ma_kh;
	private String ten_kh;
	private String dia_chi;
	private String sdt;
	private String email;
	
	
	
	
	public KHACHHANG(String ma_kh, String ten_kh, String dia_chi, String sdt, String email) {
		super();
		this.ma_kh = ma_kh;
		this.ten_kh = ten_kh;
		this.dia_chi = dia_chi;
		this.sdt = sdt;
		this.email = email;
	}
	public String getMa_kh() {
		return ma_kh;
	}
	public void setMa_kh(String ma_kh) {
		this.ma_kh = ma_kh;
	}
	public String getTen_kh() {
		return ten_kh;
	}
	public void setTen_kh(String ten_kh) {
		this.ten_kh = ten_kh;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

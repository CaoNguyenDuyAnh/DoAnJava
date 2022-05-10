package model;


public class NCC {
	private String ma_ncc;
	private String ten_ncc;
	private String dia_chi;
	private String sdt;
	private String email;
	
	private boolean disable;

public String getMa_ncc(){
	return ma_ncc;
}
public void setMa_ncc(String ma_ncc) {
	this.ma_ncc = ma_ncc;
}
public String getTen_ncc() {
	return ten_ncc;
}
public void setTen_ncc(String ten_ncc) {
	this.ten_ncc = ten_ncc;
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
public boolean isDisable() {
	return disable;
}
public void setDisable(boolean disable) {
	this.disable = disable;
}

}
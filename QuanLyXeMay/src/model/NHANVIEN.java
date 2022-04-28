package model;

import java.sql.Date;

public class NHANVIEN {
	private String ma_nv;
	private String ten_nv;
	private String gioi_tinh;
	private String nam_sinh;
	private String dia_chi;
	private String sdt;
	private String chuc_vu;
	private String luong_cb;
	private String username;
	private String password;
	
	public NHANVIEN() {
	}

	public NHANVIEN(String ma_nv, String ten_nv, String gioi_tinh, String nam_sinh, String dia_chi, String sdt,
			String chuc_vu, String luong_cb, String username, String password) {
		this.ma_nv = ma_nv;
		this.ten_nv = ten_nv;
		this.gioi_tinh = gioi_tinh;
		this.nam_sinh = nam_sinh;
		this.dia_chi = dia_chi;
		this.sdt = sdt;
		this.chuc_vu = chuc_vu;
		this.luong_cb = luong_cb;
		this.username = username;
		this.password = password;
	}

	public String getMa_nv() {
		return ma_nv;
	}

	public void setMa_nv(String ma_nv) {
		this.ma_nv = ma_nv;
	}

	public String getTen_nv() {
		return ten_nv;
	}

	public void setTen_nv(String ten_nv) {
		this.ten_nv = ten_nv;
	}

	public String getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getNam_sinh() {
		return nam_sinh;
	}

	public void setNam_sinh(String nam_sinh) {
		this.nam_sinh = nam_sinh;
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

	public String getChuc_vu() {
		return chuc_vu;
	}

	public void setChuc_vu(String chuc_vu) {
		this.chuc_vu = chuc_vu;
	}

	public String getLuong_cb() {
		return luong_cb;
	}

	public void setLuong_cb(String luong_cb) {
		this.luong_cb = luong_cb;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
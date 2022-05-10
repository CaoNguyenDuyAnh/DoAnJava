package model;

import java.sql.Date;

import javax.swing.JComboBox;

public class CTHOADON {
	private String ma_xe;
	private String  ma_mau;
	private String ma_hd;
	private String ma_kh;
	private String ma_nv;
	private String don_gia;
	private String thue;
	private String ma_ncc;
	private String so_luong;
	private String ngay_lap;
	public CTHOADON(String ma_xe, String ma_mau, String ma_hd, String ma_kh, String ma_nv, String don_gia, String thue,
			String ma_ncc, String so_luong, String ngay_lap) {
		super();
		this.ma_xe = ma_xe;
		this.ma_mau = ma_mau;
		this.ma_hd = ma_hd;
		this.ma_kh = ma_kh;
		this.ma_nv = ma_nv;
		this.don_gia = don_gia;
		this.thue = thue;
		this.ma_ncc = ma_ncc;
		this.so_luong = so_luong;
		this.ngay_lap = ngay_lap;
	}
	public String getMa_xe() {
		return ma_xe;
	}
	public void setMa_xe(String ma_xe) {
		this.ma_xe = ma_xe;
	}
	public String getMa_mau() {
		return ma_mau;
	}
	public void setMa_mau(String ma_mau) {
		this.ma_mau = ma_mau;
	}
	public String getMa_hd() {
		return ma_hd;
	}
	public void setMa_hd(String ma_hd) {
		this.ma_hd = ma_hd;
	}
	public String getMa_kh() {
		return ma_kh;
	}
	public void setMa_kh(String ma_kh) {
		this.ma_kh = ma_kh;
	}
	public String getMa_nv() {
		return ma_nv;
	}
	public void setMa_nv(String ma_nv) {
		this.ma_nv = ma_nv;
	}
	public String getDon_gia() {
		return don_gia;
	}
	public void setDon_gia(String don_gia) {
		this.don_gia = don_gia;
	}
	public String getThue() {
		return thue;
	}
	public void setThue(String thue) {
		this.thue = thue;
	}
	public String getMa_ncc() {
		return ma_ncc;
	}
	public void setMa_ncc(String ma_ncc) {
		this.ma_ncc = ma_ncc;
	}
	public String getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(String so_luong) {
		this.so_luong = so_luong;
	}
	public String getNgay_lap() {
		return ngay_lap;
	}
	public void setNgay_lap(String ngay_lap) {
		this.ngay_lap = ngay_lap;
	}
	
	
	
}
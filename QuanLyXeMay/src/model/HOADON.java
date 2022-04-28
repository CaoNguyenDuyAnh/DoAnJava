package model;

import java.sql.Date;

public class HOADON {
	private String ma_hd;
	private	Date ngay_lap;
	private String ma_kh;
	private String ma_nv;
	public HOADON(String ma_hd, Date ngay_lap, String ma_kh, String ma_nv) {
		super();
		this.ma_hd = ma_hd;
		this.ngay_lap = ngay_lap;
		this.ma_kh = ma_kh;
		this.ma_nv = ma_nv;
	}
	public String getMa_hd() {
		return ma_hd;
	}
	public void setMa_hd(String ma_hd) {
		this.ma_hd = ma_hd;
	}
	public Date getNgay_lap() {
		return ngay_lap;
	}
	public void setNgay_lap(Date ngay_lap) {
		this.ngay_lap = ngay_lap;
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
	
	
}

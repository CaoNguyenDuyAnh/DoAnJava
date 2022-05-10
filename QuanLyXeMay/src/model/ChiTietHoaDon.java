package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.awt.geom.Point2D.*;
import java.lang.Double;

public class ChiTietHoaDon {
	private String MAXE, MAHD;
	private String SOLUONG;
	private String DONGIA;
	private String THUE;

	public ChiTietHoaDon() {
	}

	public ChiTietHoaDon(String mAHD, String mAXE, String sql, String sql2, String sql3) {
		super();
		MAXE = mAXE;
		MAHD = mAHD;
		SOLUONG = sql;
		DONGIA = sql2;
		THUE = sql3;
	}

	public String getMAXE() {
		return MAXE;
	}

	public void setMAXE(String mAXE) {
		MAXE = mAXE;
	}

	public String getMAHD() {
		return MAHD;
	}

	public void setMAHD(String mAHD) {
		MAHD = mAHD;
	}

	public String getSOLUONG() {
		return SOLUONG;
	}

	public void setSOLUONG(String sOLUONG) {
		SOLUONG = sOLUONG;
	}

	public String getDONGIA() {
		return DONGIA;
	}

	public void setDONGIA(String dONGIA) {
		DONGIA = dONGIA;
	}

	public String getTHUE() {
		return THUE;
	}

	public void setTHUE(String tHUE) {
		THUE = tHUE;
	}
	
}
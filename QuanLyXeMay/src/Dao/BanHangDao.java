package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import helper.DBConnect;
import model.CTHOADON;
import model.HOADON;
import model.KHACHHANG;
import model.XEMAY;

public class BanHangDao {
	
	public static boolean insert(CTHOADON cthd ) throws SQLException, Exception {
		String sqlString = "insert into HOADON(MANV, MAKH, MAHD, NGAYLAP) values(?,?,?,?) ";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sqlString);
				){
			pstmt.setString(1, cthd.getMa_nv());
			pstmt.setString(2, cthd.getMa_kh());
			pstmt.setString(3, cthd.getMa_hd());
			pstmt.setString(4, cthd.getNgay_lap());
			return pstmt.executeUpdate() > 0;
		}
	}
	public static boolean ThemHD(CTHOADON hd ) throws SQLException, Exception {
		String sqlString = "insert into CTHOADON(MAXE, MAMAU, MAHD, MAKH, MANV, DONGIA, MANCC, SOLUONG) values(?,?,?,?,?,?,?,?)";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sqlString);
				){
			pstmt.setString(1, hd.getMa_xe());
			pstmt.setString(2, hd.getMa_mau());
			pstmt.setString(3, hd.getMa_hd());
			pstmt.setString(4, hd.getMa_kh());
			pstmt.setString(5, hd.getMa_nv());
			pstmt.setString(6, hd.getDon_gia());
			pstmt.setString(7, hd.getMa_ncc());
			pstmt.setString(8, hd.getSo_luong());
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public boolean update(CTHOADON hd) throws Exception {
		String sql = "UPDATE CTHOADON SET MAXE = ?, MAMAU = ? , MANCC = ?, MAKH = ?, MANV = ?, SOLUONG =?, DONGIA = ? WHERE MAHD = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(8, hd.getMa_hd());
			pstmt.setString(1, hd.getMa_xe());
			pstmt.setString(2, hd.getMa_mau());
			pstmt.setString(3, hd.getMa_ncc());
			pstmt.setString(4, hd.getMa_kh());
			pstmt.setString(5, hd.getMa_nv());
			pstmt.setString(6, hd.getSo_luong());
			pstmt.setString(7, hd.getDon_gia());
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public boolean capnhat(CTHOADON cthd) throws Exception {
		String sql = "UPDATE HOADON SET NGAYLAP = ?,MAKH = ?, MANV = ? WHERE MAHD = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(4, cthd.getMa_hd());
			pstmt.setString(1, cthd.getNgay_lap());
			pstmt.setString(2, cthd.getMa_kh());
			pstmt.setString(3, cthd.getMa_nv());
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public boolean delete(String MAHD) throws Exception {
		String sql = "DELETE from CTHOADON WHERE MAHD = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MAHD);
			
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public boolean delete1(String MAHD) throws Exception {
		String sql = "DELETE from HOADON WHERE MAHD = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MAHD);
			
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public CTHOADON FindbyID(String MAHD) throws Exception {
		String sql = "select * from CTHOADON, NHANVIEN, KHACHHANG, XEMAY, MAUSAC, NCC where MAHD = ? AND CTHOADON.MANV = NHANVIEN.MANV AND KHACHHANG.MAKH = CTHOADON.MAKH AND CTHOADON.MAXE = XEMAY.MAXE AND CTHOADON.MAMAU = MAUSAC.MAMAU AND CTHOADON.MANCC = NCC.MANCC";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MAHD);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				CTHOADON hoadon = new CTHOADON(sql, sql, sql, sql, sql, sql, sql, MAHD, sql, sql);
				hoadon.setMa_xe(rs.getString("TENXE"));
				hoadon.setMa_mau(rs.getString("TENMAU"));
				hoadon.setMa_ncc(rs.getString("TENNCC"));
				hoadon.setMa_hd(rs.getString("MAHD"));
				hoadon.setMa_kh(rs.getString("TENKH"));
				hoadon.setMa_nv(rs.getString("TENNV"));
				hoadon.setSo_luong(rs.getString("SOLUONG"));
				hoadon.setDon_gia(rs.getString("DONGIA"));
				return hoadon;
			}
			
			return null;
		}
	}
	
	public CTHOADON FindByID(String MAHD) throws Exception {
		String sql = "select * from HOADON, NHANVIEN where MAHD = ? AND HOADON.MANV = NHANVIEN.MANV";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MAHD);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				CTHOADON hoadon = new CTHOADON(sql, sql, sql, sql, sql, sql, sql, sql, MAHD, sql);
				hoadon.setMa_hd(rs.getString("MAHD"));
				hoadon.setNgay_lap(rs.getString("NGAYLAP"));
				hoadon.setMa_kh(rs.getString("MAKH"));
				hoadon.setMa_nv(rs.getString("TENNV"));
				return hoadon;
			}
			
			return null;
		}
	}
	
	
}

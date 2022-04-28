package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import helper.DBConnect;
import model.NHANVIEN;

public class NhanVienDao {
	public boolean insert(NHANVIEN nv) throws Exception
	{
		String sql = "insert into NHANVIEN(MANV, TENNV, NAMSINH, GIOITINH, DIACHI, SDT, CHUCVU, LUONGCOBAN, USERNAME, PASSWORD) values(?,?,?,?,?,?,?,?,?,?)";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, nv.getMa_nv());
			pstmt.setString(2, nv.getTen_nv());
			pstmt.setString(3, nv.getNam_sinh());
			pstmt.setString(4, nv.getGioi_tinh());
			pstmt.setString(5, nv.getDia_chi());
			pstmt.setString(6, nv.getSdt());
			pstmt.setString(7, nv.getChuc_vu());
			pstmt.setString(8, nv.getLuong_cb());
			pstmt.setString(9, nv.getUsername());
			pstmt.setString(10, nv.getPassword());
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public boolean update(NHANVIEN nv) throws Exception {
		String sql = "UPDATE NHANVIEN SET TENNV = ?, NAMSINH = ?, GIOITINH = ?, DIACHI = ? , SDT = ?, CHUCVU = ?, LUONGCOBAN = ?, USERNAME = ?, PASSWORD = ?  WHERE MANV = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(10, nv.getMa_nv());
			pstmt.setString(1, nv.getTen_nv());
			pstmt.setString(2, nv.getNam_sinh());
			pstmt.setString(3, nv.getGioi_tinh());
			pstmt.setString(4, nv.getDia_chi());
			pstmt.setString(5, nv.getSdt());
			pstmt.setString(6, nv.getChuc_vu());
			pstmt.setString(7, nv.getLuong_cb());
			pstmt.setString(8, nv.getUsername());
			pstmt.setString(9, nv.getPassword());
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public NHANVIEN FindbyID(String MANV) throws Exception {
		String sql = "select * from NHANVIEN where MANV = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MANV);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				NHANVIEN nhanvien = new NHANVIEN(MANV, sql, sql, sql, sql,sql, sql, sql ,sql, sql);
				nhanvien.setMa_nv(rs.getString("MANV"));
				nhanvien.setTen_nv(rs.getString("TENNV"));
				nhanvien.setNam_sinh(rs.getString("NAMSINH"));
				nhanvien.setGioi_tinh(rs.getString("GIOITINH"));
				nhanvien.setDia_chi(rs.getString("DIACHI"));
				nhanvien.setSdt(rs.getString("SDT"));
				nhanvien.setChuc_vu(rs.getString("CHUCVU"));
				nhanvien.setLuong_cb(rs.getString("LUONGCOBAN"));
				nhanvien.setUsername(rs.getString("USERNAME"));
				nhanvien.setPassword(rs.getString("PASSWORD"));
				
				return nhanvien;
			}
			
			return null;
		}
	}
	
	public boolean delete(String MANV) throws Exception {
		String sql = "DELETE from NHANVIEN WHERE MANV = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MANV);
			
			return pstmt.executeUpdate() > 0;
		}
	}
}
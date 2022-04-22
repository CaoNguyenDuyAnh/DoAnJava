package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import helper.DBConnect;
import model.KHACHHANG;

public class KhachHangDao {
	public boolean insert(KHACHHANG kh) throws Exception {
		String sql = "insert into KHACHHANG(MAKH, TENKH, DIACHI, SDT, EMAIL) values (?,?,?,?,?)";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, kh.getMa_kh());
			pstmt.setString(2, kh.getTen_kh());
			pstmt.setString(3, kh.getDia_chi());
			pstmt.setString(4, kh.getSdt());
			pstmt.setString(5, kh.getEmail());
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public boolean update(KHACHHANG kh) throws Exception {
		String sql = "UPDATE KHACHHANG SET TENKH = ?, DIACHI = ? , SDT = ?, EMAIL = ? WHERE MAKH = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(5, kh.getMa_kh());
			pstmt.setString(1, kh.getTen_kh());
			pstmt.setString(2, kh.getDia_chi());
			pstmt.setString(3, kh.getSdt());
			pstmt.setString(4, kh.getEmail());
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public boolean delete(String MAKH) throws Exception {
		String sql = "DELETE from KHACHHANG WHERE MAKH = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MAKH);
			
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public KHACHHANG FindbyID(String MAKH) throws Exception {
		String sql = "select * from KHACHHANG where MAKH = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MAKH);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				KHACHHANG khachhang = new KHACHHANG(MAKH, sql, sql, sql, sql);
				khachhang.setMa_kh(rs.getString("MAKH"));
				khachhang.setTen_kh(rs.getString("TENKH"));
				khachhang.setDia_chi(rs.getString("DIACHI"));
				khachhang.setSdt(rs.getString("SDT"));
				khachhang.setEmail(rs.getString("EMAIL"));
				
				return khachhang;
			}
			
			return null;
		}
	}
}

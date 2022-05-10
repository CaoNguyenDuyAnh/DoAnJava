package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import helper.DBConnect;
import model.XEMAY;

public class XeDao {
	public boolean insert(XEMAY xemay) throws Exception {
		String sql = "insert into XEMAY(MAXE, TENXE, LOAIXE, MOTA, SLHIENCO, GIABAN, DUNGTICH, MAMAU, MANCC ) values (?,?,?,?,?,?,?,?,?)";
		try (
				Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, xemay.getMa_xe());
			pstmt.setString(2, xemay.getTen_xe());
			pstmt.setString(3, xemay.getLoai_xe());
			pstmt.setString(4, xemay.getMo_ta());
			pstmt.setString(5, xemay.getSo_luong());
			pstmt.setString(6, xemay.getGia_ban());
			pstmt.setString(7, xemay.getDung_tich());
			pstmt.setString(8, xemay.getMa_mau());
			pstmt.setString(8, xemay.getMa_ncc());
			
			return pstmt.executeUpdate() > 0;
		}
	}
	public boolean update(XEMAY xemay) throws Exception {
		String sql = "update into UPDATE NCC SET TENXE = ?, LOAIXE = ? , MOTA = ?, SLHIENCO = ?, GIABAN=?, DUNGTICH=?, MAMAU=?, MANCC=? WHERE MAXE = ?";
		try (
				Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(9, xemay.getMa_xe());
			pstmt.setString(1, xemay.getTen_xe());
			pstmt.setString(2, xemay.getLoai_xe());
			pstmt.setString(3, xemay.getMo_ta());
			pstmt.setString(4, xemay.getSo_luong());
			pstmt.setString(5, xemay.getGia_ban());
			pstmt.setString(6, xemay.getDung_tich());
			pstmt.setString(7, xemay.getMa_mau());
			pstmt.setString(8, xemay.getMa_ncc());
			return pstmt.executeUpdate() > 0;
		}
	}
	public boolean delete(String MAXE) throws Exception {
		String sql = "DELETE from XEMAY WHERE MAXE = ?";
		try (
				Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MAXE);
			
			return pstmt.executeUpdate() > 0;
		}
	}
	public XEMAY FindbyID(String MAXE) throws Exception {
		String sql = "select * from XEMAY where MAXE = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MAXE);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				XEMAY xemay = new XEMAY();				
				xemay.setMa_xe(rs.getString("MAXE"));
				xemay.setTen_xe(rs.getString("TENXE"));
				xemay.setLoai_xe(rs.getString("LOAIXE"));
				xemay.setMo_ta(rs.getString("MOTA"));
				xemay.setSo_luong(rs.getString("SLHIENCO"));
				xemay.setGia_ban(rs.getString("GIABAN"));
				xemay.setDung_tich(rs.getString("DUNGTICH"));
				xemay.setMa_mau(rs.getString("MAMAU"));
				xemay.setMa_ncc(rs.getString("MANCC"));
				
				return xemay;
			}
			
			return null;
		}
	}
}
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import helper.DBConnect;
import model.NCC;

public class NCCDao {
	public boolean insert(NCC ncc) throws Exception {
		String sql = "insert into NCC(MANCC, TENNCC, DIACHI,SDT,EMAIL ) values (?,?,?,?)";
		try (
				Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, ncc.getMa_ncc());
			pstmt.setString(2, ncc.getTen_ncc());
			pstmt.setString(3, ncc.getDia_chi());
			pstmt.setString(4, ncc.getSdt());
			pstmt.setString(3, ncc.getEmail());
			return pstmt.executeUpdate() > 0;
		}
	}
	public boolean update(NCC ncc) throws Exception {
		String sql = "UPDATE NCC SET TENNCC = ?, DIACHI = ? , SDT = ?, EMAIL = ? WHERE MANCC = ?";
		try (
				Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(5, ncc.getMa_ncc());
			pstmt.setString(1, ncc.getTen_ncc());
			pstmt.setString(2, ncc.getDia_chi());
			pstmt.setString(3, ncc.getSdt());
		    pstmt.setString(4, ncc.getEmail());
			return pstmt.executeUpdate() > 0;
		}
	}
	public boolean delete(String MANCC) throws Exception {
		String sql = "DELETE from NCC WHERE MANCC = ?";
		try (
				Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MANCC);
			
			return pstmt.executeUpdate() > 0;
		}
	}
	
	public NCC FindbyID(String MaNCC) throws Exception {
		String sql = "select * from NCC where MANCC = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MaNCC);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				NCC ncc = new NCC();
				ncc.setMa_ncc(rs.getString("MANCC"));
				ncc.setTen_ncc(rs.getString("TENNCC"));
				ncc.setDia_chi(rs.getString("DIACHI"));
				ncc.setSdt(rs.getString("SDT"));
				ncc.setEmail(rs.getString("EMAIL"));
				
				return ncc;
			}
			
			return null;
		}
		
	}
	
}
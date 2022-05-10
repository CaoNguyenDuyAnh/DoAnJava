package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import helper.DBConnect;
import model.ChiTietHoaDon;

public class CTHDDao {

	public ChiTietHoaDon FindbyID(String MAHD) throws Exception {
		String sql = "select * from CTHOADON where MAHD = ?";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, MAHD);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				ChiTietHoaDon ct = new ChiTietHoaDon(MAHD, sql, sql, sql, sql);
				ct.setMAHD(rs.getString("MAHD"));
				ct.setMAXE(rs.getString("MAXE"));
				ct.setSOLUONG(rs.getString("SOLUONG"));
				ct.setDONGIA(rs.getString("DONGIA"));
				ct.setTHUE(rs.getString("THUE"));
				return ct;
			}
			
			return null;
		}
	}
}
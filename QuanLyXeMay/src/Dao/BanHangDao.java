package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import helper.DBConnect;
import model.HOADON;

public class BanHangDao {
	public boolean insert(HOADON HD) throws Exception {
		String sql = "insert into HOADON(MAHD, NGAYLAP, MAKH, MANV) values (?,?,?,?)";
		try (Connection con = DBConnect.opnConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, HD.getMa_hd());
			pstmt.setDate(2, HD.getNgay_lap());
			pstmt.setString(3, HD.getMa_kh());
			pstmt.setString(4, HD.getMa_nv());
			return pstmt.executeUpdate() > 0;
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.DataHelper;
import model.Sanpham;

public class Sanphams {
	private static final String SELECT_BY_ID = "select id,tensp,Gia,mota from sanpham where id =?";
	private static final String SELECT_ALL = "select * from sanpham";
	private static final String DELETE = "delete from sanpham where id = ?;";
	private static final String UPDATE = "update sanpham set tensp = ?,Gia= ?,mota = ? where id = ?;";
	private static final String INSERT = "insert into sanpham(id,tensp,Gia,mota) value (?, ?, ?,?) ;";
		
		public static Sanpham getSanpham(String id) {
			try {
				Connection conn = DataHelper.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_ID);
				preparedStatement.setString(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String tensp = rs.getString("tensp");
					double Gia =  rs.getDouble("Gia");
					String mota = rs.getString("mota");
					return new Sanpham(id,tensp,Gia,mota);
				}

				}catch (Exception e) {
					
					e.printStackTrace();
			}
			return new Sanpham();
		}
		
		public static List<Sanpham> getAll() {
			List<Sanpham> Sanpham = new ArrayList<>();
			try {
				Connection conn = DataHelper.getConnection();
				Statement stmt = null;
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT_ALL);
				while (rs.next()) {
					String id = rs.getString("id");
					String tensp = rs.getString("tensp");
					double Gia =  rs.getDouble("Gia");
					String mota = rs.getString("mota");
				
					Sanpham.add(new Sanpham(id, tensp, Gia, mota));
				}

				}catch (Exception e) {
					e.printStackTrace();
			}
			return Sanpham;
		}
		public static boolean create(Sanpham Sanpham) {
			try {
				Connection conn = DataHelper.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(INSERT);
				preparedStatement.setString(1, Sanpham.getId());
				preparedStatement.setString(2, Sanpham.getTensp());
				preparedStatement.setDouble(3, Sanpham.getGia());
				preparedStatement.setString(4, Sanpham.getMota());
				String sql = preparedStatement.toString();
				return preparedStatement.execute();
				
				}catch (Exception e) {
					
					e.printStackTrace();
					return false;
			}
			
		}
		public static boolean update(Sanpham Sanpham) {
			
			try {
				Connection conn = DataHelper.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(UPDATE);
				preparedStatement.setString(1, Sanpham.getTensp());
				preparedStatement.setDouble(2, Sanpham.getGia());
				preparedStatement.setString(3, Sanpham.getMota());
				preparedStatement.setString(4, Sanpham.getId());
				String sql = preparedStatement.toString();
				return preparedStatement.execute();
				
				}catch (Exception e) {
					
					e.printStackTrace();
					return false;
			}
		}
		public static boolean delete(Sanpham Sanpham) {
			
			return true;
		}
		public static boolean save(Sanpham Sanpham) {
			try {
				if( isExist(Sanpham))
					return update(Sanpham);
				else
					return create(Sanpham);
			}catch (Exception e) {
				return false;
			} 
			
		}
		public static boolean isExist(Sanpham Sanpham) {
			try {
				Connection conn = DataHelper.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_ID);
				preparedStatement.setString(1, Sanpham.getId());
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					return true;
				}

				}catch (Exception e) {
					e.printStackTrace();
			}
			return false;
		}
}

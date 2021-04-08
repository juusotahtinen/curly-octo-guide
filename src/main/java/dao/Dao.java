package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Candidates;


import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
	public List<Candidates> listAllCandidates() throws SQLException {
        List<Candidates> listCandidates = new ArrayList<>();
         
        String sql = "SELECT * FROM ehdokkaat";
         
        getConnection();
         
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	Candidates f=new Candidates();
			f.setEhdokas_id(resultSet.getInt("ehdokas_id"));
			f.setSukunimi(resultSet.getString("sukunimi"));
			f.setEtunimi(resultSet.getString("etunimi"));
			f.setPuolue(resultSet.getString("puolue"));
			listCandidates.add(f);
             


        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listCandidates;
	}
	
//	public ArrayList<Candidates> listAllCandidates() {
//		ArrayList<Candidates> listAllCandidates=new ArrayList<>();
//		try {
//			Statement stmt=conn.createStatement();
//			ResultSet RS=stmt.executeQuery("select * from ehdokkaat");
//			while (RS.next()){
//				Candidates f=new Candidates();
//				f.setEhdokas_id(RS.getInt("ehdokas_id"));
//				f.setSukunimi(RS.getString("sukunimi"));
//				f.setEtunimi(RS.getString("etunimi"));
//				f.setPuolue(RS.getString("puolue"));
//				listAllCandidates.add(f);
//			}
//			return listAllCandidates;
//		}
//		catch(SQLException e) {
//			return null;
//		}
//	}
//			
//	public ArrayList<Candidates> updateCandidates(Candidates f) {
//		try {
//			String sql="update ehdokkaat set sukunimi=? etunimi=? where ehdokas_id=?";
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, f.getSukunimi());
//			pstmt.setString(2, f.getEtunimi());
//			pstmt.setString(3, f.getPuolue());
//			pstmt.setInt(4, f.getEhdokas_id());
//			pstmt.executeUpdate();
//			return readAllCandidates();
//		}
//		catch(SQLException e) {
//			return null;
//		}
//	}
//	public ArrayList<Candidates> deleteCandidates(String ehdokas_id) {
//		try {
//			String sql="delete from ehdokkaat where ehdokas_id=?";
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, ehdokas_id);
//			pstmt.executeUpdate();
//			return readAllCandidates();
//		}
//		catch(SQLException e) {
//			return null;
//		}
//	}
//
//	public Candidates readCandidates(String ehdokas_id) {
//		Candidates f=null;
//		try {
//			String sql="select * from ehdokkaat where ehdokas_id=?";
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, ehdokas_id);
//			ResultSet RS=pstmt.executeQuery();
//			while (RS.next()){
//				f=new Candidates();
//				f.setEhdokas_id(RS.getInt("ehdokas_id"));
//				f.setSukunimi(RS.getString("sukunimi"));
//				f.setEtunimi(RS.getString("etunimi"));
//				f.setPuolue(RS.getString("puolue"));
//			}
//			return f;
//		}
//		catch(SQLException e) {
//			return null;
//		}
//	}
}




package dao;

//import java.sql.*;
//
//public class Dao {
//	
//	String dbURL = "jdbc:mysql://localhost:3306/vaalikone";
//	String username = "pena";
//	String password = "kukkuu";
//	
//	public void Insert() {
//		 
//		try {
//		 
//		    Connection conn = DriverManager.getConnection(dbURL, username, password);
//		    
//		 
//		    if (conn != null) {
//		        System.out.println("Connected");
//		    }
//		    
//		    String sql = "INSERT INTO ehdokkaat (EHDOKAS_ID, SUKUNIMI, ETUNIMI, PUOLUE) VALUES (?, ?, ?, ?)";
//			
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, "324");
//			statement.setString(2, "Palo");
//			statement.setString(3, "Leevi");
//			statement.setString(4, "Kokoomus");
//			 
//			int rowsInserted = statement.executeUpdate();
//			
//			if (rowsInserted > 0) {
//			    System.out.println("A new user was inserted successfully!");
//			}
//			
//			
//
//			
//		} catch (SQLException ex) {
//		    ex.printStackTrace();
//		}
//		
//	}
//	
//	public void Select() {
//		 
//		try {
//		 
//		    Connection conn = DriverManager.getConnection(dbURL, username, password);
//
//			
//			String sql2 = "SELECT * FROM ehdokkaat";
//			 
//			Statement statement2 = conn.createStatement();
//			ResultSet result = statement2.executeQuery(sql2);
//			 
//
//			 
//			while (result.next()){
//			    String id = result.getString(1);
//			    String sukunimi = result.getString(2);
//			    String etunimi = result.getString("ETUNIMI");
//			    String puolue = result.getString("PUOLUE");
//			 
//			    String output = "%s - %s - %s - %s";
//			    
//			    System.out.println(String.format(output, id, sukunimi, etunimi, puolue));
//			}
//			
//			
//			
//		} catch (SQLException ex) {
//		    ex.printStackTrace();
//		}
//	}
//	
//	public void Update() {
//		 
//		try {
//		 
//		    Connection conn = DriverManager.getConnection(dbURL, username, password);
//		    
//
//			
//			String sql3 = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
//			 
//			PreparedStatement statement3 = conn.prepareStatement(sql3);
//			statement3.setString(1, "123456789");
//			statement3.setString(2, "William Henry Bill Gates");
//			statement3.setString(3, "bill.gates@microsoft.com");
//			statement3.setString(4, "bill");
//			 
//			int rowsUpdated = statement3.executeUpdate();
//			
//			if (rowsUpdated > 0) {
//			    System.out.println("An existing user was updated successfully!");
//			}
//
//
//			
//		} catch (SQLException ex) {
//		    ex.printStackTrace();
//		}
//	}
//	
//	public void Delete() {
//		 
//		try {
//		 
//		    Connection conn = DriverManager.getConnection(dbURL, username, password);
//		    
//		 
//		    if (conn != null) {
//		        System.out.println("Connected");
//		    }
//
//			
//			String sql4 = "DELETE FROM Users WHERE username=?";
//			 
//			PreparedStatement statement4 = conn.prepareStatement(sql4);
//			statement4.setString(1, "bill");
//			 
//			int rowsDeleted = statement4.executeUpdate();
//			
//			if (rowsDeleted > 0) {
//			    System.out.println("A user was deleted successfully!");
//			}
//
//			
//		} catch (SQLException ex) {
//		    ex.printStackTrace();
//		}
//	}
//
//}
//
import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Candidates;

import java.sql.Connection;

public class Dao {
	String driver;
    String url;
    String user;
    String pass;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
	
	public Dao() {
		
	}
	
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from ehdokkaat");
			while (RS.next()){
				Candidates f=new Candidates();
				f.setEhdokas_id(RS.getInt(1));
				f.setSukunimi(RS.getString(2));
				f.setEtunimi(RS.getString(3));
				f.setPuolue(RS.getString(4));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Candidates> updateCandidates(Candidates f) {
		try {
			String sql="update ehdokkaat set sukunimi=? etunimi=? puolue=? where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getSukunimi());
			pstmt.setInt(2, f.getEhdokas_id());
			pstmt.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Candidates> deleteCandidates(String id) {
		try {
			String sql="delete from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			return null;
		}
	}

	public Candidates readCandidates(String id) {
		Candidates f=null;
		try {
			String sql="select * from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Candidates();
				f.setEhdokas_id(RS.getInt("ehdokas_id"));
				f.setSukunimi(RS.getString("sukunimi"));
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
}

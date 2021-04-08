package dao;

import java.sql.*;
import java.util.ArrayList;

import data.Kysymykset;


public class DaoAnswers {
	
	String dbURL = "jdbc:mysql://localhost:3306/vaalikone";
	String username = "pena";
	String password = "kukkuu";
	Connection conn = null;
	
//	private String dbURL;
//	private String username;
//	private String password;
	
//	public Dao(String string, String string2, String string3) {
//		this.dbURL = string;
//		this.username = string2;
//		this.password = string3;
//		
//	}
	
	
	
	public void Insert() {
		 
		try {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		    
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		    
		    String sql = "INSERT INTO ehdokkaat (EHDOKAS_ID, SUKUNIMI, ETUNIMI, PUOLUE) VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "327");
			statement.setString(2, "Palo");
			statement.setString(3, "Leevi");
			statement.setString(4, "Kokoomus");
			 
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			}
			
			

			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
	}
	
	public ArrayList<Kysymykset> Select() {
		
		ArrayList<Kysymykset> list = new ArrayList<Kysymykset>();
		 
		try {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);

			
			String sql2 = "SELECT * FROM kysymykset";
			 
			Statement statement2 = conn.createStatement();
			ResultSet result = statement2.executeQuery(sql2);
			 

			 
			while (result.next()){
				Kysymykset k = new Kysymykset();
				k.setId(result.getInt("KYSYMYS_ID"));
				k.setKysymys(result.getString("KYSYMYS"));
				list.add(k);

			    
			}
			return list;
			
			
			
		} catch (SQLException ex) {
		    return null;
		}


	}
	
	public void Update() {
		 
		try {
		 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		    

			
			String sql3 = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
			 
			PreparedStatement statement3 = conn.prepareStatement(sql3);
			statement3.setString(1, "123456789");
			statement3.setString(2, "William Henry Bill Gates");
			statement3.setString(3, "bill.gates@microsoft.com");
			statement3.setString(4, "bill");
			 
			int rowsUpdated = statement3.executeUpdate();
			
			if (rowsUpdated > 0) {
			    System.out.println("An existing user was updated successfully!");
			}


			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	}
	
	public void Delete() {
		 
		try {
		 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		    
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }

			
			String sql4 = "DELETE FROM Users WHERE username=?";
			 
			PreparedStatement statement4 = conn.prepareStatement(sql4);
			statement4.setString(1, "bill");
			 
			int rowsDeleted = statement4.executeUpdate();
			
			if (rowsDeleted > 0) {
			    System.out.println("A user was deleted successfully!");
			}

			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	}



}

package dao;

import java.sql.*;
import java.util.ArrayList;

import data.Kysymykset;
import data.Vastaukset;


public class DaoAnswers {

	private String dbURL;
	private String username;
	private String password;
	
	public DaoAnswers(String dbURL, String username, String password) {
		this.dbURL = dbURL;
		this.username = username;
		this.password = password;
		
	}
	
public ArrayList<Vastaukset> SelectEhdokkaat() {
		
		ArrayList<Vastaukset> list = new ArrayList<Vastaukset>();
		 
		try {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);

			
			String sql2 = "SELECT * FROM vastaukset";
			 
			Statement statement2 = conn.createStatement();
			ResultSet result = statement2.executeQuery(sql2);
			 

			 
			while (result.next()){
				Vastaukset v = new Vastaukset();
				v.setKysymys_id(result.getInt("KYSYMYS_ID"));
				v.setVastaaja_id(result.getInt("KYSYMYS_ID"));
				v.setVastaus(result.getInt("vastaus"));
				list.add(v);

			    
			}
			return list;
			
			
			
		} catch (SQLException ex) {
		    return null;
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
	
	
}





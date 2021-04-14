package dao;

import java.sql.*;
import java.util.ArrayList;

import data.Candidates;
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
	



	
	public ArrayList<Vastaukset> SelectEhdokkaanVastaukset() {

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

			while (result.next()) {
				Vastaukset v = new Vastaukset();
				v.setKysymys_id(result.getInt("KYSYMYS_ID"));
				v.setVastaaja_id(result.getInt("EHDOKAS_ID"));
				v.setVastaus(result.getInt("vastaus"));
				list.add(v);

			}
			return list;

		} catch (SQLException ex) {
			return null;
		}

	}
	
	public Candidates EhdokkaanTiedot(Integer ehdokas_id) throws SQLException {
		
		Candidates f =new Candidates();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection conn = DriverManager.getConnection(dbURL, username, password);

		try {
			
			String sql="select ehdokas_id, etunimi, sukunimi, puolue from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ehdokas_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				
				f.setEhdokas_id(RS.getInt("ehdokas_id"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setPuolue(RS.getString("puolue"));
				
			}
			return f;
		}
		catch(SQLException e) {
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





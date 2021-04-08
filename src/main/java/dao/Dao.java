package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Candidates;
import data.DBConnectionUtil;


public class Dao implements CandidatesDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public List<Candidates> get() {
		
		List<Candidates> list = null;
		Candidates candidates = null;
		
		try {
			
			list = new ArrayList<Candidates>();
			String sql = "SELECT * FROM ehdokkaat";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				candidates = new Candidates();
				candidates.setEhdokas_id(resultSet.getInt("ehdokas_id"));
				candidates.setSukunimi(resultSet.getString("sukunimi"));
				candidates.setEtunimi(resultSet.getString("etunimi"));
				candidates.setPuolue(resultSet.getString("puolue"));
				list.add(candidates);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Candidates get(int id) {
		Candidates candidates = null;
		try {
			candidates = new Candidates();
			String sql = "SELECT * FROM ehdokkaat where ehdokas_id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				candidates.setEhdokas_id(resultSet.getInt("ehdokas_id"));
				candidates.setSukunimi(resultSet.getString("sukunimi"));
				candidates.setEtunimi(resultSet.getString("etunimi"));
				candidates.setPuolue(resultSet.getString("puolue"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return candidates;
	}

	@Override
	public boolean save(Candidates e) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO tbl_employee(name, department, dob)VALUES"
					+ "('"+e.getSukunimi()+"', '"+e.getEtunimi()+"', '"+e.getPuolue()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int ehdokas_id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM ehdokkaat where ehdokas_id="+ehdokas_id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Candidates candidates) {
		boolean flag = false;
		try {
			String sql = "UPDATE tbl_employee SET name = '"+candidates.getSukunimi()+"', "
					+ "department = '"+candidates.getEtunimi()+"', dob = '"+candidates.getPuolue()+"' where ehdokas_id="+candidates.getEhdokas_id();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}



}




package dao;


import java.util.List;

import data.Candidates;



public interface CandidatesDAO {
	
	List<Candidates> get();
	
	Candidates get(int id);
	
	boolean save(Candidates candidates);
	
	boolean delete(int id);
	
	boolean update(Candidates candidates);
}




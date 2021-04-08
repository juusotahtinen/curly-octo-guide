import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatesDAO;
import dao.Dao;
import data.Candidates;




@WebServlet("/showcandidates")
public class ShowCandidates extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	CandidatesDAO candidatesDAO = null;
	
	public ShowCandidates() {
		candidatesDAO = new Dao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listCandidates(request, response);
				break;
				
			case "EDIT":
				getSingleCandidates(request, response);
				break;
				
			case "DELETE":
				deleteCandidates(request, response);
				break;
				
			default:
				listCandidates(request, response);
				break;
				
		}
		
	}

	private void deleteCandidates(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("ehdokas_id");
	
		if(candidatesDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Candidate Deleted Successfully!");
		}
		
		listCandidates(request, response);
	}

	private void getSingleCandidates(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("ehdokas_id");
		
		Candidates theCandidates = candidatesDAO.get(Integer.parseInt(id));
		
		request.setAttribute("candidates", theCandidates);
		
		dispatcher = request.getRequestDispatcher("/jsp/showcandidates.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listCandidates(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Candidates> theList = candidatesDAO.get();
		
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("/jsp/showcandidates.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ehdokas_id = request.getParameter("ehdokas_id");
		
		Candidates e = new Candidates();
		e.setSukunimi(request.getParameter("sukunimi"));
		e.setEtunimi(request.getParameter("etunimi"));
		e.setPuolue(request.getParameter("puolue"));
		
		if(ehdokas_id.isEmpty() || ehdokas_id == null) {
			
			if(candidatesDAO.save(e)) {
				request.setAttribute("NOTIFICATION", "Employee Saved Successfully!");
			}
		
		}else {
			
			e.setEhdokas_id(Integer.parseInt(ehdokas_id));
			if(candidatesDAO.update(e)) {
				request.setAttribute("NOTIFICATION", "Employee Updated Successfully!");
			}
			
		}
		
		listCandidates(request, response);
	}

}
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import data.Candidates;







@WebServlet("/insert")
public class InsertCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
       
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("index.html");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String sukunimi=request.getParameter("sukunimi");
		String etunimi=request.getParameter("etunimi");
		String puolue=request.getParameter("puolue");
		
		Candidates f=new Candidates(sukunimi, etunimi , puolue);
		
		ArrayList<Candidates> listAllCandidates=null;
		if (dao.getConnection()) {
			listAllCandidates=dao.insertCandidates(f);
		}
		
		request.setAttribute("listCandidates", listAllCandidates);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/insert.jsp");
		rd.forward(request, response);
    
	}
}

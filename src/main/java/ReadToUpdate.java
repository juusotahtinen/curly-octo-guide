

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import data.Candidates;


/**
 * Servlet implementation class ReadToUpdate
 */
@WebServlet("/readtoupdate")
public class ReadToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Candidates> showToUpdate = null;
		try {
			showToUpdate = dao.updateCandidates();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("showToUpdate", showToUpdate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/showcandidatetoedit.jsp");
        dispatcher.forward(request, response);
    }
}

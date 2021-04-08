import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import data.Candidates;





@WebServlet("/showcandidates")
public class ShowCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
//            case "/new":
//                showNewForm(request, response);
//                break;
//            case "/insert":
//                insertBook(request, response);
//                break;
//            case "/delete":
//                deleteBook(request, response);
//                break;
//            case "/edit":
//                showEditForm(request, response);
//                break;
//            case "/update":
//                updateBook(request, response);
//                break;
            default:
                listCandidates(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listCandidates(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Candidates> listCandidates = dao.listAllCandidates();
        request.setAttribute("listCandidates", listCandidates);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/showcandidates.jsp");
        dispatcher.forward(request, response);
    }
}
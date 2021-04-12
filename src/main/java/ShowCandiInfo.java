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






@WebServlet("/showcandiinfo1")
public class ShowCandiInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
    
	public ShowCandiInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	String ehdokas_id=request.getParameter("ehdokas_id");
        ArrayList<Candidates> p=null;
        
        if (dao.getConnection()) {
			p=dao.getEhdokasInfo(ehdokas_id);
        }
        
//        response.getWriter().println(ehdokas_id);
//        response.getWriter().println(p);

        request.setAttribute("ehdokas", p);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/showcandiinfo.jsp");
        dispatcher.forward(request, response);
    }
    
}
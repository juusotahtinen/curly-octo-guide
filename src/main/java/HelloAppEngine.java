
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAnswers;
import data.Kysymykset;
import data.Vastaukset;


@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoAnswers dao = null; 
	
    
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    dao = new DaoAnswers("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");

    ArrayList<Kysymykset> list = dao.Select();
    
    request.setAttribute("kysymykset", list);
    
    RequestDispatcher rd = request.getRequestDispatcher("jsp/GUI.jsp");
    rd.forward(request,  response);
    
    HttpSession session = request.getSession();
    session.setAttribute("pituus", list.size());
    
        

    
    
    

   
    
    
    
	
	
	
    
    


  }
}


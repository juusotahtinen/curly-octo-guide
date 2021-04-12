
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
import data.Vastaukset;



@WebServlet(
    name = "EhdokkaidenVastaukset",
    urlPatterns = {"/ehdokkaidenVastaukset"}
)
public class EhdokkaidenVastaukset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoAnswers dao = null; 
	
    
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    dao = new DaoAnswers("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");

    ArrayList<Vastaukset> list = dao.SelectEhdokkaat();
    
request.setAttribute("vastaukset", list);
    
    RequestDispatcher rd = request.getRequestDispatcher("/vastaustenVertailu");
    rd.forward(request,  response);
   
    
    
  }
  
}
    
    
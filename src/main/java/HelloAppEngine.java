import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Dao;


@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null; 
	
    public void init() {
//    	Dao dao = new Dao("jdbc:mysql://localhost:3306/vaalikone","pena", "kukkuu");
    	dao = new Dao();
    	
    	
    }
    


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    dao.Insert();
   
    
    
    
	
	
	
    
    

  }
}
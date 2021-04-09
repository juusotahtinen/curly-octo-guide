import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import data.Kysymykset;


@WebServlet(
	name = "VastaustenVertailu", 
	urlPatterns = { "/vastaustenVertailu"}
)

public class VastaustenVertailu extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {

	response.setContentType("text/plain");
	response.setCharacterEncoding("UTF-8");
	

	

	
	
	
	
	
	
	
	
	}	
}

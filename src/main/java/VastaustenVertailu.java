import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.DaoAnswers;
import data.Kysymykset;

@WebServlet(
	name = "VastaustenVertailu", 
	urlPatterns = { "/vastaustenVertailu"}
)

public class VastaustenVertailu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoAnswers dao = new DaoAnswers("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {

	response.setContentType("text/plain");
	response.setCharacterEncoding("UTF-8");
	
	response.getWriter().println("Vastauksesi");
	
	ArrayList<Integer> kayttajanVastaukset = new ArrayList<>();
	 ArrayList<Kysymykset> list = dao.Select();
	
	for (int i=0;i<list.size();i++) {
		
		String param = "radios" + i;
		String vastausString = request.getParameter(param);
		int vastaus = Integer.parseInt(vastausString);
		kayttajanVastaukset.add(vastaus);
	}
	
	
	response.getWriter().println(kayttajanVastaukset);
	
	
	
	

	
	
	
	
	
	
	
	
	}	
}

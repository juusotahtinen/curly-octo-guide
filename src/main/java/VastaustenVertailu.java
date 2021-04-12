import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


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
	
	response.getWriter().println("Vastauksesi");
	
	ArrayList<Integer> kayttajanVastaukset = new ArrayList<>();
	
	HttpSession session=request.getSession(false);
	int size = (int) session.getAttribute("pituus");
	int vastaus = 0;
	
	for (int i=0;i<size;i++) {
		
		String param = "radios" + i;
		String vastausString = request.getParameter(param);
		if (vastausString == null) {
			
			vastaus = 0;
			kayttajanVastaukset.add(vastaus);
			
		}
		else {
			
			vastaus = Integer.parseInt(vastausString);
			kayttajanVastaukset.add(vastaus);
			
		}

	}
	
	response.getWriter().println(session.getAttribute("vastaukset"));
	
//	ArrayList<List> tulokset = new ArrayList<List>();
//	   
//    //Tehd‰‰n erotus k‰ytt‰j‰n ja ehdokkaan vastauksille ja lis‰t‰‰n tulokset "erotusKayttajaEhdokas" -listaan
//    for (int i =0; i< Ehdokkaat.size(); i++){
//    	ArrayList<Integer> current = (ArrayList<Integer>) Ehdokkaat.get(i);
//    	ArrayList<Integer> tulos = new ArrayList<Integer>();
//    	
//
//    	 for (int j =0; j< current.size(); j++){
//    	    	
//    	    	int vertailu= Math.abs(kayttajanVastaukset.get(j) - current.get(j));
//    	    	tulos.add(vertailu);
//    	    }
//    	tulokset.add(tulos);
//    }
//    
//  
//   
//    
//    ArrayList<Integer> sopivuus = new ArrayList<Integer>();
//    
//    int sum=0;
//    for (int i =0; i< tulokset.size(); i++){
//    	ArrayList<Integer> current = (ArrayList<Integer>) tulokset.get(i);
//    	
//    	for (int j=0; j<current.size(); j++) {
//    	
//    		sum = current.stream().mapToInt(Integer::intValue).sum();
//    		
//    	}
//    	sopivuus.add(sum);
//    	
//    }
//    
//    System.out.println(sopivuus);
	
	
	
	

	
	
	
	
	
	
	
	
	}	
}

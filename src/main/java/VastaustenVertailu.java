import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.DaoAnswers;
import data.Candidates;
import data.Vastaukset;



@WebServlet(
	name = "VastaustenVertailu", 
	urlPatterns = { "/vastaustenVertailu"}
)

public class VastaustenVertailu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoAnswers dao = null; 


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {

	response.setContentType("text/plain");
	response.setCharacterEncoding("UTF-8");
	
	
	// First we get the answers submitted by the user and insert them into a ArrayList
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
	

	// Then we compare user answers with the candidates answers
	
	// First we connect to database via daoAnswers.java and execute method SelectEhdokkaat from daoAnswers.java
    // The ArrayList which is returned from method is inserted into list ArrayList
	dao = new DaoAnswers("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
    ArrayList<Vastaukset> list = dao.SelectEhdokkaanVastaukset();
    
    // For comparison two new ArrayLists are created
    ArrayList<ArrayList<Integer> > Ehdokkaat = new ArrayList<ArrayList<Integer> >();
    ArrayList<Integer> list2 = new ArrayList<>();
    
    // Then we use for loop to get the candidates answers from the list
    int ehdokasVastaus=0;
    

    	
			for (int j = 0; j < list.size(); j++) {

				Vastaukset v1 = list.get(j);

				ehdokasVastaus = v1.getVastaus();
				list2.add(ehdokasVastaus);
				
			}
					
			int sizeOfList = size;
			
			for (int i = 0; i < list2.size(); i += sizeOfList) {
				int end = Math.min(i + sizeOfList, list2.size());
				ArrayList<Integer> sublist = new ArrayList(list2.subList(i, end));
				Ehdokkaat.add(sublist);
				
			}
			

    // Here we make new list of the results
	ArrayList<List> tulokset = new ArrayList<List>();
	   
    
    for (int i =0; i< Ehdokkaat.size(); i++) {
    	ArrayList<Integer> current = Ehdokkaat.get(i);
    	ArrayList<Integer> tulos = new ArrayList<Integer>();
    	

    	 for (int j =0; j< current.size(); j++){
    	    	
    	    	int vertailu= Math.abs(kayttajanVastaukset.get(j) - current.get(j));
    	    	tulos.add(vertailu);
    	    }
    	tulokset.add(tulos);
    }
    
    //Then we make list how suitableness
    ArrayList<Integer> sopivuus = new ArrayList<Integer>();
    //...and same list but for sorting them in ascending order
    ArrayList<Integer> sopivuus2 = new ArrayList<Integer>();
    
    int sum=0;
    for (int i =0; i< tulokset.size(); i++){
    	ArrayList<Integer> current = (ArrayList<Integer>) tulokset.get(i);
    	
    	for (int j=0; j<current.size(); j++) {
    	
    		sum = current.stream().mapToInt(Integer::intValue).sum();
    		
    	}
    	sopivuus.add(sum);
    	sopivuus2.add(sum);
    	
    }
    
    //Then we sort the list
    
    //response.getWriter().println(sopivuus);
    Collections.sort(sopivuus);
    //response.getWriter().println(sopivuus);
    //response.getWriter().println(sopivuus2);
    int eka = sopivuus.get(0);
    int toka = sopivuus.get(1);
    int kolmas = sopivuus.get(2);
    
    //response.getWriter().println(eka + " " + toka + " " + kolmas);
    
//    response.getWriter().println(sopivuus);
    int ekaIndex =sopivuus2.indexOf(eka);
    int tokaIndex =sopivuus2.indexOf(toka);
    int kolmasIndex =sopivuus2.indexOf(kolmas);
//    response.getWriter().println("Pienimmän luvun indeksi: "+ minIndex);
    
    //Here we get the three most suitable candidates IDs
    ArrayList<Integer> paras_id = new ArrayList<Integer>();
    paras_id.add(ekaIndex);
    paras_id.add(tokaIndex);
    paras_id.add(kolmasIndex);
    //response.getWriter().println(paras_id);
    
    int count = 0;
    ArrayList<Integer> ehdokas_id = new ArrayList<Integer>();
    
    for (int i=0; i<sopivuus.size(); i++) {
    Vastaukset g = list.get(count);
    ehdokas_id.add(g.getVastaaja_id());
    count = count + size;
    }
    //response.getWriter().println(ehdokas_id);
    
    ArrayList<Integer> top3_id = new ArrayList<Integer>();
    top3_id.add(ehdokas_id.get(paras_id.get(0)));
    top3_id.add(ehdokas_id.get(paras_id.get(1)));
    top3_id.add(ehdokas_id.get(paras_id.get(2)));
    
    //response.getWriter().println(top3_id);
    

	session.setAttribute("Ehdokas_id", top3_id);
	response.sendRedirect("/naytasopivatehdokkaat");
	
	}	
}

//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.Dao;
//import data.Candidates;
//
//@WebServlet(
//    name = "Update",
//    urlPatterns = {"/update"}
//)
//public class Update extends HttpServlet {
//	private Dao dao;
//	public void init() {
//		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Lepo");
//	}
//	@Override
//	public void doGet(HttpServletRequest request, HttpServletResponse response) 
//	     throws IOException {
//		response.sendRedirect("index.html");
//	}
//	public void doPost(HttpServletRequest request, HttpServletResponse response) 
//	     throws IOException, ServletException {
//		String id=request.getParameter("id");
//		String lastname=request.getParameter("lastname");
//		
//		Candidates f=new Candidates();
//		
//		ArrayList<Candidates> list=null;
//		if (dao.getConnection()) {
//			list=dao.updateCandidates(f);
//		}
//		
//		request.setAttribute("candidatelist", list);
//		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidates.jsp");
//		rd.forward(request, response);
//	}
//}

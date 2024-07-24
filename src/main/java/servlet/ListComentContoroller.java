package servlet;

import java.io.IOException;

import DAO.ComentListDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ListComentContoroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int newComentId =  Integer.parseInt(request.getParameter("comentId"));
		String newComent = request.getParameter("coment_btn");
		
		ComentListDAO.create(newComentId, newComent, request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package servlet;

import java.io.IOException;

import DAO.ComentListDAO;
import DAO.CustomDataDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomListController")
public class CustomListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CustomDataDAO.findAll(request, response);
		
		ComentListDAO.findAll(request, response);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int form_id = Integer.parseInt(request.getParameter("delId"));

			CustomDataDAO.delete(form_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/deleteResult.jsp");
			dispatcher.forward(request, response);
	}
}

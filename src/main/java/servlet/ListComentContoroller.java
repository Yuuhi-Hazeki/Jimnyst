package servlet;

import java.io.IOException;

import DAO.ComentListDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ListComentContoroller")
public class ListComentContoroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int newComentId = Integer.parseInt(request.getParameter("comentid"));
		String newname = request.getParameter("comentname");
		String newComent = request.getParameter("coment");

		ComentListDAO.create(newComentId, newComent, newname, request, response);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customList.jsp");
		dispatcher.forward(request, response);
	}

}

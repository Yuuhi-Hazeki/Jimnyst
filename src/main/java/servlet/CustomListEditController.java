package servlet;

import java.io.IOException;

import DAO.CustomDataDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/CustomListEditController")
public class CustomListEditController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String editformid = request.getParameter("edtId");
		CustomDataDAO.findData(request, response, editformid);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CustomEdit.jsp");
		dispatcher.forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String form_id = request.getParameter("id");
		String form_title = request.getParameter("title");
		String form_sus = request.getParameter("custom_sus");
		String form_body = request.getParameter("custom_body");
		String form_engine = request.getParameter("custom_engine");
		
		CustomDataDAO.edit(form_id, form_title, form_sus, form_body, form_engine);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/EditResult.jsp");
		dispatcher.forward(request, response);
	
	}
}

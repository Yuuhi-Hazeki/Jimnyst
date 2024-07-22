package servlet;

import java.io.File;
import java.io.IOException;

import DAO.CustomDataDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/main")
@MultipartConfig
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String form_title = request.getParameter("title");
		String form_sus = request.getParameter("custom_sus");
		String form_body = request.getParameter("custom_body");
		String form_engine = request.getParameter("custom_engine");
		Part part = request.getPart("custom_img");
		
		if (part != null) {
			String filename= part.getSubmittedFileName();
			//アップロードするフォルダ
			String path=getServletContext().getRealPath("/upload");
			//実際にファイルが保存されるパス確認
			System.out.println(path);
			part.write(path+File.separator+filename);
			
			String savePath = "http://localhost:8080/Jimnyst/upload/" + filename;
			
			System.out.println(savePath);
           
            System.out.println("imgUploadSuccess!");
           
            CustomDataDAO.create(form_title, form_sus, form_body, form_engine, savePath); //CustomDataDAO.createメソッドへ

        } else {
            System.out.println("imgUploadError");
        	}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/keepResult.jsp");
		dispatcher.forward(request, response);
	}
}

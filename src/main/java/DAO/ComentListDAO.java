package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ComentListDAO extends HttpServlet {

	final static String JDBC_URL = "jdbc:h2:tcp://localhost/~/Jimnyst";
	final static String DB_USER = "sa";
	final static String DB_PASS = "";
	
	public static void create(int newComentId, String newComent, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//パラメーターを取得して、インスタンスに代入
			String sql = "INSERT INTO COMENT (ID, COMENT) VALUES (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, newComentId);
			stmt.setString(2, newComent);
		
			stmt.executeUpdate();

			System.out.println("Data inserted success!");
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

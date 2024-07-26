package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Coment;

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

	public static void findAll(HttpServletRequest request, HttpServletResponse response) {
		List<Coment> comtList = new ArrayList<>();

		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		} //データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SERECT文を準備
			String sql = "SELECT ID, COMENT FROM COMENT";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SELECT文を実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();//ResultSetインスタンスにSELECT文の結果を格納

			while (rs.next()) {//結果表の取り出し対象レコードを1つ進める
				Coment coment = new Coment();
				coment.setId(rs.getInt("ID"));
				coment.setComent(rs.getString("COMENT"));
				
				comtList.add(coment);
				HttpSession session = request.getSession();
				session.setAttribute("comtList", comtList);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

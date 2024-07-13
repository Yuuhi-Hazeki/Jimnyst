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
import model.CustomData;

public class CustomDataDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static void create(String form_title, String form_sus, String form_body, String form_engine,
			 String FilePath) {
		final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Jimnyst";
		final String DB_USER = "sa";
		final String DB_PASS = "";

		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//パラメーターを取得して、インスタンスに代入
			String sql = "INSERT INTO CUSTOMDATA (TITLE, CUSTOMSUS,"
					+ " CUSTOMBODY, CUSTOMENGINE, IMGPASS) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, form_title);
			stmt.setString(2, form_sus);
			stmt.setString(3, form_body);
			stmt.setString(4, form_engine);
			stmt.setString(5, FilePath);
			stmt.executeUpdate();

			System.out.println("Data inserted successfully!");
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CustomData> ctdList = new ArrayList<>();
		//DB接続処理
		final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Jimnyst";
		final String DB_USER = "sa";
		final String DB_PASS = "";

		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		} //データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SERECT文を準備
			String sql = "SELECT  TITLE, IMGPASS, "
					+ "CUSTOMSUS, CUSTOMBODY, CUSTOMEGINE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SELECT文を実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();//ResultSetインスタンスにSELECT文の結果を格納

			while (rs.next()) {//結果表の取り出し対象レコードを1つ進める
				CustomData customdata = new CustomData();
				customdata.setTitle(rs.getString("title"));
				customdata.setImgPass(rs.getString("ImgPass"));
				customdata.setCustomSus(rs.getString("CustomSus"));
				customdata.setCustomBody(rs.getString("CustomBody"));
				customdata.setCustomEngine(rs.getString("CustomEngine"));
				ctdList.add(customdata);
			}
			request.setAttribute("ctdList", ctdList);

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}

}

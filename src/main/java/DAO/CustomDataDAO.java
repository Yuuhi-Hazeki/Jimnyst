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
	final static String JDBC_URL = "jdbc:h2:tcp://localhost/~/Jimnyst";
	final static String DB_USER = "sa";
	final static String DB_PASS = "";

	public static void create(String form_title, String form_sus, String form_body, String form_engine,
			String savePath) {

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
			stmt.setString(5, savePath);
			stmt.executeUpdate();

			System.out.println("Data inserted success!");
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CustomData> ctdList = new ArrayList<>();

		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		} //データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SERECT文を準備
			String sql = "SELECT ID, TITLE, IMGPASS, "
					+ "CUSTOMSUS, CUSTOMBODY, CUSTOMENGINE, FROM CUSTOMDATA";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SELECT文を実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();//ResultSetインスタンスにSELECT文の結果を格納

			while (rs.next()) {//結果表の取り出し対象レコードを1つ進める
				CustomData customdata = new CustomData();
				customdata.setId(rs.getString("ID"));
				customdata.setTitle(rs.getString("TITLE"));
				customdata.setImgPass(rs.getString("IMGPASS"));
				customdata.setCustomSus(rs.getString("CUSTOMSUS"));
				customdata.setCustomBody(rs.getString("CUSTOMBODY"));
				customdata.setCustomEngine(rs.getString("CUSTOMENGINE"));
				ctdList.add(customdata);
				request.setAttribute("dataList", ctdList);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(String form_id) {
		try {
			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "DELETE FROM CUSTOMDATA WHERE id = ?";
			PreparedStatement Stmt = con.prepareStatement(sql);
			Stmt.setString(1, form_id);
			Stmt.executeUpdate();
			System.out.println("table delete succuss");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void edit(String form_id, String form_title, String form_sus, String form_body, String form_engine) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//パラメーターを取得して、インスタンスに代入
			String sql = "UPDATE CUSTOMDATA SET TITLE = ?, CUSTOMSUS = ?,"
					+ " CUSTOMBODY = ?, CUSTOMENGINE = ? WHERE ID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, form_title);
			stmt.setString(2, form_sus);
			stmt.setString(3, form_body);
			stmt.setString(4, form_engine);
			stmt.setString(5, form_id);
			
			stmt.executeUpdate();

			System.out.println("Data inserted success!");
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void findData(HttpServletRequest request, HttpServletResponse response, String editformid) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM CUSTOMDATA WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, editformid);
			ResultSet rs = statement.executeQuery();

			List<CustomData> ctdList = new ArrayList<>();
			while (rs.next()) {
				CustomData customdata = new CustomData();
				customdata.setId(rs.getString("ID"));
				customdata.setTitle(rs.getString("TITLE"));
				customdata.setImgPass(rs.getString("IMGPASS"));
				customdata.setCustomSus(rs.getString("CUSTOMSUS"));
				customdata.setCustomBody(rs.getString("CUSTOMBODY"));
				customdata.setCustomEngine(rs.getString("CUSTOMENGINE"));
				ctdList.add(customdata);

				request.setAttribute("dataList", ctdList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

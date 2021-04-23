package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Banco {

	public static Connection con;
	private static String banco = "prowayflix";

	public Banco() {
		if (con == null) {
			System.out.println("banco inicializado");
			ConectarBd();
		}
	}

	static public void ConectarBd() {

		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost/" + banco;
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "postgres");
			props.setProperty("ssl", "false");
			con = DriverManager.getConnection(url, props);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static public ResultSet ConsultarBD(String sql) {
		Statement statement;
		try {
			statement = con.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao realizar a consulta no banco de dados");
			System.out.println("Sql utilizado:");
			System.out.println(sql);
			return null;
		}
	}

	static public boolean Executar(PreparedStatement preparedStmt) {
		try {
			preparedStmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	static public ResultSet Consultar(PreparedStatement preparedStmt) {
		try {
			return preparedStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

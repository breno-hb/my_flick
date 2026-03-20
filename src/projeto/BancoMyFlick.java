package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BancoMyFlick {
public void connect(String nome, String filmeSerie, String genero, double nota) {
		
		String url = "jdbc:sqlite:filme_serie.db";
		
		try (Connection conn = DriverManager.getConnection(url)) {
			String sqlCreate = """
					CREATE TABLE IF NOT EXISTS filme_serie (
					id INTEGER PRIMARY KEY AUTOINCREMENT,
					nome TEXT NOT NULL,
					filmeSerie TEXT NOT NULL,
					genero TEXT NOT NULL,
					nota TEXT NOT NULL
					);""";
			Statement stmt = conn.createStatement();
			stmt.execute(sqlCreate);
			
			String sqlInsert = "INSERT INTO filme_serie (nome, filmeSerie, genero, nota) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, nome);
			pstmt.setString(2, filmeSerie);
			pstmt.setString(3, genero);
			pstmt.setDouble(4, nota);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

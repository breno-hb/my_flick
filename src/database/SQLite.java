package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SQLite {
	public void connect(String nome, String filmeSerie,String genero,float nota) {
		
		// Banco de Dados
		String url = "jdbc:sqlite:movie_serie.db";
		
		try (Connection conn = DriverManager.getConnection(url)) {
			String sqlCreate = """
					CREATE TABLE IF NOT EXISTS movie_serie (
					id INTEGER PRIMARY KEY AUTOINCREMENT,
					nome TEXT NOT NULL,
					filmeSerie TEXT NOT NULL,
					genero TEXT NOT NULL,
					nota REAL NOT NULL CHECK(nota >= 0 AND nota <=10)
					);""";
			
			Statement stmt = conn.createStatement();
			stmt.execute(sqlCreate);
			
			String sqlInsert = "INSERT INTO movie_serie (nome, filmeSerie, genero, nota) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, nome);
			pstmt.setString(2, filmeSerie);
			pstmt.setString(3, genero);
			pstmt.setFloat(4, nota);
			
			pstmt.executeUpdate();
			
			System.out.println("\n\nDados Salvos!!");
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}

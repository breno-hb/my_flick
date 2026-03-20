package projetoAvaliacao;

import java.util.Scanner;

public class Principal {
	public static void main (String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		BancoSqlite bancoMV = new BancoSqlite();
		
		String nome = "";
		while (nome.isEmpty()) {
			System.out.print("Nome: ");
			nome = MetodosClasse.ntt(entrada);
		}
		
		String filmeSerie = "";
		while(filmeSerie.isEmpty()) {
			System.out.print("Filme ou série: ");
			filmeSerie = MetodosClasse.ntt(entrada);
		}
		
		String genero = "";
		while(genero.isEmpty()) {
			System.out.print("Gênero: ");
			genero = MetodosClasse.ntt(entrada);
		}
		
		double nota = -1;
		
		while(nota < 0 || nota > 10) {
			System.out.print("Nota: ");
			String notaS = MetodosClasse.ntt(entrada).replace(",", ".");
			
			try {
				nota = Double.parseDouble(notaS);
				
				if (nota < 0 || nota > 10) {
					System.out.println("Erro: Digite um valor de 0 a 10!!");
				}
				
			} catch (NumberFormatException e) {
				System.out.printf("Erro: %s não é um número. Digite um valor de 0 a 10!!\n", notaS);
			}
		}
		
		System.out.println(nome + " - " + filmeSerie + " - " + genero + " - " + nota);
		
		try {
			bancoMV.connect(nome, filmeSerie, genero, nota);
			
			System.out.println("\nDados Salvos!!");
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
		
		entrada.close();
	}
}

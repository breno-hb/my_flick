package movieserie;

import java.util.Scanner;

public class Flick {
	public static void main (String[] args) {
		
		// Captura de informações do usuário para o programa
		Scanner entrada = new Scanner(System.in);
		
		String nome = "";
		while(nome.isEmpty()) {
			System.out.print("Nome: ");
			nome = entrada.nextLine().trim().toUpperCase();
		}
		
		String filmeSerie = "";
		while(filmeSerie.isEmpty()) {
			System.out.print("Filme ou Série: ");
			filmeSerie = entrada.nextLine().trim().toUpperCase();
		}
		
		String genero = "";
		while (genero.isEmpty()) {
			System.out.print("Gênero: ");
			genero = entrada.nextLine().trim().toUpperCase();
		}
		
		// Validação da nota evitando valores incorretos
		String notaStr = "";
		float notaF = -1;
		while(notaF < 0 || notaF > 10) {
			System.out.print("Nota: ");
			notaStr = entrada.nextLine().trim().replace(",", ".");
			
			try {
				notaF = Float.parseFloat(notaStr);
			} catch (NumberFormatException e) {
				System.out.print("\n\nErro: Insira um número de 0 a 10!");
				
				notaF = -1;
			}
		}
		
		System.err.printf("\n\n%s - %s - %s - %.1f", nome, filmeSerie, genero, notaF);
		
		entrada.close();
	}
}

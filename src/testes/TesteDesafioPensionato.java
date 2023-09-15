package testes;

import java.util.Iterator;
import java.util.Scanner;
import desafios.Estudante;

public class TesteDesafioPensionato {
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Quantos quartos serao alugados?");
		int n = input.nextInt();
		
		Estudante[] estudantes = new Estudante[10];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Alugel " + (i+1));
			System.out.println("Nome do locatario: ");
			input.nextLine();
			String nomeLocatario = input.nextLine();
			System.out.println("Email do locatario: ");
			String emailLocatario = input.nextLine();
			System.out.println("Quarto selecionado: ");
			int quarto = (input.nextInt() - 1);
			
			Estudante estudanteCadastrado = new Estudante(nomeLocatario,emailLocatario);
			estudantes[quarto] = estudanteCadastrado;
		}
		
		input.close();
		
		System.out.println("Quartos ocupados: ");
		for (int i = 0; i < estudantes.length; i++) {
			if(estudantes[i] != null) {
				System.out.printf("# %d, Locatario: %s, Email: %s %n" ,(i+1),estudantes[i].getNome(),
						estudantes[i].getEmail());
			}
			
		}
		
		
	}

}

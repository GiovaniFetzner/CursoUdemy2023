package generics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Exercicio01();

	}

	public static void Exercicio01() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Tamanho desejado do vetor de inteiros? ");
		int lenght = scan.nextInt();
		int[] vetor = new int[lenght];
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * 10);
		}
		System.out.println("Vetor" + Arrays.toString(vetor));
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\giova\\eclipse-workspace\\JavaCompletoUdemy2023\\Listatxt.txt"));
			for (int i = 0; i < vetor.length; i++) {
				writer.write(Integer.toString(vetor[i]));
				writer.newLine();
			}
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();								
			System.out.println(e.getLocalizedMessage());
		}
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\giova\\eclipse-workspace\\JavaCompletoUdemy2023\\Listatxt.txt"));
			String leituraDoArquivo;
			int i = 0;
			int[] numeros = new int[lenght];
			while((leituraDoArquivo = reader.readLine() )!= null) {
				numeros[i] = Integer.valueOf(leituraDoArquivo);
				System.out.printf("Linha:%d - valor lido: %s \n",i,numeros[i]);
				i++;
			}
			System.out.println("--------- XXX ---------");
			System.out.println("Leitura dos numeros: " + Arrays.toString(numeros));
			   
			Comparador comparador = new Comparador();
			System.out.println();
			System.out.println("Numero maior " + comparador.maxElement(numeros));
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

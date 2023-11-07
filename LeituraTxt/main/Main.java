package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		File arquivotxt = new File(
				"C:\\\\Users\\\\giova\\\\eclipse-workspace\\\\JavaCompletoUdemy2023\\Databasetxt.txt");

		if (arquivotxt.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(arquivotxt,true));
				System.out.println("*** Inicio da escrita ***");
				writer.newLine();
				for (int i = 1; i < 11; i++) {
					writer.append("Contagem " + i);
					writer.newLine();
				}
				System.out.println("*** Fim da escrita ***");
				writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

		if (arquivotxt.exists()) {
			leituraTxtUsandoScanner(arquivotxt);
		} else {
			criandoArquivoTxt(arquivotxt);
		}

	}

	public static void criandoArquivoTxt(File arquivotxt) {
		System.out.println("Criando arquivo. . . ");
		try {
			arquivotxt.createNewFile();
			System.out.println("\nArquivo criado!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void leituraTxtUsandoScanner(File arquivotxt) {
		Scanner leitura = null;
		try {
			System.out.println("*** Inicio da leitura ***");
			System.out.println();
			leitura = new Scanner(arquivotxt);
			while (leitura.hasNextLine()) {
				System.out.println(leitura.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado");
			System.out.println(e.getMessage());
		} finally {
			if (leitura != null) {
				leitura.close();
				System.out.println();
				System.out.println("*** Fim da leitura ***");
			}
		}
	}

}

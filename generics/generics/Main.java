package generics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Exercicio01();

	}

	public static void Exercicio01() {
		
		String path = "C:\\Users\\giova\\eclipse-workspace\\JavaCompletoUdemy2023\\Listatxt.txt";
		
		ArrayList vetorProdutos = new ArrayList<Produto>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String leituraDoArquivo = reader.readLine();
			while(leituraDoArquivo != null) {
				String[] colunas = leituraDoArquivo.split(",");
				vetorProdutos.add(new Produto (colunas[0],Double.parseDouble(colunas[1])));
				leituraDoArquivo = reader.readLine();
			}
			
			System.out.println("Leitura dos produtos: " + vetorProdutos.toString());
			   
			System.out.println();
			System.out.println("Produto de maior valor: " + Comparador.maxElement(vetorProdutos).toString());
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

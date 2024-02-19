package exercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);
		String path;

		System.out.println("Enter full file path:");
		path = scann.nextLine();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String leituraArquivo;
			List<Produto> produtos = new ArrayList<>();
			leituraArquivo = reader.readLine();
			while (leituraArquivo != null) {
				String[] fields = leituraArquivo.split(",");
				produtos.add(new Produto(fields[0], Double.parseDouble(fields[1])));
				leituraArquivo = reader.readLine();
			}
			
			System.out.println("All products " + produtos.toString());
			
			Double precoMedio = produtos.stream()
					.map(x -> x.getPreco())
					.reduce(0.0, (x,y) -> x + y)/produtos.size();
			
			List<Produto> filteredList = produtos.stream()   // Ordem decrescente usando Produto
					.filter(x -> x.getPreco() < precoMedio)
					.sorted((x,y) -> -1*(x.getNome().toUpperCase().compareTo(y.getNome().toUpperCase())))
					.toList();
			
			System.out.printf("Average price: %.2f \n" , precoMedio);
			System.out.println("Products below de average: ");
			filteredList.forEach(System.out::println);
			
		} catch (FileNotFoundException e) {
			System.out.println();
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println();
			e.printStackTrace();
		}

		scann.close();

	}

}

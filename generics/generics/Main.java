package generics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Exercicio02();

	}

	public static void Exercicio01() {

		String path = "C:\\Users\\giova\\eclipse-workspace\\JavaCompletoUdemy2023\\Listatxt.txt";

		ArrayList vetorProdutos = new ArrayList<Produto>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String leituraDoArquivo = reader.readLine();
			while (leituraDoArquivo != null) {
				String[] colunas = leituraDoArquivo.split(",");
				vetorProdutos.add(new Produto(colunas[0], Double.parseDouble(colunas[1])));
				leituraDoArquivo = reader.readLine();
			}

			System.out.println("Leitura dos produtos: " + vetorProdutos.toString());

			System.out.println();
			System.out.println("Produto de maior valor: " + Comparador.maxElement(vetorProdutos).toString());
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void Exercicio02() {
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();
		copy(myInts, myObjs);
		printList(myObjs);
		copy(myDoubles, myObjs);
		printList(myObjs);
	}

	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
	}
	public static void printList(List<Object> source) {
		for (Object object : source) {
			System.out.print(object + " ");
		}
	}
}

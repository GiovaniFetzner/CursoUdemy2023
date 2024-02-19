package exercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		exercicio02();

	}

	private static void exercicio01() {
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

			Double precoMedio = produtos.stream().map(x -> x.getPreco()).reduce(0.0, (x, y) -> x + y) / produtos.size();

			List<Produto> filteredList = produtos.stream() // Ordem decrescente usando Produto
					.filter(x -> x.getPreco() < precoMedio)
					.sorted((x, y) -> -1 * (x.getNome().toUpperCase().compareTo(y.getNome().toUpperCase()))).toList();

			System.out.printf("Average price: %.2f \n", precoMedio);
			System.out.println("Products below de average: ");
			filteredList.forEach(System.out::println);

		} catch (FileNotFoundException e) {
			System.out.println();
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println();
			e.printStackTrace();
		}

		scann.close();
	}

	private static void exercicio02() {

		Scanner scann = new Scanner(System.in);
		String path;
		System.out.println("Enter full file path: ");
		path = scann.nextLine();
		double salary;
		System.out.println("Enter salary: ");
		salary = scann.nextDouble();

		List<Funcionario> employees = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String fileReader;
			fileReader = reader.readLine();

			while (fileReader != null) {
				String fields[] = fileReader.split(",");
				employees.add(new Funcionario(fields[0], fields[1], Double.parseDouble(fields[2])));
				fileReader = reader.readLine();
			}
			
			employees = employees.stream()
					.sorted((emp1,emp2) -> emp1.getEmail().toUpperCase().compareTo(emp2.getEmail().toUpperCase()))
					.collect(Collectors.toList());
			
			System.out.println("Every employee registered: ");
			employees.forEach(System.out::println);
			System.out.println();
			
			List<Funcionario> filteredEmployees = employees.stream()
					.filter(x -> x.getSalary() > salary)
					.sorted((emp1, emp2) -> emp1.getEmail().toUpperCase().compareTo(emp2.getEmail().toUpperCase()))
					.toList();
 			System.out.println("Email of people whose salary is more than: " + salary);
 			filteredEmployees.forEach(System.out::println);
 			System.out.println();
 			
 			double sumEmployesWithM = employees.stream()
					.filter(x -> x.getName().toUpperCase().charAt(0) == 'M' )
					.mapToDouble(Funcionario::getSalary)
					.sum();
 			System.out.println("Sum of salary of people whose name starts with 'M': " + sumEmployesWithM);
 			filteredEmployees.forEach(System.out::println);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

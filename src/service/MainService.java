package service;

import java.util.Scanner;

public class MainService {

	public static void main(String[] args) {
	
		PrintService<String> printService = new PrintService();
		
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("How many values you would like to insert?");
		int lenght = leitura.nextInt();
		leitura.nextLine();
		
		for (int i = 0; i < lenght; i++) {
			System.out.printf("Declare your %d value:", (i+1));
			String number = leitura.nextLine();
			printService.addValue(number);
		}
		System.out.println("Finish ! ! !");
		System.out.println("First " + printService.first());
		printService.print();

	}

}

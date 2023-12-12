package testes;

import java.util.Scanner;

public class Diversos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		/*int a = 5;
		int b = 10;
		String answer;
		Integer c;
		
		answer =  (a>b)? "O valor de "+ a + " e maior que " + b : "O valor " + b +" e maior que " + a;
		System.out.println(answer);
		
		// Data:
		System.out.println("\n**Testes com Data**");
		LocalDate data01 =  LocalDate.now();
		System.out.println(data01);
		//LocalDate.parse
		*/
		System.out.println("Digite uma letra: ");
		String letra = sc.next();
		char caracter = letra.charAt(0);
		if(caracter == 'A') {
			System.out.println("Voce acertou ! ! !");
		}
			
		
		AbstractShape circle = new Circle("Azul", 10.00);
		System.out.println(circle.area());
		
		
		
		
		
	}

}

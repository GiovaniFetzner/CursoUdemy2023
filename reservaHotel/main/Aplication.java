package main;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import entities.Reservation;

public class Aplication {

	public static void main(String[] args) {
		
		  try {
	            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
		
		Scanner leitura = new Scanner(System.in);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Número do quarto: ");
		int numeroQuarto = leitura.nextInt();
		leitura.nextLine();
		
		System.out.println("Data de checkIn (dd/MM/yyyy): ");
		String in = leitura.nextLine();
		
		System.out.println("Data de checkOut (dd/MM/yyyy): ");
		String out = leitura.nextLine();
		
		LocalDate dataCheckIn = LocalDate.parse(in, format);
		LocalDate dataCheckOut = LocalDate.parse(out, format);
		
		Reservation reservation01 = new Reservation(numeroQuarto,dataCheckIn,dataCheckOut);	

		System.out.println("Duracao da reserva " + reservation01.duration(dataCheckIn, dataCheckOut));
		
		System.out.println("DATA : " + dataCheckIn.format(format));
		
		System.out.println("DATA : " + dataCheckOut.format(format));
		
		
	}

}

package main;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.DateErrorException;
import entities.Reservation;

public class Application {

	public static void main(String[] args) {

		try {
			System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

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

			Reservation reservation01 = null;

			reservation01 = new Reservation(numeroQuarto, dataCheckIn, dataCheckOut);

			System.out.println("Duração da reserva " + reservation01.duration(dataCheckIn, dataCheckOut));

			System.out.println(reservation01.toString());

			// Atualizar Reserva

			System.out.println("Informe as datas para atualizar a reserva: ");

			System.out.println("Número do quarto: ");
			int numeroQuartoAtualizado = leitura.nextInt();
			leitura.nextLine();

			System.out.println("Data do novo checkIn (dd/MM/yyyy): ");
			String inAtualizado = leitura.nextLine();

			System.out.println("Data do novo checkOut (dd/MM/yyyy): ");
			String outAtualizado = leitura.nextLine();

			LocalDate dataCheckInAtualizado = LocalDate.parse(inAtualizado, format);
			LocalDate dataCheckOutAtualizado = LocalDate.parse(outAtualizado, format);

			reservation01.atualizarReserva(dataCheckIn, dataCheckOut, dataCheckInAtualizado, dataCheckOutAtualizado);

			System.out.println("Duração da reserva " + reservation01.duration(dataCheckIn, dataCheckOut));

			System.out.println(reservation01.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (DateErrorException e) {
			System.out.println(e.getMessage());
		}

	}

}

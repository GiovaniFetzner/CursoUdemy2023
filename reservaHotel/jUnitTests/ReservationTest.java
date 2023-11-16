package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.DateErrorException;
import entities.Reservation;

class ReservationTest {

	String in, out, novoIn, novoOut;
	int roomNumber = 50;
	LocalDate dataCheckIn, dataCheckOut, novoDataCheckIn, novoDataCheckOut;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Reservation reservationController;

	/*
	 * public ReservationTest() { in = "10/10/2010"; out = "15/10/2010"; dataCheckIn
	 * = LocalDate.parse(in, format); dataCheckOut = LocalDate.parse(out, format);
	 * novoIn = "10/10/2010"; novoOut = "16/10/2010"; novoDataCheckIn =
	 * LocalDate.parse(novoIn, format); novoDataCheckOut = LocalDate.parse(novoOut,
	 * format);
	 * 
	 * try { reservationController = new Reservation(roomNumber,
	 * dataCheckIn,dataCheckOut); } catch (DateErrorException e) {
	 * e.printStackTrace(); } }
	 */

	@Test
	void validacaoReservaDataValida() { // CheckOut posterior ao CheckIn
		in = "10/10/2010";
		out = "15/10/2010";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
		} catch (DateErrorException e1) {
			
		}
		try {
			assertTrue(reservationController.validacaoReserva(dataCheckIn, dataCheckOut));
		} catch (DateErrorException e) {
		
			e.printStackTrace();
		}
	}

	@Test
	void validacaoReservaTestDataInvalida() { //CheckOut anterior ao CheckIn
		in = "10/10/2010";
		out = "05/10/2010";
		dataCheckIn = LocalDate.parse(in, format); 
		dataCheckOut = LocalDate.parse(out, format);
		
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertThrows(DateErrorException.class, () -> {
	            reservationController.validacaoReserva(dataCheckIn, dataCheckOut);
	        });
		} catch (DateErrorException e1) {
		}
		
	}

}

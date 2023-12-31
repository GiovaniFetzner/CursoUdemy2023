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
	void validacaoReservaTestDataInvalida01() { // CheckOut anterior ao CheckIn
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

	@Test
	void validacaoReservaTestDataInvalida02() { // CheckOut = CheckIn
		in = "10/10/2010";
		out = "10/10/2010";
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

	@Test
	void validacaoAtualizarReservaDataValida() { // Novas datas superiores as antigas
		in = "10/10/2010";
		out = "15/10/2010";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		novoIn = "12/10/2010";
		novoOut = "17/10/2010";
		novoDataCheckIn = LocalDate.parse(novoIn, format);
		novoDataCheckOut = LocalDate.parse(novoOut, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertTrue(reservationController.validacaoAtualizarReserva(dataCheckIn, dataCheckOut, novoDataCheckIn,
					novoDataCheckOut));
		} catch (DateErrorException e1) {

		}

	}

	@Test
	void validacaoAtualizarReservaDataValida02() { // NovoCheckIn igual ao checkIn e com novoCheckOut posterior ao
													// checkOut
		in = "10/10/2010";
		out = "15/10/2010";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		novoIn = "10/10/2010";
		novoOut = "18/10/2010";
		novoDataCheckIn = LocalDate.parse(novoIn, format);
		novoDataCheckOut = LocalDate.parse(novoOut, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertTrue(reservationController.validacaoAtualizarReserva(dataCheckIn, dataCheckOut, novoDataCheckIn,
					novoDataCheckOut));
		} catch (DateErrorException e1) {

		}

	}

	@Test
	void validacaoAtualizarReservaDataInvalida01() { // Novas datas iguais as antigas
		in = "10/10/2010";
		out = "15/10/2010";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		novoIn = "10/10/2010";
		novoOut = "15/10/2010";
		novoDataCheckIn = LocalDate.parse(novoIn, format);
		novoDataCheckOut = LocalDate.parse(novoOut, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertThrows(DateErrorException.class, () -> {
				reservationController.validacaoAtualizarReserva(dataCheckIn, dataCheckOut, novoDataCheckIn,
						novoDataCheckOut);
			});

		} catch (DateErrorException e1) {

		}

	}

	@Test
	void validacaoAtualizarReservaDataInvalida02() { // NovoCheckIn mais antigo que o CheckIn, com NovoCheckOut
														// posterior ao CheckOut
		in = "10/10/2010";
		out = "15/10/2010";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		novoIn = "05/10/2010";
		novoOut = "20/10/2010";
		novoDataCheckIn = LocalDate.parse(novoIn, format);
		novoDataCheckOut = LocalDate.parse(novoOut, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertThrows(DateErrorException.class, () -> {
				reservationController.validacaoAtualizarReserva(dataCheckIn, dataCheckOut, novoDataCheckIn,
						novoDataCheckOut);
			});

		} catch (DateErrorException e1) {

		}

	}

	@Test
	void validacaoAtualizarReservaDataInvalida03() { // NovoCheckIn e NovoCheckOut mais antigos que checkIn e CheckOut
		in = "10/10/2010";
		out = "15/10/2010";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		novoIn = "05/10/2010";
		novoOut = "10/10/2010";
		novoDataCheckIn = LocalDate.parse(novoIn, format);
		novoDataCheckOut = LocalDate.parse(novoOut, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertThrows(DateErrorException.class, () -> {
				reservationController.validacaoAtualizarReserva(dataCheckIn, dataCheckOut, novoDataCheckIn,
						novoDataCheckOut);
			});

		} catch (DateErrorException e1) {

		}

	}
	
	@Test
	void validacaoAtualizarReservaDataInvalida04() { // Ano da nova reserva anterior a data do checkIn/Out
		in = "23/09/2019";
		out = "26/09/2019";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		novoIn = "24/09/2015";
		novoOut = "29/09/2015";
		novoDataCheckIn = LocalDate.parse(novoIn, format);
		novoDataCheckOut = LocalDate.parse(novoOut, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertThrows(DateErrorException.class, () -> {
				reservationController.validacaoAtualizarReserva(dataCheckIn, dataCheckOut, novoDataCheckIn,
						novoDataCheckOut);
			});

		} catch (DateErrorException e1) {

		}

	}

	@Test
	void validacaoAtualizarReservaDataAleatoria() { // Teste aleatório
		in = "10/12/2010";
		out = "15/02/2011";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		novoIn = "10/12/2011";
		novoOut = "12/04/2012";
		novoDataCheckIn = LocalDate.parse(novoIn, format);
		novoDataCheckOut = LocalDate.parse(novoOut, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertTrue(reservationController.validacaoAtualizarReserva(dataCheckIn, dataCheckOut, novoDataCheckIn,
					novoDataCheckOut));
		} catch (DateErrorException e1) {

		}

	}

	@Test
	void durationTest01() { // Diferença 5 dias
		in = "10/10/2010";
		out = "15/10/2010";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertEquals(reservationController.duration(dataCheckIn, dataCheckOut), 5);

		} catch (DateErrorException e) {
			// TODO: handle exception
		}

	}

	@Test
	void durationTest02() { // Diferença = 0, datas iguais
		in = "10/10/2010";
		out = "10/10/2010";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertEquals(reservationController.duration(dataCheckIn, dataCheckOut), 0);

		} catch (DateErrorException e) {
			// TODO: handle exception
		}

	}

	@Test
	void durationTest03() { // Diferença -5, datas invertidas
		in = "15/10/2010";
		out = "10/10/2010";
		dataCheckIn = LocalDate.parse(in, format);
		dataCheckOut = LocalDate.parse(out, format);
		reservationController = null;
		try {
			reservationController = new Reservation(roomNumber, dataCheckIn, dataCheckOut);
			assertEquals(reservationController.duration(dataCheckIn, dataCheckOut), (-5));

		} catch (DateErrorException e) {
			// TODO: handle exception
		}

	}
}

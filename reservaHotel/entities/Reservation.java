package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

public class Reservation {

	private int roomNumber;
	private LocalDate checkIn, checkOut;

	public Reservation(int numeroQuarto, LocalDate checkIn, LocalDate checkOut) throws DateErrorException {
		this.setCheckIn(checkIn);
		setCheckOut(checkOut);
		setRoomNumber(numeroQuarto);

		validacaoReserva(checkIn, checkOut);
	}

	public long duration(LocalDate checkIn, LocalDate checkOut) {
		LocalDateTime checkInDateTime = checkIn.atStartOfDay();
		LocalDateTime checkOutDateTime = checkOut.atStartOfDay();
		Duration timeDuration = Duration.between(checkInDateTime, checkOutDateTime);

		return timeDuration.toDays();
	}

	public void atualizarReserva(LocalDate checkIn, LocalDate checkOut, LocalDate novoCheckIn, LocalDate novoCheckOut)
			throws DateErrorException {
		validacaoAtualizarReserva(checkIn, checkOut, novoCheckIn, novoCheckOut);
		System.out.println("Aqui precisa para na exception !!!!!!!!");
		setCheckIn(checkIn);
		setCheckIn(checkOut);

	}

	public boolean validacaoReserva(LocalDate checkIn, LocalDate checkOut) throws DateErrorException {
		if (duration(checkIn, checkOut) > 0) {
			return true;
		} else {
			throw new DateErrorException("Erro na reserva: Data de checkOut deve ser superior a data de checkIn");
		}

	}

	public boolean validacaoAtualizarReserva(LocalDate checkIn, LocalDate checkOut, LocalDate novoCheckIn,
			LocalDate novoCheckOut) throws DateErrorException { // ARRUMAR VALIDAÇÕES DAS DATAS
		if (duration(novoCheckIn, novoCheckOut) <= 0) {
			throw new DateErrorException("Erro na reserva: Data de checkOut deve ser superior a data de checkIn");

		} else if ((duration(novoCheckIn, checkIn) <= 0) || (duration(novoCheckOut, checkOut) <= 0)) {
			throw new DateErrorException("Erro na reserva: As datas devem ser superiores as datas antigas");
		}
		return true;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
//	public void setCheckIn(String date) {
//		this.checkIn = verificaData(date);
//	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Reserva: \n");
		stringBuilder.append("Número do quarto: " + roomNumber + ", ");
		stringBuilder.append("checkIn: " + checkIn + ", ");
		stringBuilder.append("checkOut: " + checkOut + ", ");
		stringBuilder.append("duração: " + duration(checkIn, checkOut) + " noites");
		return stringBuilder.toString();
	}

//	public void setCheckOut(String date) {
//		this.checkOut = verificaData(date);
//	}

//	private LocalDate verificaData(String date) {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		return LocalDate.parse(date,format);
//	}

}

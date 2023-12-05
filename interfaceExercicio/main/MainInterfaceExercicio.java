package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import entities.OnlinePaymentService;
import entities.PaypalService;

public class MainInterfaceExercicio {

	public static void main(String[] args) {
		
		Scanner leitura = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int number = leitura.nextInt();
		leitura.nextLine();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(leitura.nextLine(), fmt);
		System.out.print("Valor do contrato: ");
		double value = leitura.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		int months = leitura.nextInt();
		
		Contract contract = new Contract(number, date, value);
		ContractService(contract, months,new PaypalService());
	}
	
	public static void ContractService(Contract contract, int months, OnlinePaymentService onlinePaymentService) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Parcelas: ");
		
		for (int i = 1; i <= months; i++) {
			double valueInstallment = (contract.getTotalValue() / months);
			LocalDate dueDate = contract.getDate();
			dueDate = dueDate.plusMonths(i);
			valueInstallment = onlinePaymentService.interest(valueInstallment, i);
			valueInstallment = onlinePaymentService.paymentFee(valueInstallment);
			
			
			Installment installment = new Installment(dueDate,valueInstallment);
			System.out.printf("%s - R$ %.2f%n" , installment.getDueDate().format(fmt), installment.getAmount());
			
		}
		
	}

}

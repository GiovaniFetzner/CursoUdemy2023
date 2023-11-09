package desafio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
			Scanner scanner = new Scanner(System.in);
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			System.out.print("Enter with the Department name: ");
			String departamentName = scanner.nextLine();
			Department department = new Department(departamentName);
			System.out.println("Enter worker data:");
			System.out.print("Name:");
			String employeeName = scanner.nextLine();
			System.out.print("Level:");
			String level = scanner.nextLine();
			System.out.print("Base salary:");
			double baseSalary = scanner.nextDouble();
			scanner.nextLine();
			Worker employee = new Worker(employeeName, 
					WorkerLevel.valueOf(level.toUpperCase()), baseSalary, department);
			
			System.out.print("How may contracts to this worker?");
			int numberOfContracts = scanner.nextInt();
			scanner.nextLine();
			
			for (int i = 1; i <= numberOfContracts; i++) {
				
				System.out.println("Enter contract #" + i + " data:");
				System.out.print("Date (DD/MM/YYYY):");
				String dateInput = scanner.nextLine();
				LocalDate date = LocalDate.parse(dateInput, format);
				System.out.print("Value per hour:");
				double valuePerHour = scanner.nextDouble();
				System.out.print("Hours:");
				int hours = scanner.nextInt();
				scanner.nextLine();
				HourContract contract = new HourContract(date, valuePerHour, hours);
				employee.addContract(contract);
			}
			
			System.out.println();
			System.out.print("Enter the month and year to calculate income (MM/yyyy): ");
			String monthAndYear = scanner.next();
			int month = Integer.parseInt(monthAndYear.substring(0, 2));
			int year = Integer.parseInt(monthAndYear.substring(3));
			System.out.println("Name: " + employee.getName());
			System.out.println("Department: " + employee.getDepartment().getName());
			System.out.println("Income " + employee.income(year, month));
			
			
			scanner.close();
			
			/*
			 * System.out.println("---------------------");
			 * System.out.println(department.getName());
			 * System.out.println(employee.getName());
			 * System.out.println(employee.getBaseSalary());
			 * System.out.println(employee.getLevel());
			 * System.out.println(employee.getDepartment().getName());
			 */
			
		}

}

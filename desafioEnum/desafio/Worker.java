package desafio;

import java.util.ArrayList;

public class Worker {

	private String name;
	private WorkerLevel level;
	private double baseSalary;
	
	private Department department;
	private ArrayList<HourContract> contracts = new ArrayList();
	
	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		for (HourContract contract : contracts) {
			if(contract.getDate().getYear() == year && contract.getDate().getMonthValue() == month) {
				sum += contract.totalValue();
			}
		}
		return sum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ArrayList<HourContract> getContracts() {
		return contracts;
	}
	
	
}

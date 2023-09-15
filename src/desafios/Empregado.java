package desafios;

public class Empregado {
	
	int id;
	String nome;
	double salario;
	
	public Empregado() {
		
	}
	
	public Empregado(int id, String nome, double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	public boolean calculaNovoSalario(double porcentagemAumento) {
		this.salario *= (1 + (porcentagemAumento/100));
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ID: " + id + 
				", Nome: " + nome + 
				", Salario: " + salario;
	}
	
	

}

package testes;

public abstract class AbstractShape implements Shape{

	private String cor;
	
	public AbstractShape(String cor) {

		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}

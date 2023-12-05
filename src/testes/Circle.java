package testes;

public class Circle extends AbstractShape {

	private double radius;

	public Circle(String cor, double radius) {
		super(cor);
		this.radius = radius;
	}



	@Override
	public double area() {

		return 3.14 * (radius*radius);
	}

}

package ejercicio3;

public class Circulo extends Figura{
	private double radio;
	public Circulo(double radio,String color) throws Exception {
		super(color);
		this.radio=radio;
	}
	
	public double area() {
		return Math.PI*radio*radio;
	}
}

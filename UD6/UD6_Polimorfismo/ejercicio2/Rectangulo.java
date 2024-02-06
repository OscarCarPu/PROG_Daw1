package ejercicio2;

public class Rectangulo extends Figura{
	private double base;
	private double altura;
	
	Rectangulo(double base, double altura,String color){
		super(color);
		this.base=base;
		this.altura=altura;
	}
	
	public double area() {
		return base*altura;
	}
}

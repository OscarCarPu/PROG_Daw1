package ejercicio2;

public class Circulo extends Figura{
	private double radio;
	
	Circulo(double radio,String color){
		super(color);
		this.radio=radio;
	}
	
	public double area() {
		return Math.PI*radio*radio;
	}
}

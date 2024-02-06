package ejercicio5;

public class Circulo extends Figura{
	private double radio;
	Circulo(double radio,String color){
		super(color);
		this.radio=radio;
	}
	
	double area() {
		return Math.PI*radio*radio;
	}
}

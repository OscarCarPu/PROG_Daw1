package ejercicio3;

class Figura{
	private String color;
	
	public void setColor(String color) {
		this.color=color;
	}
	
	public String getColor() {
		return color;
	}
	
	Figura(String color){
		this.color=color;
	}
}

class Cuadrado extends Figura{
	private double lado;
	
	public void setLado(double lado) {
		this.lado=lado;
	}
	
	public double getLado() {
		return lado;
	}
	
	Cuadrado(String color,double lado){
		super(color);
		this.lado=lado;
	}
}

class Circulo extends Figura{
	private double radio;
	
	public void setRadio(double radio) {
		this.radio=radio;
	}
	
	public double getRadio() {
		return radio;
	}
	
	Circulo(String color,double radio){
		super(color);
		this.radio=radio;
	}
	
}

public class Principal {
	public static void main(String[] args) {
		Cuadrado miCuadrado = new Cuadrado("azul",2.5);
		System.out.println("Lado de miCuadrado: "+miCuadrado.getLado());
		Circulo miCirculo = new Circulo("blanco",3.6);
		System.out.println("Color de miCirculo: "+miCirculo.getColor());
	}
}

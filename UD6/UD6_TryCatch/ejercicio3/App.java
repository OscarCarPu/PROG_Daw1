package ejercicio3;

public class App {
	public static void main(String[] args) {
		try {
			Circulo c = new Circulo(2.0,"blanco");
			System.out.println("Area circulo "+c.area());
		} catch(Exception e) {
			System.out.println("NO SE PUDO CREAR OBJETO: "+e.getMessage());
		}
		try {
			Triangulo t = new Triangulo(2.0,3.0,"rojo");
			System.out.println("Area triangulo "+t.area());
		} catch(Exception e) {
			System.out.println("NO SE PUEDO CREAR OBJETO "+e.getMessage());
		}
	}
}

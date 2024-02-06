package ejercicio2;

public class Unidad4{
	public static void main(String[] args) {
		Figura figuras[] = new Figura[9];
		figuras[0] = new Triangulo(10,12,"rojo");
		figuras[1] = new Triangulo(1,2,"azul");
		figuras[2] = new Triangulo(4,4,"blanco");
		figuras[3] = new Rectangulo(3,6,"verde");
		figuras[4] = new Rectangulo(1,9,"rosa");
		figuras[5] = new Rectangulo(32,61,"magnate");
		figuras[6] = new Circulo(3,"amarillo");
		figuras[7] = new Circulo(5,"azulado");
		figuras[8] = new Circulo(8,"gris");
		for(int i=0;i<9;i++) {
			System.out.println("El área es "+figuras[i].area()+" y el color "+figuras[i].color);
			if(figuras[i].area()>4.0) {
				System.out.println("El color cambia a negro");
				figuras[i].color="negro";
			}
		}
	}
}

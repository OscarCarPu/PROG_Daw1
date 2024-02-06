import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CentroCultural centro = new CentroCultural();
		int opcion;
		do {
			System.out.println("Introduce una opción:");
			System.out.println("0 - Salir");
			System.out.println("1 - Da de alta a un cliente:");
			System.out.println("2 - Da de alta un material:");
			System.out.println("3 - Realiza un prestamo:");
			System.out.println("4 - Lita los prestamos de un cliente:");
			System.out.println("5 - Compara dos libros:");
			System.out.println("6 - Averigua donde colocar un material:");
			opcion=in.nextInt();
			switch(opcion) {
				case 0:
					break;
				case 1:
					centro.altaCliente(in);
					break;
				case 2:
					centro.altaMaterial(in);
					break;
				case 3:
					centro.prestamo(in);
					break;
				case 4:
					centro.listarPrestamos(in);
					break;
				case 5:
					centro.compararLibros(in);
					break;
				case 6:
					centro.dondeColocar(in);
					break;
				default:break
				;
			}
		}while(opcion!=0);
		in.close();
	}
}

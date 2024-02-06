package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Agenda a = new Agenda();
		a.mostrar();
		for(int i=0;i<20;i++) {
			String nombre=in.next();
			String email=in.next();
			int telefono=in.nextInt();
			a.actualizarIdx(i, nombre, email, telefono);
		}
		a.mostrar();
		String email=in.next();
		String nombre=in.next();
		String emailNew=in.next();
		int telefono=in.nextInt();
		a.actualizar(email,nombre,emailNew,telefono);
		a.mostrar();
		in.close();
	}
}

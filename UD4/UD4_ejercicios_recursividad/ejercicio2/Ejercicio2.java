package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void suma(Scanner in,int i,int su) {
		System.out.println("Ingrese el #"+i+": ");
		int x=in.nextInt();
		if(x==0) {
			System.out.println("Se ingreso cero");
			System.out.println("Suma total: "+su);
			System.out.println("Fin!.");
			return;
		}
		su+=x;
		suma(in,i+1,su);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
				suma(in,1,0);
		in.close();
	}
}

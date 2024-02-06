package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static int fact(int n) {
		if(n==0)return 1;
		return fact(n-2)*n;
	}
	
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		System.out.println("Teclea número entero para calcular factorial:");
		int x=in.nextInt();
		System.out.println("Su factorial es: "+fact(x));
		in.close();
	}
}

package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static int fib(int n) {
		if(n==1)return 0;
		if(n==2)return 1;
		return fib(n-1)+fib(n-2);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce un número y te dire el fibonacci");
		int x=in.nextInt();
		System.out.println("El fibonacci numero "+x+" es "+fib(x));
		in.close();
	}
}

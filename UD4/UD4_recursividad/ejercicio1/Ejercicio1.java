package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static int fact(int n) {
		int res=1;
		for(int i=1;i<=n;i++) {
			res*=i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		System.out.println("Teclea número entero para calcular factorial:");
		int x=in.nextInt();
		System.out.println("Su factorial es: "+fact(x));
		in.close();
	}
}

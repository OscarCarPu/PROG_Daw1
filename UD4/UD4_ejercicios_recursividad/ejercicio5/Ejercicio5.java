package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

	public static void print(int x) {
		if(x==0)return;
		System.out.print(x+" ");
		print(--x);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x=in.nextInt();
		print(x);
		in.close();
	}
}

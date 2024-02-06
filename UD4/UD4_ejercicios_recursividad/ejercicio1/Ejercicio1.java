package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void ciudad(int i,Scanner in) {
		if(i==6)return;
		System.out.print("Ingrese el nombre de la ciudad #"+i+": ");
		String s=in.nextLine();
		ciudad(i+1,in);
		System.out.println("Ciudad #"+i+": "+s);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ciudad(1,in);
		in.close();
	}
}

package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static int potencia(int a,int p) {
		if(p==0)return 1;
		if(p==1)return a;
		return potencia(a*a,p/2)*(p%2==1?a:1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x=in.nextInt();
		int y = in.nextInt();
		System.out.println(potencia(x,y));
		in.close();
		
	}
}

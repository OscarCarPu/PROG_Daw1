package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {
	
	public static String rever(String a) {
		return rever(a,"");
	}
	public static String rever(String a,String b) {
		if(a.length()==0)return b;
		char e=a.charAt(a.length()-1);
		b+=e;
		a=a.substring(0, a.length()-1);
		return rever(a,b);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s=in.next();
		System.out.print(rever(s));
		in.close();
	}
}

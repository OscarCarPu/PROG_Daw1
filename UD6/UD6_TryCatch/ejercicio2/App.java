package ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=0;
		while(true) {
			try {
				System.out.println("Introduce un número entero:");
				n=in.nextInt();
				break;
			} catch(InputMismatchException e){
				System.out.println("Error: Debes introducir un número entero.");
				in.next();
			}
		}
		int factorial=n;
    String salida=n+"! = "+n;
    for(int i=n-1;i>0;i--){
        salida+="*"+i;
        factorial*=i;
    }
    salida+=" = "+factorial;
    System.out.println(salida);
	}
}



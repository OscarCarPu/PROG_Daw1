package ejercicio4;
import java.util.Random;
import java.util.Scanner;
public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Tamaño");
		int x = in.nextInt();
		int arr[][] = new int[x][x];
		Random r = new Random();
		for(int i=0;i<x;i++) {
			for(int j=0;j<x;j++) {
				arr[i][j]=r.nextInt(0,100);
			}
		}
		for(int[] sa: arr) {
			for(int a : sa) {
				System.out.print(a+"\t");
			}
			System.out.println();
		}
		for(int i=0;i<x;i++) {
			for(int j=0;j<x;j++) {
				if(i==j) {
					int aux=arr[i][j];
					arr[i][j]=arr[i][x-j-1];
					arr[i][x-j-1]=aux;
				}
			}
		}
		System.out.println();
		for(int[] sa: arr) {
			for(int a : sa) {
				System.out.print(a+"\t");
			}
			System.out.println();
		}
	}
}

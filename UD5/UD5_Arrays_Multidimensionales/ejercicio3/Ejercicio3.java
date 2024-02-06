package ejercicio3;

public class Ejercicio3 {
	public static void main(String[] args) {
		int[][] arrayDosD= {{11,12,13,14},{21,22},{31,32,33}};
		for(int[] a : arrayDosD) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
}

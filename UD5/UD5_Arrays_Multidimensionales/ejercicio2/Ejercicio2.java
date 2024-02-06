package ejercicio2;

public class Ejercicio2 {
	public static void main(String[] args) {
		int[][] arrayDosD= {{11,12,13,14},{21,22},{31,32,33}};
		for(int i=0;i<arrayDosD.length;i++) {
			System.out.println("cargamos e imprimimos arrayDosD["+i+"]. Observa que su tamaño es "+arrayDosD[i].length);
			for(int j=0;j<arrayDosD[i].length;j++) {
				System.out.println("arrayDosD["+i+"]["+j+"]="+arrayDosD[i][j]);
			}
			System.out.println();
		}
	}
}

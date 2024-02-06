package ejercicio1;

public class Ejercicio1 {
	public static void main(String args[]) {
		int[][] arrayDosD = new int[3][];
		arrayDosD[0]=new int[4];
		arrayDosD[1]=new int[2];
		arrayDosD[2]=new int[3];
		for(int i=0;i<arrayDosD.length;i++) {
			System.out.println("cargamos e imprimimos arrayDosD["+i+"]. Observa que su tamaño es "+arrayDosD[i].length);
			for(int j=0;j<arrayDosD[i].length;j++) {
				arrayDosD[i][j] = i*j + i + j*2;
				System.out.println("arrayDosD["+i+"]["+j+"]="+arrayDosD[i][j]);
			}
			System.out.println();
		}
	}
}

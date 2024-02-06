package ejercicio6;

import java.util.Random;

public class Ejercicio6 {
	public static void main(String[] args) {
		int cnt[][][] = new int[12][][];
		cnt[0] = new int[31][24];
		cnt[1] = new int[28][24];
		cnt[2] = new int[31][24];
		cnt[3] = new int[30][24];
		cnt[4] = new int[31][24];
		cnt[5] = new int[30][24];
		cnt[6] = new int[31][24];
		cnt[7] = new int[31][24];
		cnt[8] = new int[30][24];
		cnt[9] = new int[31][24];
		cnt[10] = new int[30][24];
		cnt[11] = new int[31][24];
		Random r = new Random();
		for(int i=0;i<12;i++) {
			for(int j=0;j<cnt[i].length;j++) {
				for(int h=0;h<24;h++) {
					cnt[i][j][h]=r.nextInt(0,1000);
				}
			}
		}
		for(int i=0;i<12;i++) {
			int ma=0;
			for(int j=0;j<cnt[i].length;j++) {
				for(int h=0;h<24;h++) {
					ma=Math.max(ma, cnt[i][j][h]);
				}
			}
			System.out.println("El máximo del mes n "+i+" es "+ma);
		}
		int ma=0;
		for(int h=0;h<24;h++) {
			ma=Math.max(ma, cnt[2][2][h]);
		}
		
		System.out.println("El 3 de marzo hubo un máximo de "+ma);

		
	}
}

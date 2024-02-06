package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] nums = new int[10];
		System.out.println("Introduce 10 números:");
		for(int i=0;i<10;i++) {
			nums[i]=in.nextInt();
		}
		int cnt=0;
		for(int i=0;i<10;i++) {
			if(nums[i]%2==1)cnt++;
		}
		System.out.println("Hay "+(10-cnt)+" números pares y "+cnt+" impares.");
		in.close();
	}
}

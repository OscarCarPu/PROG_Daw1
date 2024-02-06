package ejercicio2;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nums[] = new int[10];
		System.out.println("Introduce 10 números");
		for(int i=0;i<10;i++) {
			nums[i]=in.nextInt();
		}
		Arrays.sort(nums);
		int cnt=1;
		for(int i=1;i<10;i++) {
			if(nums[i]!=nums[i-1])cnt++;
		}
		int orde[] = new int[cnt];
		int id=0;
		orde[id++]=nums[0];
		for(int i=1;i<10;i++) {
			if(nums[i]==nums[i-1])continue;
			orde[id++]=nums[i];
		}
		for(int i=0;i<cnt;i++) {
			System.out.print(orde[i]+" ");
		}
		in.close();
	}
}

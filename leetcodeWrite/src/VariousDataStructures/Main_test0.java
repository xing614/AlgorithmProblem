package VariousDataStructures;

import java.util.Scanner;

public class Main_test0 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("(小顶堆)请输入堆大小：");
		int m=scan.nextInt();
		Test0 test = new Test0(m);
		int[] a = {51,32,73,23,42,62,99,14,24,3943,58,65,80,120};
		for(int i=0;i<a.length;i++){
			test.addToSmall(a[i]);
		}
		test.printSmall();				
//		test.del();
//		test.printSmall();	
//	
		scan.close();
	}
}

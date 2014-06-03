package interview;

import java.util.Random;

public class LocalMaxMin {

	public static int[] localMM(int[] a) {
		for (int i = 0; i <= a.length - 3; i ++) {
			int temp;
			if (a[i] >= a[i + 1] && a[i + 1] >= a[i + 2]) {
				temp = a[i + 2];
				a[i + 2] = a[i + 1];
				a[i + 1] = temp;
			} else if (a[i] <= a[i + 1] && a[i + 1] <= a[i + 2]) {
				temp = a[i + 2];
				a[i + 2] = a[i + 1];
				a[i + 1] = temp;
			}
		}
		return a;
	}
	
	public static void main(String args[]) {
		int size = 10;
		int[] testInt = new int[size];
		
		Random rand = new Random();

		for (int i = 0; i < testInt.length; i ++) {	
			testInt[i] = rand.nextInt(20);
		}
		
		int[] result = LocalMaxMin.localMM(testInt);
		
		for (int i = 0; i < result.length; i ++) {
			System.out.print(result[i] + ", ");
		}
	}
}

package creerCup;


public class ZerosBeforeNonzeros {
	public void reArrange(int[] A) {
		int len = A.length;
		int i = 0;
		int j = len - 1;
		
		while (i < j) {
			while (A[i] == 0) i ++;
			while (A[j] != 0) j --;
			if (i < j) {
				A[i] = A[i] ^ A[j];
				A[j] = A[i] ^ A[j];
				A[i] = A[i] ^ A[j];
			}
		}
	}
	
	public static void main(String args[]) {
		ZerosBeforeNonzeros solution = new ZerosBeforeNonzeros();
		int[] list = {2, 3, 0, 5, 6, 1, 0, 3, 14, 12};
		for (int i = 0; i < list.length; i ++)
			System.out.print(list[i] + ", ");
		solution.reArrange(list);
		System.out.println();
		for (int i = 0; i < list.length; i ++)
			System.out.print(list[i] + ", ");
	}
}
 
package leetcode;


public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num == null) {
			return;
		}

		int len = num.length;
		for (int i = len - 2; i >= 0; i--) {
			if (num[i + 1] > num[i]) {
				int j = 0;
				for (j = len - 1; j >= i; j--) {
					if (num[j] > num[i])
						break;
				}
				
				swap(num, i, j);
				reverse(num, i + 1, len - 1);
				return;
			}
		}
		reverse(num, 0, len - 1);
	}

	private void swap(int[] num, int i, int j) {
		num[i] = num[i] ^ num[j];
		num[j] = num[i] ^ num[j];
		num[i] = num[i] ^ num[j];
//		int temp = num[i];
//		num[i] = num[j];
//		num[j] = temp;
	}

	private void reverse(int[] num, int left, int right) {
		int i = left, j = right;
		while (i < j) {
			swap(num, i++, j--);
		}
	}
	
	public static void main(String args[]) {
		NextPermutation solution = new NextPermutation();
		int[] per = new int[]{1, 2, 3};
		solution.nextPermutation(per);
		for (int i = 0; i < per.length; i ++)
			System.out.print(per[i] + ", ");
	}
}

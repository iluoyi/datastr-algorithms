package leetcode;

/**
 * Math
 * 
 * a1 = k / (n - 1)! 
 * k1 = k % (n - 1)!
 * 
 * 
 * @author yiluo
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int factor = 1, selected;
		int[] num = new int[n];
		
		for (int i = 0 ; i < n; i ++) {
			num[i] = i + 1;
			factor *= num[i];
		}
		
		k --;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i ++) {
			factor = factor / (n - i); // for (n - 1)
			selected = k / factor;
			sb.append(num[selected]);
			for (int j = selected; j < n - i - 1; j ++) { // can be replaced with a "used[]" array
				num[j] = num[j + 1]; // erase selected!
			}
			k = k % factor;
		}
		
		return sb.toString();
	}
	
	public static void main(String args[]) {
		PermutationSequence solution = new PermutationSequence();
		System.out.println(solution.getPermutation(1, 1));
	}
}

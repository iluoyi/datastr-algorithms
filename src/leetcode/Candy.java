package leetcode;

/**
 * DP, O(n)
 * left -> right
 * right -> left
 *  
 * @author yiluo
 *
 */
public class Candy {
	public int candy(int[] ratings) {	
		if (ratings == null || ratings.length == 0) return 0;
		
		int len = ratings.length;
		int[] candyNum = new int[len];
		
		candyNum[0] = 1;
		for (int i = 1; i < len; i ++) {
			if (ratings[i] > ratings[i - 1])
				candyNum[i] = candyNum[i - 1] + 1;
			else 
				candyNum[i] = 1;
		}
		
		for (int i = len - 2; i >= 0; i --) {
			if (ratings[i] > ratings[i + 1])
				candyNum[i] = Math.max(candyNum[i + 1] + 1, candyNum[i]);
		}
		
		int result = 0;
		for (int i = 0; i < len; i ++) {
			result += candyNum[i];
		}
		
		return result;
	}
}

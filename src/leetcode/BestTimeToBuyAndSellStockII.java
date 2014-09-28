package leetcode;

public class BestTimeToBuyAndSellStockII {
	/**
	 * Naive simulation of the greedy process,
	 * but we have a more elegant solution
	 */
//	public int maxProfit(int[] prices) {
//        int profit = 0;
//        int i = 0;
//        while (i < prices.length - 1) {
//            if (prices[i] < prices[i + 1]) { // boundary
//                int j = i + 1;
//                while (j < prices.length && prices[j] >= prices[j - 1]) {
//                    j ++;
//                }
//                // we want to sell at j - 1
//                profit += (prices[j - 1] - prices[i]);
//                i = j - 1;
//            } else {
//                i ++;
//            }
//        }
//        return profit;
//    }
	
	public int maxProfit(int[] prices) {
		int sum = 0, diff = 0;
		for (int i = 1; i < prices.length; i++) {
			diff = prices[i] - prices[i - 1];
			if (diff > 0) sum += diff;
		}
		return sum;
	}
}

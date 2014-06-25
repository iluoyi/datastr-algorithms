package leetcode;

public class BestTimeToBSStock {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
        	return 0;
        } else {
        	int crtMin = prices[0];
        	int profit = 0;
        	for (int i = 1; i < prices.length; i++) {
        		if (prices[i] - crtMin > profit) {
        			profit = prices[i] - crtMin;
        		} else if (prices[i] < crtMin) {
        			crtMin = prices[i];
        		}
        	}
        	return profit;
        }
    }
}

package leetcode;

/**
 * Can be O(n), total < 0?, sum is used to check the index
 * @author yiluo
 *
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0
        		|| gas.length != cost.length) return -1;
        
        int n = gas.length;
        int total = 0, index = -1, sum = 0;
        for (int i = 0; i < n; i ++) {
        	sum += gas[i] - cost[i];
        	total += gas[i] - cost[i];
        	if (sum < 0) {
        		index = i;
        		sum = 0; // reset
        	}
        }
        
        return total < 0 ? -1 : index + 1;
    }
}

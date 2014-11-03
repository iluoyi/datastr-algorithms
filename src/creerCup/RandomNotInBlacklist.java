package creerCup;

import java.util.Random;

/**
 * From google's interview, O(n)
 * 
 * Java assertions are used to ensure the DbC (design-by-contract)
 * @author yiluo
 *
 */
public class RandomNotInBlacklist {
	// assuming elements in the blacklist is within [0, bound)
	public int getRandom(int bound, int[] blacklist) {
		assert blacklist != null: "blacklist cannot be null";
		assert blacklist.length > 0: "blacklist cannot be empty";
		
		Random rand = new Random();
		int rst = rand.nextInt(bound - blacklist.length);
		
		for (int i = 0; i < blacklist.length; i ++) {
			if (rst >= blacklist[i]) // jump rst to a valid position
				rst ++;
			else
				break;
		}
		
		return rst;
	}
	
	public static void main(String args[]) {
		RandomNotInBlacklist solution = new RandomNotInBlacklist();
		int[] blacklist = {2, 3, 5, 7};
		System.out.println(solution.getRandom(10, blacklist));
	}
}

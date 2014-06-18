package leetcode;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2) return n;
        int[] steps = new int[n + 1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <=n; i ++) {
        	steps[i] = steps[i - 1]+ steps[i - 2];
        }
        return steps[n];
    }
	
	public static void main(String args[]) {
		ClimbingStairs solution = new ClimbingStairs();
		System.out.println(solution.climbStairs(1));
	}
}

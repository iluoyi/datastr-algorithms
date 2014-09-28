package leetcode;

/**
 * Binary search  (divide-and-conquer)
 * 
 * 
 * @author yiluo
 *
 */
public class SqrtX {
	public int sqrt(int x) {
        int lo = 1;
        int hi = x / 2; // must be less than x
        
        if (x < 2) return x;

        int newMid = 0;
        while (lo <= hi) {     
            int mid = lo + (hi - lo) / 2; // avoid the overflow error
            if (x / mid < mid) { // mid * mid may cause overflow!
                hi = mid - 1;
            } else { // use 4 and 6 to configure this condition
            	lo = mid + 1;  
            	newMid = mid;
            }
        }
        return newMid;
    }
	
	public static void main(String args[]) {
		SqrtX solution = new SqrtX();
		System.out.println(solution.sqrt(10));
	}
}

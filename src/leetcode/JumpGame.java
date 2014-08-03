package leetcode;

public class JumpGame {
    public boolean canJump(int[] A) {
    	if (A != null && A.length != 0) {
	        int crt = 0;
	        int range = 0;
	        while (crt <= range && crt < A.length) {
	        	if (crt + A[crt] >= A.length - 1) {
	        		return true;
	        	} else if (crt + A[crt] > range){
	        		range = crt + A[crt];
	        	}
	        	crt ++;
	        }
    	}
        return false;
    }
}

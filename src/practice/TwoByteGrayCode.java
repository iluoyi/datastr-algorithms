package practice;

public class TwoByteGrayCode {
	
	public boolean isGrayCode(byte a, byte b) {
		byte c = (byte) (a ^ b);
		
		// two same inputs may trigger errors!
		// if we use (c & (c-1) == 0) directly.
		int count = 0;
		for (int i = 0; i < 8; i ++) { 
			if (((c >> i) & 1) == 1) {
				count ++;
			}
			if (count > 1) {
				break;
			}
		}
		return count == 1 ? true : false;
	}
	
	public static void main(String args[]) {
		TwoByteGrayCode solution = new TwoByteGrayCode();
		System.out.println(solution.isGrayCode((byte) -1, (byte) 127)); 
	}
}

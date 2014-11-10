package interview;

public class GetStringLen {

	/**
	 * Must implement w/o .length() method
	 */
	public static int getLen(String s) {
		if (s == null || s.isEmpty()) 
			return 0;
		else return 1 + getLen(s.substring(1));
	}
	
	public static void main(String args[]) {
		String s = "hello";
		System.out.println(getLen(s));
	}
}

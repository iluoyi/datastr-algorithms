package practice;

public class ByteToBinaryStr {

	public static void main(String args[]) {
		byte a = 127; // 0111 1111
		byte b = -1; // 1111 1111
		System.out.println(Integer.toBinaryString((byte) (a ^ b)));
		byte c = (byte) (a ^ b);
		System.out.println(Integer.toBinaryString((byte) (c & (c -1)))); // (byte) is necessary to cast the previous 1s.
	}
}

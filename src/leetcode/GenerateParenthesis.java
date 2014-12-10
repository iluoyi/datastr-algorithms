package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
        ArrayList<String> rst = new ArrayList<String>();
        if(n <= 0) {
            return rst;
        }
        getPair(rst, "", n, n);
        return rst;
    }
    
	// left/right means remaining parentheses to add
	public void getPair( ArrayList<String> rst , String s, int left, int right) {
		if(left > right || left < 0 || right < 0) {
			return; 	
		}
		if(left == 0 && right == 0) {
			rst.add(s);
			return;
		}

		getPair(rst, s + "(", left - 1, right);
		getPair(rst, s + ")", left, right - 1);
	}
		
	
	// this method is wrong!!
//	public List<String> generateParenthesis(int n) {
//        ArrayList<String> oldList = new ArrayList<String>();
//        ArrayList<String> newList = new ArrayList<String>();
//        if (n > 0) {
//        	oldList.add("()");
//        	int iter = 1;
//        	int size = 0;
//        	
//        	while (iter < n) {
//        		size = oldList.size();
//        		for (int i = 0 ; i < size; i ++) {
//        			String paren = oldList.get(i);
//        			if (i != size -1) {
//        				newList.add("()" + paren);
//        			}
//        			newList.add("(" + paren + ")");
//        			newList.add(paren + "()");
//        		}
//        		oldList = newList;
//        		newList = new ArrayList<String>(3 * (n - 1) - 1);
//        		iter ++;
//        	}
//        }
//        return oldList;
//    }
	
	public static void main(String args[]) {
		GenerateParenthesis solution = new GenerateParenthesis();
		ArrayList<String> orig = (ArrayList<String>) solution.generateParenthesis(4);
		
		String[] test = new String[]{"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
		ArrayList<String> comp = new ArrayList<String>(Arrays.asList(test));
		
		for (String paren : orig) {
			if (!comp.contains(paren)) {
				System.out.println(paren);
			}
		}
	}
}

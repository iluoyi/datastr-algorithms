package leetcode;

import java.util.Arrays;

/**
 * DFS + backtracking
 * 
 * @author yiluo
 *
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		solveSudokuHelper(board);
	}
	
	private boolean solveSudokuHelper(char[][] board) {
		for (int i = 0; i < 9; i ++) {
			for (int j = 0; j < 9; j ++) {
				if (board[i][j] == '.') {
					for (int k = 0; k < 9; k ++) {
						/**
						 * method 1
						 */
						board[i][j] = (char) ('1' + k); // make an attempt
						if (isValid(board, i, j)) { // check isValid?
							if (solveSudokuHelper(board)) { // can be solved?
								return true;
							}
						}
						board[i][j] = '.'; // backtracking
						
						/**
						 * method 2
						 */
						// A better logic goes as follows:
						// I check it first, only when it is valid, I place it
//						if (isValid(board, i, j, (char) ('1' + k))) { // check isValid?
//							board[i][j] = (char) ('1' + k);
//							if (solveSudokuHelper(board)) { // can be solved?
//								return true;
//							} else {
//								board[i][j] = '.'; // backtracking
//							}
//						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int a, int b) {
        boolean[] visited = new boolean[9];
        
        // row
		Arrays.fill(visited, false);
		for (int j = 0; j < 9; j++) {
			if (!process(visited, board[a][j]))
				return false;
		}
        
        //col
		Arrays.fill(visited, false);
		for (int i = 0; i < 9; i++) {
			if (!process(visited, board[i][b]))
				return false;
		}
        
        // sub matrix
		int i = a / 3 * 3;
		int j = b / 3 * 3;
		Arrays.fill(visited, false);
		for (int k = 0; k < 9; k++) {
			if (!process(visited, board[i + k / 3][j + k % 3]))
				return false;
		}
          
        return true; 
    }
	
	private boolean process(boolean[] visited, char digit){
        if(digit == '.'){
            return true;
        }
        
        int num = digit - '0';
        if ( num < 1 || num > 9 || visited[num-1]){
            return false;
        }
        
        visited[num-1] = true;
        return true;
    }
	
	public static void main(String args[]) {
		SudokuSolver solution = new SudokuSolver();
		char[][] board = {{'.','7','1','.','.','.','5','6','.'}, 
						  {'.','8','9','.','.','7','1','.','3'},
						  {'.','.','.','.','.','1','.','.','.'},
						  {'.','.','.','7','.','.','.','.','.'},
						  {'.','.','.','.','.','6','9','.','.'},
						  {'.','.','7','4','1','.','8','.','.'},
						  {'9','4','.','3','.','.','.','.','1'},
						  {'.','1','6','.','.','8','.','7','.'},
						  {'.','.','3','.','.','.','.','.','.'}};
		solution.solveSudoku(board);
		
		for (int i = 0; i < 9; i ++) {
			for (int j = 0; j < 9; j ++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}

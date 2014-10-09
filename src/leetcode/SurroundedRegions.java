package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	/**
	 * 1. Use BFS to search from the boundary.
	 */
	public void solve(char[][] board) {
		if (board == null) return;
		int n = board.length;
		if (n < 2) return;
		int m = board[0].length;
		if (m < 2) return;
		
		Queue<Integer> queue = new LinkedList<Integer>(); // hold the 1 dimension representation of (x, y)
		
		for (int i = 0; i < n; i ++) {
			enqueue(i, 0, board, queue); // left
			enqueue(i, m - 1, board, queue); // right
		}
		
		for (int j = 0; j < m; j ++) {
			enqueue(0, j, board, queue); // up
			enqueue(n - 1, j, board, queue); // bottom
		}
		
		// BFS
		while (!queue.isEmpty()) {
			int coor = queue.poll();
			int i = coor / m;
			int j = coor % m;
			
			// mark these boundary 'O' as '#'
			board[i][j] = '#';
			
			enqueue(i - 1, j, board, queue); // up
			enqueue(i + 1, j, board, queue); // down
			enqueue(i, j - 1, board, queue); // left
			enqueue(i, j + 1, board, queue); // right
		}
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}	
	
	private void enqueue(int i, int j, char[][] board, Queue<Integer> queue) {
		int n = board.length;
		int m = board[0].length;
		
		if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O') {
			queue.offer(i * m + j);
		}
	}
	
	/**
	 * 2. Use DFS to search from the boundary.
	 */
//	class Solution {
//		public:
//		    void solve(vector<vector<char>> &board) {
//		        int row = board.size();
//		        if(row < 2)
//		            return;
//		        int col = board[0].size();
//		        if(col < 2)
//		            return;
//		        
//		        //从最外面的一圈进行dfs
//		        //top一行
//		        for(int i=0;i<col;i++)
//		        {
//		            if(board[0][i] == 'O')
//		            {
//		                board[0][i] = '#';
//		                dfs(board, 0, i, row, col);
//		            }
//		        }
//		        // bottom一行
//		        for(int i=0;i<col;i++)
//		        {
//		            if(board[row-1][i] == 'O')
//		            {
//		                board[row-1][i] = '#';
//		                dfs(board, row-1, i, row, col);
//		            }
//		        }
//		        //left一列
//		        for(int i=1;i<row-1;i++)
//		        {
//		            if(board[i][0] == 'O')
//		            {
//		                board[i][0] = '#';
//		                dfs(board, i, 0, row, col);
//		            }
//		        }
//		        // right一列
//		        for(int i=1;i<row-1;i++)
//		        {
//		            if(board[i][col-1] == 'O')
//		            {
//		                board[i][col-1] = '#';
//		                dfs(board, i, col-1, row, col);
//		            }
//		        }
//		        
//		        //将'O'变为'X'，将'#'恢复回'O'
//		        for(int i=0;i<row;i++)
//		            for(int j=0;j<col;j++)
//		            {
//		                if(board[i][j] == 'O')
//		                    board[i][j] = 'X';
//		                else if(board[i][j] == '#')
//		                    board[i][j] = 'O';
//		            }
//		    }
//		    
//		    void dfs(vector<vector<char>> &board, int i, int j, int row, int col)
//		    {
//		        if(i > 1 && board[i-1][j] == 'O')
//		        {
//		            board[i-1][j] = '#';
//		            dfs(board, i-1, j, row, col);
//		        }
//		        if(i < row-1 && board[i+1][j] == 'O')
//		        {
//		            board[i+1][j] = '#';
//		            dfs(board, i+1, j, row, col);
//		        }
//		        if(j > 1 && board[i][j-1] == 'O')
//		        {
//		            board[i][j-1] = '#';
//		            dfs(board, i, j-1, row, col);
//		        }
//		        if(j < col-1 && board[i][j+1] == 'O')
//		        {
//		            board[i][j+1] = '#';
//		            dfs(board, i, j+1, row, col);
//		        }
//		    }
//		};

}

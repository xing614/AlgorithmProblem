package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * @author liang
 *
 */
public class SurroundedRegions_130 {

	class Node{
		int row;//行
		int col;//列
		public Node(int row,int col) {
			this.row = row;
			this.col = col;
		}
	}
	/**
	 * 因为最外层的不会被包围，那如果最外层某个位置为O，那么紧挨着它的所有位置的O都不会被包围，
	 * 因此，实际上是使用BFS的方法，利用一个队列的数据结构。
	 * 维护一个矩阵visited用来存储该位置是否要变为x
	 * @param board
	 */
    public void solve(char[][] board) {
    	if (board == null || board.length == 0)
			return;
		int rowLen = board.length;
		int colLen = board[0].length;
		int[][] visited = new int[rowLen][colLen];//保存这个位置能否呗设置为X，1表示不能
		Queue<Node> queue = new LinkedList<>();
		//设置默认值为0
		for (int row = 0; row < rowLen; row++)
			for (int col = 0; col < colLen; col++)
				visited[row][col] = 0;
		//设置第一列和最后一列，如果当前位置是O，则将该位置存储到队列
		for (int row = 0; row < rowLen; row++) {
			if (board[row][0] == 'O')
				queue.offer(new Node(row, 0));
			if (board[row][colLen - 1] == 'O')
				queue.offer(new Node(row, colLen - 1));
		}
		//设置第一行和最后一行，如果当前位置是O，则将该位置存储到队列
		for (int col = 0; col < colLen; col++) {
			if (board[0][col] == 'O')
				queue.offer(new Node(0, col));
			if (board[rowLen - 1][col] == 'O')
				queue.offer(new Node(rowLen - 1, col));
		}
		//如果最外围一圈存在O
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();//弹出第一个
			int row = tmp.row;
			int col = tmp.col;
			// 关键点，如果不是加入队列的时候访问设置1，那么需要加此判断
			if (visited[row][col] == 1)
				continue;
			visited[row][col] = 1;//设置此位置为1，就说明这个地不要被设置为X
			
			//设置这个位置的前后左右，如果是0，就加入队列
			if (row + 1 < rowLen && board[row + 1][col] == 'O' 
					&& visited[row + 1][col] == 0)
				queue.offer(new Node(row + 1, col));
			if (row - 1 >= 0 && board[row - 1][col] == 'O' 
					&& visited[row - 1][col] == 0)
				queue.offer(new Node(row - 1, col));
			if (col + 1 < colLen && board[row][col + 1] == 'O' 
					&& visited[row][col + 1] == 0)
				queue.offer(new Node(row, col + 1));
			if (col - 1 >= 0 && board[row][col - 1] == 'O' 
					&& visited[row][col - 1] == 0)
				queue.offer(new Node(row, col - 1));
			
		}
		for (int row = 0; row < rowLen; row++) {
			for (int col = 0; col < colLen; col++) {
				if (board[row][col] == 'O' && visited[row][col] == 0)
					board[row][col] = 'X';
			}
		}
    }
    
    /**
     * 方法二：使用类似第200题的方法
     * @param board
     */
    public void solve2(char[][] grid) {
		if (grid == null)
			return;
		int rows = grid.length;
		if (rows <= 0)
			return;
		int cols = grid[0].length;
		if (cols <= 0)
			return;
		for (int i = 0; i < rows; i++) {
			if (grid[i][0] == 'O')
				dfsSearch(grid, i, 0);
			if (grid[i][cols - 1] == 'O')
				dfsSearch(grid, i, cols - 1);
		}
		for (int i = 0; i < cols; i++) {
			if (grid[0][i] == 'O')
				dfsSearch(grid, 0, i);
			if (grid[rows - 1][i] == 'O')
				dfsSearch(grid, rows - 1, i);
		}
 
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (grid[i][j] == '*')
					grid[i][j] = 'O';
				else if (grid[i][j] == 'O')
					grid[i][j] = 'X';
		for (int i = 0; i < rows; i++)
			System.out.println(Arrays.toString(grid[i]));
    }
	// 每遇到'O'后, 开始向四个方向 递归搜索. 搜到后变为'*',
	// 因为相邻的属于一个island. 然后开始继续找下一个'O'.
	private void dfsSearch(char[][] grid, int i, int j) {
		if (grid[i][j] == 'O') {
			// 修改为一个不相干的字符，但不能是X
			grid[i][j] = '*';// 和visited数组一样功能
			// 不需要处理四周边缘了，调用循环已经处理过，不然超时
			if (i < grid.length - 2)
				dfsSearch(grid, i + 1, j);
			if (i > 1)
				dfsSearch(grid, i - 1, j);
			if (j < grid[0].length - 2)
				dfsSearch(grid, i, j + 1);
			if (j > 1)
				dfsSearch(grid, i, j - 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

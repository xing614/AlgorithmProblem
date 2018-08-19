package hard;
/**
 * 52. N皇后 II
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
 * @author liang
 *
 */
public class NQueens2_52 {

	int count = 0;
	
    public int totalNQueens(int n) {
		// 第i个位置存放的数表示row行时，Q的列
		int[] queenList = new int[n];
		// 从第0行开始放
		placeQueen(queenList, 0, n);
		return count;
    }
    
	private void placeQueen(int[] queenList, int row, int n) {
		// TODO Auto-generated method stub
		// 如果已经填满，就生成结果
		if (row == n) {
			count++;
			return;
		}
		// 按照行进行放置
		for (int col = 0; col < n; col++) {// 循环每一列
			if (isValid(queenList, row, col)) { // 如果在该列放入Q不冲突的话
				// 没有回溯，因为没有修改原结果集
				// 只是临时记录结果
				queenList[row] = col;
				placeQueen(queenList, row + 1, n);
			}
		}	
	}

	private boolean isValid(int[] queenList, int row, int col) {
		for (int i = 0; i < row; i++) {
			// pos为列
			int pos = queenList[i];
			if (pos == col) { // 和新加入的Q处于同一列
				return false;
			}
			if (pos + row - i == col) { // 在新加入的Q的右对角线上
				return false;
			}
			if (pos - row + i == col) { // 在新加入的Q的左对角线上
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

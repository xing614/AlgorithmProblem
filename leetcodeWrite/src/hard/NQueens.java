package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
 * @author liang
 *
 */
public class NQueens {
	/**
	 * 两个皇后不能相互攻击，即要求这两个皇后不在同一行、同一列及同一斜线上。
	 * 递归 回溯
	 * @param n
	 * @return
	 */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>  res = new ArrayList<List<String>>();
        int[] queenList = new int[n];//第i个数代表这一组   第i行放皇后的位置是queenList[i](第几列)
        solve(queenList,0,n,res);
        return res;
    }
    
	private void solve(int[] queenList, int row, int n, List<List<String>> res) {
		// TODO Auto-generated method stub
		if(row == n) {//如果已经填满，就生成结果
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0;i<n;i++) {
				String str = "";
				for(int col=0;col<n;col++) {
					if(queenList[i] == col) {//搜索到第col列匹配，就这个字符为Q
						str+="Q";
					}else {
						str+=".";
					}
				}
				list.add(str);
			}
			res.add(list);
		}
		for(int col=0;col<n;col++) {
			if(isValid(queenList,row,col)) {//如果在该列放入Q不冲突
				queenList[row] = col;//row是当前处于第几行，col是放这一行的第几列
				solve(queenList,row+1,n,res);
			}
		}
	}



	private boolean isValid(int[] queenList, int row, int col) {
		// TODO Auto-generated method stub
		for(int i=0;i<row;i++) {
			int pos = queenList[i];//当前i行计划皇后放在pos位置
			if(pos == col) {//已计划的皇后位置有与当前行计划放的位置在同一列
				return  false;
			}
			if(pos+row-i == col) {//在新加入的Q的右对角线上, pos+row = i+col表示在右对角线
				return false;
			}
            if (pos - row + i == col) { //在新加入的Q的左对角线上
                return false;
            }
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

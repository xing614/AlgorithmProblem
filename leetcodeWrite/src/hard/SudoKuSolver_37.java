package hard;
/**
 * 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。



一个数独。



答案被标成红色。

Note:

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。
 * @author liang
 *
 */
public class SudoKuSolver_37 {

	
	boolean isOver = false;
	/**
	 * 回溯法
	 * 
	 * @param board
	 */
    public void solveSudoku(char[][] board) {
    	
        dfs(board,0,0,board.length);
    }
    
	private void dfs(char[][] board, int i, int j, int n) {
		// TODO Auto-generated method stub
		if(j>=n) {//j过线了 i+1
			dfs(board,i+1,0,n);
		}else if(i>=n) {//i>=n就说明九宫格遍历到最后了
			this.isOver = true;
			return ;
		}else if(board[i][j] != '.') {//当前位置有数，进入下一个
			dfs(board,i,j+1,n);
		}else {
			for(int k=1;k<=n;k++) {
				board[i][j] = (char)('0'+k);
				if(isValidSudoku(board, i, j, n)) {//符合条件
					dfs(board,i,j+1,n);
				}
				if(this.isOver) {
					return ;
				}
				board[i][j] = '.';
			}
		}
		return;
	}

	/**
	 * 判断当前ij位置点是否符合九宫格
	 * @param board
	 * @return
	 */
    public static boolean isValidSudoku(char[][] board,int i,int j,int n) {
    	//判断行
        for (int index = 0; index < n; ++index){
            if (index != j && board[i][index] == board[i][j]) {
                return false;
            }
        }
        //判断列
        for (int index = 0; index < n; ++index){
            if (index != i && board[index][j] == board[i][j]) {
                return false;
            }
        }
        //判断小九宫格
        int index_i = i / 3;
        int index_j = j / 3;
        
        for (int x = index_i * 3; x < index_i * 3 + 3; ++x) {
            for (int y = index_j * 3; y < index_j * 3 + 3; ++y) {
                if ((x!=i || y != j) && board[x][y] == board[i][j]) { //注意这里逻辑是"或"||，不是"与"
                    return false;
                }
            }
        }
        return true;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

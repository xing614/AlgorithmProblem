package medium;
/**
 * 529. 扫雷游戏
 * 让我们一起来玩扫雷游戏！

给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。

现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：

如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
如果在此次点击中，若无更多方块可被揭露，则返回面板。
 

示例 1：

输入: 

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

输出: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 * @author liang
 *
 */
public class Minesweeper_529 {
	int[][] dirs = {{1,0},{1,1},{1,-1},{-1,0},{-1,1},{-1,-1},{0,1},{0,1}};//临近的八个点
	/**
	 * 先判断是否是M，在dfs
	 * @param board
	 * @param click
	 * @return
	 */
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || board.length == 0)
        	return board;
        if(board[click[0]][click[1]] == 'M') {//当前位置是地雷
        	board[click[0]][click[1]] = 'X';
        	return board;
        }
        dfs(board,click[0],click[1]);
        return board;
    }
	private void dfs(char[][] board, int i, int j) {
		// TODO Auto-generated method stub
		if(board[i][j] != 'E') {//不是空方块
			return;
		}
		int cnt = 0;//周围地雷数
		for(int[] dir:dirs) {
			int row = dir[0]+i;
			int col = dir[1]+j;
			//这个位置是地雷，cnt++
			if(row>=0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'M') {
				cnt++;
			}
		}
		board[i][j] = '*';
		if(cnt == 0) {
			board[i][j] = 'B';

            for (int[] dir : dirs) {
                int row = dir[0] + i;
                int col = dir[1] + j;
                if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
                    dfs(board, row, col);
                }
            }
		}else {
			board[i][j] = (char)(cnt+'0');
		}
	}
}

package medium;
/**
 * 289. 生命游戏
根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

示例:

输入: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
输出: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
进阶:

你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * @author liang
 *
 */
public class GameOfLife_289 {

    public void gameOfLife(int[][] board) {
        /**
         * 设定状态
         * 0：0-》0
         * 1：1-》1 活着不变
         * 2：1-》0 超过3个死亡
         * 3：0-》1 3个复活
         */
    	int rowlen = board.length;
    	int collen = board[0].length;
    	for(int row = 0;row<rowlen;row++) {
    		for(int col = 0;col<collen;col++) {
    			int count = countLiveNeigh(board,row,col);
    			if(count == 2);
    			else if(count == 3) {
    				board[row][col] = board[row][col] == 0?3:1;//本身死的，然后复活；要不然活着不变
    			}else {
    				board[row][col] = board[row][col] == 1?2:0;//少于2或者多余3；本身活着就让他死，本身死了就让他接着死吧
    			}
    		}
    	}
    	for(int row=0;row<rowlen;row++) {
    		for(int col=0;col<collen;col++) {
    			board[row][col] %= 2; 
    		}
    	}
    }
    /**
     * 数当前位置周围八个位置有几个是活的
     * @param board
     * @param row
     * @param col
     * @return
     */
	private int countLiveNeigh(int[][] board, int row, int col) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i=row-1;i<=row+1;i++) {
			for(int j = col-1;j<=col+1;j++) {
				if(i==row && j==col) {//本身自己的位置
					continue;
				}
				//为1 表示本身活着；为2表示它下一轮死但这一轮还活着
				if(i>=0 && i<board.length && j>=0 &&j<board[0].length && (board[i][j]==1 ||board[i][j]==2)) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

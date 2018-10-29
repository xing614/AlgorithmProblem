package medium;
/**
 * 419. 甲板上的战舰
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：

给你一个有效的甲板，仅由战舰或者空位组成。
战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
示例 :

X..X
...X
...X
在上面的甲板中有2艘战舰。

无效样例 :

...X
XXXX
...X
你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。

进阶:

你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？
 * @author liang
 *
 */
public class BattleshipsInABoard_419 {

	/**
	 * 遍历二维数组，判断当前位置是否是X，如果是，就判断它的上位置、左位置是否是X，是就说明该位置并在前位置，不是X就count++，遍历下一个位置
	 * @param board
	 * @return
	 */
    public int countBattleships(char[][] board) {
    	int count = 0; 
    	for(int i = 0; i < board.length; i ++) {
			for(int j = 0; j < board[0].length; j ++){ 
				if(board[i][j] == 'X'){ 
					if(i > 0 && board[i-1][j] == 'X') //它的上位置是X，则这个位置算在之前count++里面，所以直接检索下一个位置
						continue; 
					else if(j > 0 && board[i][j-1] == 'X') //它的左位置是X
						continue; 
					count ++; 
				} 
			}     		
    	}
    	return count;
    }
    
}

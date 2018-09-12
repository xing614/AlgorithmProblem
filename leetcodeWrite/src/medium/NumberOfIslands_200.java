package medium;
/**
 * 200. 岛屿的个数
题目描述提示帮助提交记录社区讨论阅读解答
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3
 * @author liang
 *
 */
public class NumberOfIslands_200 {

	/**
	 * 深度优先遍历，把访问过的改为‘0’，继续遍历
	 * @param grid
	 * @return
	 */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0|| grid[0].length == 0) {
        	return 0;
        }
        int rows = grid.length;
        int cols  = grid[0].length;
        int count = 0;//返回值，
        //遍历所有节点
        for(int i=0;i<rows;i++) {
        	for(int j=0;j<cols;j++) {
        		if(grid[i][j]=='1') {
        			count++;//存在岛屿，+1
        			dfs(grid,i,j,rows,cols);
        		}
        	}
        }
        return count;
    }
    
    // 每遇到'1'后, 开始向四个方向 递归搜索. 搜到后变为'0',
    // 因为相邻的属于一个island. 然后开始继续找下一个'1'.
	private void dfs(char[][] grid, int i, int j, int rows, int cols) {
		// TODO Auto-generated method stub
		if(i<0||i>=rows||j<0||j>=cols)
			return;
		if(grid[i][j] != '1')//不是相邻岛屿
			return;
		grid[i][j] = 0;//设置这为海水，之后遍历到这会跳过
		//dfs这个位置的前后左右是否有临近岛屿
		dfs(grid,i+1,j,rows,cols);
		dfs(grid,i-1,j,rows,cols);
		dfs(grid,i,j+1,rows,cols);
		dfs(grid,i,j-1,rows,cols);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

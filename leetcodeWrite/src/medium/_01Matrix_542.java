package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1: 
输入:

0 0 0
0 1 0
0 0 0
输出:

0 0 0
0 1 0
0 0 0
示例 2: 
输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1
注意:

给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * @author liang
 *
 */
public class _01Matrix_542 {

	/**
	 * 先将所有为1的点设置为max，然后将当前位置放入队列，广度优先搜索这个位置的上下左右四个点，如果临近点的值小于当前位置值+1 说明该位置的值被更新过了不需改变
	 * @param matrix
	 * @return
	 */
    public int[][] updateMatrix(int[][] matrix) {
    	if(matrix == null)
    		return null;
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<row;i++) {
        	for(int j=0;j<col;j++) {
        		// 把0元素加入队列中，以备波及影响周围元素
        		if(matrix[i][j] == 0)
        			que.offer(new int[] {i,j});
        		else
        			matrix[i][j] = Integer.MAX_VALUE;//将本来时1的位置设置为max，之后广度搜索时改变这个位置的数
        	}
        }
        //上下左右
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        //广度搜素给上下左右的位置点设置与0的距离
        while(!que.isEmpty()) {
        	int[] cell = que.poll();
        	for(int[] d:dirs) {
        		int m = cell[0]+d[0];
        		int n = cell[1]+d[1];
        		if(m<0 ||m>=row ||n<0||n>=col) {
        			continue;
        		}
        		int value = matrix[m][n];//这个位置要么本身时0，要么时max，要么时更新过的与某个0点的距离
        		int tmp = matrix[cell[0]][cell[1]]+1;
        		// 如果value小，那说明之前已经更新过，不是max
				if (value <= tmp)
					continue;
				que.offer(new int[] {m,n});
				matrix[m][n] = tmp;
        	}
        }
        return matrix;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

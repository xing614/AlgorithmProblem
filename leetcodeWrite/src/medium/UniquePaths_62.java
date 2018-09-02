package medium;
/**
 * 62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 * @author liang
 *
 */
public class UniquePaths_62 {

	/**
	 * 动态规划
	 * ij位置的路径数为ways[i][j],等于到达它上点的路径数与它左点的路径数之和
	 * 递推关系式：ways[i][j] = ways[i][j-1] + ways[i-1][j]
	 * @param m
	 * @param n
	 * @return
	 */
    public static int uniquePaths(int m, int n) {
        int[][] ways = new int[m][n];
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(i==0 || j ==0) ways[i][j] = 1;//第一列和第一行结果都是1
        		else ways[i][j] = ways[i-1][j]+ways[i][j-1];
        	}
        }
        return ways[m-1][n-1];
    }
    

    /**
     * 递归
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return uniquePaths2(m, n - 1) + uniquePaths2(m - 1, n);
    }
    

    /**
     * 这种优化是对方法一的一种优化，使得空间复杂度从原来的 O(n*m)下降为 O(n)。
     * 对于起点到点(i,j)的路径总数：ways[j]= 起点到点(i-1, j) 的路径总数：ways[j] + 起点到点(i, j-1)的路径总数 ways[j-1]，
     * 得到递推式：ways[j] = ways[j] + ways[j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        int[] ways = new int[n];
        ways[0] = 1;
        for(int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                ways[j] += ways[j-1];
        return ways[n-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3,7));
	}

}

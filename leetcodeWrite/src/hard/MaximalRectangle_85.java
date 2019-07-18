package hard;

import java.util.Stack;

/**
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6
 * @author liang
 *
 */
public class MaximalRectangle_85 {
	/**
	 * 使用84题思想  https://blog.csdn.net/qq_41855420/article/details/87459549
	 * 先求出每个位置，将从该位置开始向右一直能有多少个1设置该位置的高。dpRow[row][col]表示matrix[row][col]为起始向右可扩展的最大长
	 * 然后纵向找这个位置的柱状图最大矩形 ，就是第84题解题过程
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
		int maxResult = 0;//结果
		int rowSize = matrix.length;//矩阵的行数
		if (rowSize == 0){
			return 0;
		}
		int colSize = matrix[0].length;//矩阵的列数
		//rowDp[row][col]表示在matrix[row][col]为起始向右可扩展的1的个数，说白了就是矩阵的最大长
		int[][] rowDp = new int[rowSize][colSize];
        //动态规划求向右扩展长
		for (int row = 0; row < rowSize; ++row){
			for (int col = colSize - 1; col >= 0; --col){
				if (matrix[row][col] == '1'){
					rowDp[row][col] = 1;//首先本身就是1，所以向右扩展的长至少为1
					if (col + 1 < colSize){//如果右边的坐标合法，则matrix[row][col]向右可扩展的长得加上前一个
						rowDp[row][col] += rowDp[row][col + 1];
					}
				}
			}
		}
        //最外层的col是降维系数，请参考图解示例，将col列到colSize - 1列，融合成一列
		for (int col = colSize - 1; col >= 0; --col){
            //下面的算法就是上一题的核心算法,这里也可上一题的递增栈算法降低时间复杂度，请自行修改
			for (int beginRow = 0; beginRow < rowSize; ++beginRow){
				int tempHeight = rowDp[beginRow][col];//matrix[beginRow][col]可向右扩展的长
                //rowDp[endRow][col] != 0的作用类似剪枝，如果是零不用计算，因为以0为最短的高，的出的结果为0
				for (int endRow = beginRow; endRow < rowSize && rowDp[endRow][col] != 0; ){
					tempHeight = Math.min(tempHeight, rowDp[endRow][col]);//更新长为当前最短
					while (endRow < rowSize && rowDp[endRow][col] >= tempHeight){//endRow跳过比最短高大的
						++endRow;
					}
					//endRow - beginRow宽
					//tempHeight长（高）
					maxResult = Math.max(maxResult, (endRow - beginRow) * tempHeight);
				}
			}
		}
		return maxResult;
	}
	/**
	 * 方法二，使用一维数组 + 栈
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0)
        return 0;
    int[] height = new int[matrix[0].length+1];
    int res = 0;
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++)
            height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
        res = Math.max(res, largestRectangle(height));
    }
    return res; 
		
	}
	private int largestRectangle(int[] height) {
		// TODO Auto-generated method stub
	    int i = 0, res = 0;
	    height[height.length-1] = 0;
	    Stack<Integer> s = new Stack<>();
	    while (i < height.length) {
	        if (s.isEmpty() || height[i] >= height[s.peek()])
	            s.push(i++);
	        else
	            res = Math.max(res, height[s.pop()] * (s.isEmpty() ? i : i - s.peek() - 1));
	    }
	    return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

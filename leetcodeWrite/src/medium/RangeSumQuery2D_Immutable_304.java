package medium;
/**
 * 304. 二维区域和检索 - 矩阵不可变
题目描述提示帮助提交记录社区讨论阅读解答
给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。

Range Sum Query 2D
上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。

示例:

给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
说明:

你可以假设矩阵不可变。
会多次调用 sumRegion 方法。
你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 * @author liang
 *
 */
public class RangeSumQuery2D_Immutable_304 {
	
	int[][] sumMatrix;

	
	/**
	 * 当计算（row1，col1)到（row2,col2)时，就是计算newMatrix[row2][col2] - newMatrix[row2-1][col1] - newMatrix[row1][col2-1] + newMatrix[row1-1][col1-1]. 
	 * 为了代码方便，不放添加一个空的行和一列，这样就不用判断是否越界了。
	 * @param matrix
	 */
    public RangeSumQuery2D_Immutable_304(int[][] matrix) {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	if(row == 0 ||col == 0) {
    		return;
    	}
    	sumMatrix = new int[row+1][col+1];

        for(int i = 0;i<row+1;i++)
            sumMatrix[i][0] = 0;
        for(int i = 0;i<col+1;i++)
            sumMatrix[0][i] = 0;
        for(int i = 1;i<row+1;i++){
            for(int j = 1;j<col+1;j++){
                sumMatrix[i][j] = sumMatrix[i-1][j]+sumMatrix[i][j-1]-sumMatrix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
       return sumMatrix[row2+1][col2+1]-sumMatrix[row2+1][col1]-sumMatrix[row1][col2+1]+sumMatrix[row1][col1];
    }
}

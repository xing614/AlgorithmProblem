package medium;
/**
 * 74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false
 * @author liang
 *
 */
public class SearchA2DMatrix_74 {

	/**
	 * 二分搜索法
	 * @param matrix
	 * @param target
	 * @return
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0||matrix[0].length==0)
    		return false;
    	int rows = matrix.length; 
    	int cols = matrix[0].length; 
    	int i = 0 , j = rows * cols -1;
    	while(i<j){ //二分搜索
    		int mid = (i+j)>>1; //右移1位找到中间位置
	    	if(matrix[mid/cols][mid%cols]<target){//中间数据小于目标值
	    		i = mid+1; 
	    	}else{ 
	    		j = mid; 
	    	} 
    	} 
    	return matrix[i/cols][i%cols]==target; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

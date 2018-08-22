package medium;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 * @author liang
 *
 */
public class RotateImage_48 {

	/**
	 * 旋转最直观的方法
	 * 对于当前位置，计算旋转后的新位置，然后再计算下一个新位置，第四个位置又变成当前位置了，所以这个方法每次循环换四个数字
	 * 1  2  3                 7  2  1        7  4  1
	   4  5  6      -->        4  5  6　　 -->  　 8  5  2　　
	   7  8  9                 9  8  3　　　　　     9  6  3	
	 * @param matrix
	 */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i=0;i<len/2;i++) {
        	for(int j=i;j<len-1-i;j++) {
        		int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = tmp;
        	}
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

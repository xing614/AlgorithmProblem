package medium;
/**
 * 73. 矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？
 * @author liang
 *
 */
public class SetMatrixZeroes_73 {

	/**
	 * 1、暴力的做法就是再设定一个一样的矩阵，每次遇到0，然后将第二个矩阵的相应位置置0，空间复杂度为O(mn)。
	 * 2、然后略微优化就是每次遇到0的时候，记录需要置0的行号和列号，空间复杂度为O(m+n)。
	 * 3、如果要求空间复杂度为1，其实只需要将2中记录的方法，记录在第一行和第一列就行了。
	 * 利用第一行和第一列的元素去标记该行或该列是否在更新时要全部变成0。
	 * 但是这样操作会使得第一行和第一列的原始状态丢失。
	 * 因此，需要额外变量col0  去保存第一列（row0第一行）在更新时是否要变成0，这样就不会有问题了。
	 * @param matrix
	 */
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        boolean row0 = false;//用于判断第一行是否需要变为0
        boolean col0 = false;//用于判断第一列是否需要变为0
        //判断第一列是否有0
        for(int i=0;i<len1;i++) {
        	if(matrix[i][0]==0) {
        		col0 = true;
        		break;
        	}
        }
        //判断第一行是否有0
        for(int i=0;i<len2;i++) {
        	if(matrix[0][i]==0) {
        		row0 = true;
        		break;
        	}
        }
        //
        for(int i=0;i<len1;i++) {
        	for(int j=0;j<len2;j++) {
        		if(matrix[i][j]==0) {
        			matrix[i][0] = 0;//在后面会根据第一列i位置是否是0将这行设为0
        			matrix[0][j] = 0;//在后面会根据第一行j位置是否是0将这列设为0
        		}
        	}       		
        }
        //设这一行为0
        for(int i=1;i<len1;i++) {
        	if(matrix[i][0]==0) {
            	for(int j=1;j<len2;j++) {
            		matrix[i][j] = 0;
            	}       		
        	}
        }
        for(int i=1;i<len2;i++) {
        	if(matrix[0][i]==0) {
            	for(int j=1;j<len1;j++) {
            		matrix[j][i] = 0;
            	}       		
        	}
        }
        if( row0 )//第一行为0
            for( int i = 0;i<len2;i++)
                matrix[0][i] = 0;
        if( col0 )
            for( int i = 0;i<len1;i++)
                matrix[i][0] = 0;
        return;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

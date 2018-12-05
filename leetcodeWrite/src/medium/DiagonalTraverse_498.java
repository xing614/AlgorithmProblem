package medium;

/**
 * 498. 对角线遍历
 * 蛇形遍历
 * @author liang
 *
 */
public class DiagonalTraverse_498 {

	/**
	 * 蛇形遍历矩阵；斜向上时i-- j++;斜向下时i++ j--;
	 * 使用di dj判断溢出条件
	 * @param matrix
	 * @return
	 */
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix == null) {
        	return new int[]{};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] result = new int[m*n];
        int i = 0;
        int j = 0;
        int k = 1;//判断方向该向上还是向下
        for(int index = 0;index < m*n;index++) {
        	int di,dj;
        	result[index] = matrix[i][j];
        	if(k>0) {//向上
        		di = i-1;
        		dj = j+1;
        	}else {
        		di = i+1;
        		dj = j-1;
        	}
        	if(di>=0 && di<n && dj>=0 && dj<m) {//不溢出
        		i = di;
        		j = dj;
        	}else {//溢出
        		if(k>0) {//向上到头了该右移或者下移
        			if(j+1<m) {//还能右移
        				j++;
        			}else {//到最右侧了，下移
        				i++;
        			}
        		}else {//这时方向是向下的
        			if(i+1<n)//左溢出
                        i++;
                    else//下溢出
                        j++;
        		}
        		k=k*-1;
        	}
        }
        return result;
    }
    
}

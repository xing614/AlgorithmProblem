package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @author liang
 *
 */
public class SpiralMatrix_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> li = new ArrayList<Integer>();
    	if(matrix == null || matrix.length == 0) return li;
    	int i=0,j=0;
    	int len1 = matrix[0].length;//4
    	int len2 = matrix.length;//3
    	boolean[][] fas = new boolean[len2][len1];
    	int count = 0;
    	while(count<len1*len2) {
    		
    		while(j<len1) {
    			if(!fas[i][j]) {
    				count++;
    				fas[i][j] = true;
    				li.add(matrix[i][j]);
    				j++;
    			}else {
    				break;
    			}
    		}
    		j--;
    		i++;
    		while(i<len2) {
    			if(!fas[i][j]) {
    				count++;
    				fas[i][j] = true;
    				li.add(matrix[i][j]);
    				i++;
    			}else {
    				break;
    			}
    		}
    		i--;
    		j--;
    		while(j>=0) {
    			
    			if(!fas[i][j]) {
    				count++;
    				fas[i][j] = true;
    				li.add(matrix[i][j]);
    				j--;
    			}else {
    				break;
    			}   			
    		}
    		j++;
    		i--;
    		while(i>=0) {
    			if(!fas[i][j]) {
    				count++;
    				fas[i][j] = true;
    				li.add(matrix[i][j]);
    				i--;
    			}else {
    				break;
    			}
    		}
    		i++;
    		j++;
    	}
    	
    	
		return li;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ss = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		//spiralOrder(ss);
		int[][] sss = null;
		spiralOrder(sss);
	}

}

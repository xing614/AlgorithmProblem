package medium;

import java.util.List;

/**
 * 120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * @author liang
 *
 */
public class Triangle_120 {

	/**
	 * 动态规划
	 * 给出一个三角形状的整数list，从第一行向下移动，每次只能向下一行相邻的数移动，要求求出从第一行到最后一行所经过的数字的和最小的方法。
	 * 用一个二维数组存储从第一行到某行某个数的经过数的最小值，这是空间为o(n*n),
	 * 对其中第i行（i>1）的第j个数（0<j<row-1）有res[i][j]=Math.min(res[i-1][j-1],res[i-1][j])+list.get(j)，
	 * 即从上一行能到达该点的两个点中选择小的那个点，然后到达该点加上当前点的值即可。
	 * 对于每行的第一个点和最后一个点，只有一种方法能到达该点，所以直接加上当前点的值即可。最后遍历每个数即可得到最终结果。
	 * @param triangle
	 * @return
	 */
    public int minimumTotal(List<List<Integer>> triangle) {
    	int row = triangle.size();//行数
    	if(row == 0)
    		return 0;
    	int[][] res = new int[row][row];//记录从第一行到每个点的最小值，第i行第n个数
    	int minSum=Integer.MAX_VALUE;       //记录最小的sum
    	List<Integer> list0=triangle.get(0);  //第1行只有一个数，
        if(list0.size()==0)
            return 0;
        if(row==1)
        	return list0.get(0);
        res[0][0]=list0.get(0);
        for(int i=1;i<row;i++) {
        	List<Integer> list = triangle.get(i);//第i行的数
        	for(int j=0;j<list.size();j++) {
        		if(j==0) {//每行第一个数，由上一行第一个数res[i-1][0]决定
        			res[i][j]=res[i-1][j]+list.get(j);
        		}
        		else if(j==list.size()-1) {//每行最后一个数，由上一行最后一个数确定
        			 res[i][j]=res[i-1][j-1]+list.get(j);
        		}
        		else {
        			 res[i][j]=Math.min(res[i-1][j-1],res[i-1][j])+list.get(j);
        		}
        		if(i==row-1){//最后一行，确定最小数
                    if(minSum>res[i][j])
                        minSum=res[i][j];
                }
        	}
        	
        }
        return minSum;
        
    }
    /**
     * 0(n)空间
     * 将三角形看成倒三角形即可，从后面的行求到前面的行，这样就可以用一个一维数组保存到当前行的某个数的最小和。
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int row=triangle.size();    //行数
        if(row==0) return 0;
         
        int[] res=new int[row+1];       //倒着求，求最后一行到第一行最小和，这样就可以用o(n)空间了
         
        for(int i=row-1;i>=0;i--){
            List<Integer> list=triangle.get(i);
            for(int j=0;j<list.size();j++){
                res[j]=(Math.min(res[j+1],res[j])+list.get(j));//最后一行的最小值就是当前数
            }
        }
         
        return res[0];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

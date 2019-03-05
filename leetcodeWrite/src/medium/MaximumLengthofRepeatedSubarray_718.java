package medium;
/**
 * 718. 最长重复子数组
 * 
 * @author liang
 *
 */
public class MaximumLengthofRepeatedSubarray_718{

	/**
	 * 动态规划
	 * c[i][j]表示以A[i] 和 B[j] 结尾的最长子串的长度
	 * 状态转移方程：c[i][j] =  A[i] == B[j]?  c[i-1][j-1]+1:0
	 * @param A
	 * @param B
	 * @return
	 */
    public int findLength(int[] A, int[] B) {
    	int lenA = A.length;
    	int lenB = B.length;
    	int result = 0;
        int[][] C = new int[lenA+1][lenB+1];
        for(int i=1;i<lenA+1;i++) {
        	for(int j=1;j<lenB+1;j++) {
        		C[i][j] = A[i-1] == B[j-1]?C[i-1][j-1]+1:0;
        		result = Math.max(result, C[i][j]);
        		System.out.println(i+" "+j+" "+C[i][j]);
        	}
        }
        return result;
    }
    /**
     * 方法2.还是动态规划，不过C只要c[2][lenB+1],c[0][]保存当前遍历时的上一次遍历后的最长子数组长度，c[1][]在本轮中根据AB位置数据相同使得=c[0][j-1]+1,然后B遍历一正轮后 交换0和1的值
     * @param A
     * @param B
     * @return
     */
//    public int findLength2(int[] A, int[] B) {
//    	
//    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumLengthofRepeatedSubarray_718 mm = new MaximumLengthofRepeatedSubarray_718();
		int[] A = {1,2,3,2,1};
		int[] B = {3,2,1,4,7};
		mm.findLength(A, B);
	}

}

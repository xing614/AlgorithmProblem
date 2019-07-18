package medium;
/**
 * 907. 子数组的最小值之和
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。

由于答案可能很大，因此返回答案模 10^9 + 7。

 

示例：

输入：[3,1,2,4]
输出：17
解释：
子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 

提示：

1 <= A <= 30000
1 <= A[i] <= 30000
 * @author liang
 *
 */
public class SumofSubarrayMinimums_907 {

	/**
	 * 以第i位置数为最小值，向左向右拉伸看能拉出最大范围，
	 * @param A
	 * @return
	 */
    public int sumSubarrayMins(int[] A) {
    	long mod = 1000000007;
        long res = 0;
        for(int i=0;i<A.length;i++) {
        	int l = i-1;//向左拉伸直到a[l]<=a[i]；
        	for(;l>=0 &&A[i]<A[l];l--);
        	int r = i+1;//向右拉伸
        	for(;r<A.length && A[i]<=A[r];r++);
        	res+=(i-l)*(r-i)*A[i];//以i为最小可组成的子数组数
        }
        return (int)(res % mod);

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

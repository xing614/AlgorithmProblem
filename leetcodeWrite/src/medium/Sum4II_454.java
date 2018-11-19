package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * @author liang
 *
 */
public class Sum4II_454 {
	/**
	 * 先计算A和B所有可能 保存在map，出现重复就过就value+1
	 * 然后遍历C和D，找到map中Key-C-D后为0的个数
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();//key是a+b的值，value是这个值出现几次
        int res = 0;//返回值
        for(int i=0;i<A.length;i++) {
        	for(int j=0;j<B.length;j++) {
        		map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0)+1);//保存这个和出现的次数
        	}
        }
        for(int i=0;i<C.length;i++) {
        	for(int j=0;j<D.length;j++) {
        		res+=map.getOrDefault(-C[i]-D[j], 0);//获取map中值-C[i]-D[j]为0的出现次数
        	}
        }
        return res;
    }
}

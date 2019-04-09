package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 873. 最长的斐波那契子序列的长度
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：

n >= 3
对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。

（回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）

 

示例 1：

输入: [1,2,3,4,5,6,7,8]
输出: 5
解释:
最长的斐波那契式子序列为：[1,2,3,5,8] 。
示例 2：

输入: [1,3,7,11,12,14,18]
输出: 3
解释:
最长的斐波那契式子序列有：
[1,11,12]，[3,11,14] 以及 [7,11,18] 。
 

提示：

3 <= A.length <= 1000
1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
（对于以 Java，C，C++，以及 C# 的提交，时间限制被减少了 50%）
 * @author liang
 *
 */
public class LengthofLongestFibonacciSubsequence_873 {

	/**
	 * 方法2：动态规划，a+b=c,A[i]+A[j]=A[k] 则 dp[i][j]=d[j][k]+1 dp表明从i到j符合条件长度
	 * @param A
	 * @return
	 */
	public int lenLongestFibSubseq2(int[] A) {
		int n = A.length;
		int[][] dp = new int[n][n];
		int res = 0;
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<n;i++) {
			hm.put(A[i], i);
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(A[i]-A[j]<A[j] && hm.get(A[i]-A[j])!=0) {
					dp[i][j]=dp[j][hm.get(A[i]-A[j])]+1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;
	}
	
	
	
	
	int maxLen = 2;
	/**
	 * dfs深度探索.使用map保存值和对应的坐标，这样可以根据加和后的值得到对应下标，在根据这个下标+1 dfs
	 * @param A
	 * @return
	 */
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
        	map.put(A[i], i);
        }
        for(int first=0;first<A.length-2;first++) {
        	for(int second=first+1;second<A.length-1;second++) {
        		getNext(A,A[second],A[first]+A[second],2,map);
        	}
        }
        return maxLen == 2?0:maxLen;     
    }
    //dfs
	private void getNext(int[] a, int firstValue, int secondValue, int len, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		if(len>maxLen)
			maxLen = len;
		if(map.containsKey(secondValue)) {
			int i = map.get(secondValue);
			System.out.println("fir=="+firstValue+",se=="+secondValue+",i=="+i);
			getNext(a,secondValue,firstValue+secondValue,len+1,map);//这里是firstValue+secondValue
		}
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthofLongestFibonacciSubsequence_873 ll = new LengthofLongestFibonacciSubsequence_873();
		int[] a = {1,2,3,4,5,6,7,8};
		ll.lenLongestFibSubseq(a);
	}

}

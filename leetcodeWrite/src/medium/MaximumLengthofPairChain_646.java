package medium;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。

现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。

给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。

示例 :

输入: [[1,2], [2,3], [3,4]]
输出: 2
解释: 最长的数对链是 [1,2] -> [3,4]
注意：

给出数对的个数在 [1, 1000] 范围内。
 * @author liang
 *
 */
public class MaximumLengthofPairChain_646 {

	/**
	 * dp，dp[i]储存的是从i结束的链表长度最大值。首先初始化每个dp[i]为1。然后对于每个dp[i]，找在 i 前面的索引 0~j，如果存在可以链接在i 前面的数组，且加完后大于dp[i]之前的值，那么则在dp[j]的基础上+1.
	 * @param pairs
	 * @return
	 */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->(a[0]-b[0]));
        int i,j,max = 0,n=pairs.length;
        int[] dp = new int[n];
        for(i=0;i<n;i++)
        	dp[i] = 1;
        for(i=1;i<n;i++)
        	for(j=0;j<i;j++)
        		if(pairs[j][1]<pairs[i][0] && dp[i]<dp[j]+1) {//前一个数对的第二个数小于后一个数对的第一个数，且 动态规划i位置的链表长度最大值 < dp[j]+1
        			dp[i] = dp[j]+1;
        		}
        for(i = 0;i<n;i++)
        	if(max<dp[i])
        		max = dp[i];
        return max;
    }
    
    /**
     * 贪心算法，使用数对第二个元素排序，遍历判断数对第一个数是否大于end，大于就count++
     * @param pairs
     * @return
     */
    public int findLongestChain2(int[][] pairs) {
    	Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
    	 
        int count = 0, end = Integer.MIN_VALUE;
        for (int[] pair : pairs)
        {
            if (pair[0] > end)
            {
                count++;
                end = pair[1];
            }
        }
        return count;
    	
    }
    
}

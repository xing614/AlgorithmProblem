package medium;
/**
 * 673. 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。

示例 1:

输入: [1,3,5,4,7]
输出: 2
解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
示例 2:

输入: [2,2,2,2,2]
输出: 5
解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 * @author liang
 *
 */
public class NumberofLongestIncreasingSubsequence_673 {

	/*
	 * 动态规划，dp[]为以该数结尾，能构成的最长序列的长度，cnt[]以第i个数结尾的最长序列的个数。二层循环当nums[j]<nums[i] && dp[j]+1>dp[i] 时dp+1,cnt[i]=cnt[j]
	 */
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int max_len = 1;
        int res = 0;
        int[] dp = new int[len];//dp[i]为以该数结尾，能构成的最长序列的长度
        int[] cnt = new int[len];//以第i个数结尾的最长序列的个数
        for(int i=0;i<len;i++) {
        	dp[i] = 1;
        	cnt[i] = 1;
        }
        	
        for(int i=1;i<len;i++) {
        	for(int j=0;j<i;j++) {
        		if(nums[j]<nums[i] && dp[j]+1>dp[i]) {//说明升序，且i当前保存的最长序列不包括j
        			dp[i] = dp[j]+1;
        			cnt[i] = cnt[j];//所以以j为i的前一个数的序列为最长序列
        		}else if(nums[j]<nums[i] && dp[j]+1==dp[i]) {//说明升序，且最长长度和j+1一样，则
        			cnt[i]+=cnt[j];
        		}
        	}
        	max_len = Math.max(max_len, dp[i]);
        }
       // System.out.println(max_len);
        for(int i=0;i<len;i++)
        {
        	//System.out.println(dp[i]+" "+cnt[i]);
        	if(dp[i] == max_len) {
        		res+=cnt[i];  
        	}
        		      	
        }

        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,2,2,2};
		NumberofLongestIncreasingSubsequence_673 nn =  new NumberofLongestIncreasingSubsequence_673();
		System.out.println(nn.findNumberOfLIS(nums));
	}

}

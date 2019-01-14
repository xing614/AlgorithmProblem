package medium;
/**
 * 667. 优美的排列 II
 * 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：

① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.

② 如果存在多种答案，你只需实现并返回其中任意一种.

示例 1:

输入: n = 3, k = 1
输出: [1, 2, 3]
解释: [1, 2, 3] 包含 3 个范围在 1-3 的不同整数， 并且 [1, 1] 中有且仅有 1 个不同整数 : 1
 

示例 2:

输入: n = 3, k = 2
输出: [1, 3, 2]
解释: [1, 3, 2] 包含 3 个范围在 1-3 的不同整数， 并且 [2, 1] 中有且仅有 2 个不同整数: 1 和 2
 

提示:

 n 和 k 满足条件 1 <= k < n <= 104.
 * @author liang
 *
 */
public class BeautifulArrangementII_667 {

	/**
	 * 先组合出k-1个不同整数，即奇数位放从n~n-k/2  偶数位方1~1+k/2 之后所有位顺序放入
	 * @param n
	 * @param k
	 * @return
	 */
    public int[] constructArray(int n, int k) {
    	int[] res = new int[n]; 
    	int max = n, min = 1; 
    	int i; 
    	for (i = 0; i < k; i ++) { //1,n,2,n-1,3,n-2...即差值9，8，7，6.。。 共有k-1个不同整数
    		if (i % 2 != 0) 
    			res[i] = max --; 
    		else res[i] = min ++; 
    	} 
    	if (i % 2 == 0) { //这部分有1个整数差值 为1
    		for (int j = k; j < n; j ++) 
    			res[j] = max --; 
    	} 
    	else { 
    		for (int j = k; j < n; j ++) 
    			res[j] = min ++; 
    	} 
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

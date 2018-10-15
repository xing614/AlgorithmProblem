package medium;
/**
 * 计算各个位数不同的数字个数
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。

示例:

输入: 2
输出: 91 
解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 * @author liang
 *
 */
public class CountNumbersWithUniqueDigits_357 {

	/**
	 * 当n=1时因为只有一个数字，所以0-9都是答案．
	 * 当n>=2时，最高位可以为1-9任意一个数字，之后各位可以选择的数字个数依次为9, 8, 7, 6...，
	 * 上一位选一个下一位就少了一种选择．
	 * @param n
	 * @return
	 */
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
        	return 1;
        if(n == 1)
        	return 10;
        int val = 9,ans = 10;//ans返回结果
        for(int i=2;i<=n;i++) {
        	val *=(9-i+2);//增加一位，例如变成计算从10-99有9*9种可能   
        	ans +=val;
        }
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

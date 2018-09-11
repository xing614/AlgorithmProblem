package medium;
/**
 * 201. 数字范围按位与
题目描述提示帮助提交记录社区讨论阅读解答
给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内 所有数字 的按位与（包含 m, n 两端点）。

示例 1: 

输入: [5,7]
输出: 4
示例 2:

输入: [0,1]
输出: 0
 * @author liang
 *
 */
public class BitwiseANDofNumbersRange_201 {

	/**
	 * 思考 当m!=n，那么最末位必定等0，因为[m, n]必定包含奇偶数，相与最末位等0
	 * 每次将m和n右移一位记为mk、 nk，这样就相当于将[m, n]之间的所有的数都右移动了一位，当mk=nk的时候，说明之前[m, n]之间的数右移一位后是相等的
	 * 右移后的数作AND操作，结果还是m(=n)，所以操作就可以停止了记录右移的次数，offset，m>>offset即为所求结果
	 * @param m
	 * @param n
	 * @return
	 */
    public int rangeBitwiseAnd(int m, int n) {
    	int offset = 0;

        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }

        return m << offset;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package medium;
/**
 * 91. 解码方法
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * @author liang
 *
 */
public class DecodeWays_91 {

	/**
	 * 动态规划
	 * @param s
	 * @return
	 */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0')
                nums[i] = nums[i - 1];
            if (s.charAt(i - 2) != '0' && Integer.parseInt("" + s.charAt(i - 2) + s.charAt(i - 1)) < 27)
                nums[i] += nums[i - 2];
        }
        return nums[s.length()];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

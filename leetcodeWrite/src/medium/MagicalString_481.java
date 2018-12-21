package medium;
/**
 * 481. 神奇字符串
 * 神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：

字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。

字符串 S 的前几个元素如下：S = “1221121221221121122 ......”

如果我们将 S 中连续的 1 和 2 进行分组，它将变成：

1 22 11 2 1 22 1 22 11 2 11 22 ......

并且每个组中 '1' 或 '2' 的出现次数分别是：

1 2 2 1 1 2 1 2 2 1 2 2 ......

你可以看到上面的出现次数就是 S 本身。

给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。

注意：N 不会超过 100,000。

示例：

输入：6
输出：3
解释：神奇字符串 S 的前 6 个元素是 “12211”，它包含三个 1，因此返回 3。
 * @author liang
 *
 */
public class MagicalString_481 {
	/**
	 * 规律题
	 * 其字符串自身每个元素代表后面1或者2连续出现的个数
	 * 根据前面的结果来得到下一个数字是多少。两个point:i和j 分别指向
	 * 返回有多少个1
	 * @param n
	 * @return
	 */
    public int magicalString(int n) {
        if(n == 0)
        	return 0;
        if(n<=3)
        	return 1;
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        int i = 2;
        int j = 3;
        int count = 1;//返回值
        while(j<n) {
        	int cur = 3^nums[j-1];//异或
        	for(int k = 0;k<nums[i] && j<n;k++) {
        		nums[j] = cur;
        		if(nums[j] == 1)
        			count++;
        		j++;
        	}
        	i++;
        }
        return count;
    }
    
    /**
     * 取出多余的数组，只保留一个，节省空间，同时对于放1还是放2的判断可以在一个循环内去做
     * @param n
     * @return
     */
    public int magicalString2(int n) {
        if (n == 0) return 0;
        else if (n <= 3) return 1;

        int[] num = new int[n];
        int result = 1;
        num[0] = 1;
        num[1] = 2;
        boolean one = false;
        int index = 1;
        for (int i = 1; i < n; i++) {
            for (int j = num[index]; j > 0; j--) {
                if (i >= n) break;
                num[i] = one ? 1 : 2;
                if (one) result ++;
                i++;
            }
            i--;

            one = !one;
            index ++;
        }

        return result;
    }
}

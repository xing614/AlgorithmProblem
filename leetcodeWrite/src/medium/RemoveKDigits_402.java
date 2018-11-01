package medium;
/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:

num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。
示例 1 :

输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
示例 2 :

输入: num = "10200", k = 1
输出: "200"
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
示例 3 :

输入: num = "10", k = 2
输出: "0"
解释: 从原数字移除所有的数字，剩余为空就是0。
 * @author liang
 *
 */
public class RemoveKDigits_402 {

	/**
	 * 用个Stack来保存之前递增的数字。
	 * 
	 * 1432219，k = 3，不去掉1的原因是后面接的是4，
	 * 当前这一步，看到下一个数比自己大的时候移掉是不划算的，因为移掉这个数之后最高位变成4，是不如保留1小的。
	 * 所以可以看出规律实际上是从msb开始只要发现比之前有比当前位大的数字，那肯定要移掉之前的数字，这样当前最高位的数字就变小了。
	 * 后面的3和2需要移掉也是同理。用个Stack来保存之前递增的数字。
	 * @param num
	 * @param k
	 * @return
	 */
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int n = num.length();
        char[] stack = new char[n];
        int count = 0;
        //移除比当前位置数字大的数字
        for(int i=0;i<n;i++) {
        	//num.charAt(i) < stack[count -1]当前位置数据 小于前面第count-1位置的数据
        	//就是说一直移除当前位前位的数据
        	while(count!=0 && k>0 && num.charAt(i) < stack[count -1]) {
        		count--;
        		k--;
        	}
        	stack[count++] = num.charAt(i);
        }
        //移除首位是0的
        int start = 0;
        while(start<count && stack[start] == '0')
        	start++;
        
        return start>=count-k ? "0":new String(stack,start,count-start-k);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

示例 1:

输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数； 
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
注意: 输入数组的长度不会超过 10000。
 * @author liang
 *
 */
public class NextGreaterElementII_503 {

	/**
	 * 类似496题
	 * 使用栈 后进先出原则
	 * 遍历每个元素，将当前元素与栈头元素判断，如果当前元素大于栈头，就说明当前元素是栈头的最近下一个更大元素，然后弹出栈头保存，再接着判断栈头和当前元素，不大于就将当当前元素压栈
	 * @param nums
	 * @return
	 */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);//设置每个位置都为-1
        Stack<Integer> stack = new Stack<>();//保持索引值
        for(int i = 0;i<2*n;i++) {//遍历两轮保证循环搜索最大能搜索满
        	int num = nums[i %n];//当前元素
        	while(!stack.isEmpty() && num>nums[stack.peek()])
        		next[stack.pop()] = num;
        	if(i<n)//只存放一轮
        		stack.push(i);//存放索引
        }
        return next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

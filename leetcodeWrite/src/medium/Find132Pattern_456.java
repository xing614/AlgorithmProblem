package medium;

import java.util.Stack;

/**
 * 456. 132模式
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。

注意：n 的值小于15000。

示例1:

输入: [1, 2, 3, 4]

输出: False

解释: 序列中不存在132模式的子序列。
示例 2:

输入: [3, 1, 4, 2]

输出: True

解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
示例 3:

输入: [-1, 3, 2, 0]

输出: True

解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 * @author liang
 *
 */
public class Find132Pattern_456 {

	/**
	 * 建一个栈来维持一个单调子序列，倒序扫描。
	 * 设置一个s2为第三个数，从后往前遍历NUms[i]i位置代表s0，stack里保存的是最大值即大于S2的数据
	 * @param nums
	 * @return
	 */
    public boolean find132pattern(int[] nums) {
        int s2 = Integer.MIN_VALUE;//三个数里的第二个
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1;i>=0;i--) {
        	if(nums[i]<s2)//这个nums[i]相当于s0 
        		return true;
        	//移除所有小于nums[i]的元素，只保留一个放在s2上
        	while(!stack.isEmpty() && nums[i]>stack.peek()) {//peek获取最后一个元素
        		s2 = stack.pop();//获取最后一个并移除
        	}
        	stack.push(nums[i]);//最后位置添加  这是保存的数据是大于s2的数据
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

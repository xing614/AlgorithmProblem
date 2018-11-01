package medium;

import java.util.Random;

/**
 * 398. 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。

注意：
数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。

示例:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
solution.pick(3);

// pick(1) 应该返回 0。因为只有nums[0]等于1。
solution.pick(1);
 * @author liang
 *
 */
public class RandomPickIndex_398 {
	/**
	 * 蓄水池取样算法
	 * 水池大小为１，因此对k个target只要用概率1/k来决定是否替换水池中的数即可
	 * 
	 */
	int[] copy;
	Random random;
	
    public RandomPickIndex_398(int[] nums) {
        copy = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int ans = -1;
        for(int i=0,cnt = 1;i<copy.length;i++) {
        	if(copy[i] == target && random.nextInt(cnt++) == 0) {//如果随机值为0就说明1/k的概率命中了新出现相同元素的该位置i
        		ans = i;//所以就设置了该位置i
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package medium;

import java.util.Random;

/**
 * 384. 打乱数组
 * 打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
 * @author liang
 *
 */
public class ShuffleAnArray_384 {
	/**
	 * 每次往后读取数组的时候，当读到第i个的时候以1/i的概率随机替换1～i中的任何一个数，这样保证最后每个数字出现在每个位置上的概率都是相等的。
	 * 证明：
	 * 设x元素在第m次的时候出现在位置i的概率是1/m,那么在第m+1次的时候，x仍然待在位置i的概率是 1/m * m/(m+1) = 1/(m+1)
	 * @param nums
	 */
	
	private int[] nums = null;
	private Random random = null;
	
    public ShuffleAnArray_384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
	public int[] reset() {
	    return nums;
	}
	
	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if(nums == null)
			return null;
		int[] a = nums.clone();
		for(int i=1;i<nums.length;i++) {
			int j = random.nextInt(i+1);
			swap(a,i,j);
		}
		return a;
	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	
}

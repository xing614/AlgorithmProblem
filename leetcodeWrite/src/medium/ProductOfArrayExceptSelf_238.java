package medium;
/**
 * 238. 除自身以外数组的乘积
给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

示例:

输入: [1,2,3,4]
输出: [24,12,8,6]
说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * @author liang
 *
 */
public class ProductOfArrayExceptSelf_238 {

	/**
	 * res作为返回数组，先从右开始算 res[i] = res[i+1]*num[i+1]，这样当前res[]每个位置等于它右侧所有数的积
	 * 然后再从左开始 最初 left = 1,res[i] = res[i]*left,left=left*num[i],这样相当于乘以左侧的所有数
	 * @param nums
	 * @return
	 */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[res.length - 1] = 1;//设初始最右为1，开始计算
        //计算右侧的积
        for(int i=nums.length-2;i>=0;i--) {
        	res[i] = res[i+1]*nums[i+1];
        }
        int left = 1;
        for(int i = 0;i<nums.length;i++) {
        	res[i] *= left;
        	left *= nums[i];
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package medium;
/**
 * 457. 环形数组循环
 * 给定一组含有正整数和负整数的数组。如果某个索引中的 n 是正数的，则向前移动 n 个索引。相反，如果是负数(-n)，则向后移动 n 个索引。

假设数组首尾相接。判断数组中是否有环。环中至少包含 2 个元素。环中的元素一律“向前”或者一律“向后”。

示例 1：给定数组 [2, -1, 1, 2, 2], 有一个循环，从索引 0 -> 2 -> 3 -> 0。

示例 2：给定数组[-1, 2], 没有循环。

注意：给定数组保证不包含元素"0"。

 * @author liang
 *
 */
public class CircularArrayLoop_457 {
	/**
	 * 一个循环判断各个条件
	 * @param nums
	 * @return
	 */
    public boolean circularArrayLoop(int[] nums) {
        if(nums.length<2)
        	return false;
        int len = nums.length;
        int pos = 0;
        while(true) {
        	int tmp = (pos+nums[pos]+len)%len;//得到下一个位置
        	if(tmp == 0)//回到原点
        		return true;
        	if(nums[pos]*nums[tmp]<0)//两位置存放数据一正一负，倒着走了不能称为一个环
        		return false;
        	if(tmp == pos)//原地打转
        		return false;
        	pos = tmp;//设置下一个位置
        }
    }
}

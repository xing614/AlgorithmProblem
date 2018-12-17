package medium;

import java.util.HashSet;

/**
 * 565. 数组嵌套
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。

示例 1:

输入: A = [5,4,0,3,1,6,2]
输出: 4
解释: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

其中一种最长的 S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
注意:

N是[1, 20,000]之间的整数。
A中不含有重复的元素。
A中的元素大小在[0, N-1]之间。
 * @author liang
 *
 */
public class ArrayNesting_565 {

	HashSet<Integer> set = new HashSet<>();
	/**
	 * 从多个起点到达同一个值之后的路径都相同，所以每个值最多遍历一遍 O(N)。使用set存储遍历过的位置，然后每次从起点遍历时判断当前位置是否在set中，
	 * ***如果当前的元素已经在之前的环中出现过了，那么以该元素开头必定不会出现最大环。
	 * @param nums
	 * @return
	 */
    public int arrayNesting(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++) {
        	max = Math.max(max, check(nums,i));
        	if(max > nums.length/2)//如果一个环的长度超过了数组的一半大小，那么这个长度就是答案直接返回即可
                return max;
        }
        return max;
    }
    
	private int check(int[] nums, int i) {
		// TODO Auto-generated method stub
		int res = 0;
		while(!set.contains(i)) {
			set.add(i);
			i = nums[i];
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

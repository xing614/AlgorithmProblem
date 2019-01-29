package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

示例 1:

输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
示例 2:

输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于num1中的数字2，第二个数组中的下一个较大数字是3。
    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
注意:

nums1和nums2中所有元素是唯一的。
nums1和nums2 的数组大小都不超过1000。
 * @author liang
 *
 */
public class NextGreaterElementI_496 {
	/**
	 * 使用stack栈先进后出原则，将当前元素与栈头比较大小，大于则当前元素时栈头下一个大元素 同时出栈，小于则将当前元素压栈
	 * 使用map保存下一个大元素，最后将nums1的元素在map中寻找
	 * @param nums1
	 * @param nums2
	 * @return
	 */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	Map<Integer,Integer> map = new HashMap<>();
    	Stack<Integer> stack = new Stack<>();
    	int[] result = new int[nums1.length];
    	for(int num:nums2) {
    		while(!stack.isEmpty() && stack.peek()<num) {
    			map.put(stack.pop(), num);
    		}
    		stack.push(num);
    	}
    	for(int i =0;i<nums1.length;i++) {
    		if(map.containsKey(nums1[i])) {
    			result[i] = map.get(nums1[i]);
    		}else {
    			result[i] = -1;
    		}
    	}
    	return result;
    }
    /**
     * 方法2 正常遍历 使用两个标记，一个标记找到Num1的数据在num2的位置，第二个标记判断是否找到下一个大元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
    	int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            int num1 = nums1[i];
            boolean flagNum1IsFound = false;
            boolean flagGreaterIsFound = false;
            for(int j=0; j<nums2.length; j++) {
                if(nums2[j] == num1) flagNum1IsFound = true;
                if(flagNum1IsFound && nums2[j]>num1) {
                    res[i] = nums2[j];
                    flagGreaterIsFound = true;
                    break;
                }
            }
            if(!flagGreaterIsFound) res[i] = -1;
        }
        return res;
    }
}

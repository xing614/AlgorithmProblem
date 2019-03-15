package easy;
/**
 * 169. 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
 * @author liang
 *
 */
public class MajorityElement_169 {
	/**
	 * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
	 * @param nums
	 * @return
	 */
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=res){
                if(count>0){
                    count--;
                }else{
                    count++;
                    res = nums[i];
                }
            }else{
                count++;
            }
        }
        return res;
    }
}

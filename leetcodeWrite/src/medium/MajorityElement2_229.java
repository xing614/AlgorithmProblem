package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 229. 求众数 II
给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

示例 1:

输入: [3,2,3]
输出: [3]
示例 2:

输入: [1,1,1,3,3,2,2,2]
输出: [1,2]

 * @author liang
 *
 */
public class MajorityElement2_229 {

	/**
	 * 1. 超过n/3元素个数最多只有2个，记为num1和num2
	 * 2. 数组中连续3个数据为一组的话,一共n/3组,那么如果存在符合条件的元素,这个元素一定出现在某一个组内两次
	 * 3. 知道了以上两个条件后,用所谓的摩尔投票法,共两轮,
	 *  第一轮:找出出现次数最多的两个元素,每次存储两个元素num1和num2,
	 *  如果第三个元素与其中一个相同,则增加计数c1或c2,  否则,清除n1和n2,从下一个数据开始重新统计.
	 *  根据第二条,数目较多的元素一定可以被查到,当然查到的不一定是大于n/3的.
	 *  第二轮:验证这两个元素是否满足条件,即出现的次数是否大于n/3;


	 * @param nums
	 * @return
	 */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length ==0)
        	return res;
        if(nums.length == 1) {
        	res.add(nums[0]);
        	return res;
        }
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int num:nums) {
        	if(num1 == num) count1++;
        	else if(num2 == num) count2++;
        	else if(count1<1) {//个数小于1后num1重新设定数字
        		count1 = 1;
        		num1 = num;
        	}else if(count2<1) {//同上
        		count2 = 1;
        		num2 = num;
        	}else {//都不是这两个数，就个数-1
        		count1--;
        		count2--;
        	}
        }
        count1 = 0;
        count2 = 0;
        //判断这两个数过1/3了没
        for(int num:nums) {
        	if(num == num1)
        		count1++;
        	else if(num == num2)
        		count2++;
        }
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。

示例 1:

输入: [0,1,2,4,5,7]
输出: ["0->2","4->5","7"]
解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
示例 2:

输入: [0,2,3,4,6,8,9]
输出: ["0","2->4","6","8->9"]
解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 * @author liang
 *
 */
public class SummaryRanges_228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 1) {
        	res.add(nums[0]+"");
        	return res;
        }
        for(int i=0;i<nums.length;i++) {
        	int a = nums[i];
        	while(i<nums.length-1 && (nums[i+1]-nums[i] == 1)) {//一直往后移
        		i++;
        	}
        	if(a!=nums[i]) {
        		res.add(a+"->"+nums[i]);
        	}else {
        		res.add(a+"");
        	}
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

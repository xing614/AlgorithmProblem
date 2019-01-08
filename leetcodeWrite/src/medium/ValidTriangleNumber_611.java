package medium;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

示例 1:

输入: [2,2,3,4]
输出: 3
解释:
有效的组合是: 
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
注意:

数组长度不超过1000。
数组里整数的范围为 [0, 1000]。
 * @author liang
 *
 */
public class ValidTriangleNumber_611 {

	/**
	 * 排序+双指针，对输入数组nums排序，枚举最小的边，利用双指针寻找符合条件的长度最大的两条边。时间复杂度O(n²),空间复杂度O(logn)。
	 * @param nums
	 * @return
	 */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int res = 0;
        for(int i=0;i<size-2;i++) {
        	if(nums[i] == 0)
        		continue;
        	int k =i+2;
        	for(int j=i+1;j<size-1;j++) {
        		while (k < size && nums[k] < nums[i] + nums[j]) k++;//形成三角形的话k就后移
        		res+=k-j-1;//不构成三角形了，k与j之间的差距就是三角形个数
        	}
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

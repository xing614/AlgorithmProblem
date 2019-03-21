package hard;

import java.util.Arrays;

/**
 * 719. 找出第 k 小的距离对
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。

示例 1:

输入：
nums = [1,3,1]
k = 1
输出：0 
解释：
所有数对如下：
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
提示:

2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
 * @author liang
 *
 */
public class FindKthSmallestPairDistance_719 {

	/**
	 * 二分查找+滑动窗口。二分查找看的是距离对的值 先找到距离对中间值mid。left=0,right=0开始right向右移动 计算right和left的差值是否小于mid，小于就right++ 且 cnt++(cnt是距离对<mid的个数)，否则就left++(滑动窗口)
	 * 比较cnt和k的大小,cnt小的话 说明第k小距离对在数组右侧，则left=mid+1,否则right=mid，接着这么找
	 * @param nums
	 * @param k
	 * @return
	 */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0,h = nums[n-1]-nums[0];
        while(l<h) {
        	int m = (l+h)/2;//距离对中间值
        	//滑动窗口
        	int left = 0;
        	int cnt = 0;
        	for(int right = 0;right<n;right++) {
        		while(nums[right] - nums[left]>m) {//大于中间值 left右移
        			left++;
        		}
        		cnt+=right-left;//每 right右移 新添的距离对个数
        	}
        	if(cnt>=k) {
        		h = m;
        	}else {
        		l = m+1;
        	}
        }
        return l;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

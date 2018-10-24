package medium;
/**
 * 287. 寻找重复数
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2
示例 2:

输入: [3,1,3,4,2]
输出: 3
说明：

不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。

 * @author liang
 *
 */
public class FindTheDuplicateNumber_287 {

	/**
	 * 数组元素范围是1-n，可以吧数组当成一个链表     i的下一个位置是num[i]，因为有重复元素，所以会有一个环
	 * 要找到重复元素就是环的入口，
	 * 带环的链表有个性质：假设环的长度是n，那么p1从链表起始出发，p2从链表头部移动n次的位置出发，同时移动两个指针，当它们的值相同时，它们就位于环的入口元素。
	 * 
	 * 先要知道环的长度l，这样用两个指针分别从0和l位置前进m次可以找到重复元素，即前进m次这两个指针所在位置的元素值相同
	 * 可以利用快慢指针知道环的长度,当它们第一次相遇时，它们位于环内的某个元素，此时，p2比p1多走了n步，n就是环的长度。
	 * @param nums
	 * @return
	 */
    public int findDuplicate(int[] nums) {
    	//两个位置指针p1p2
    	int p1 = nums[0];
        int p2 = nums[nums[0]];
        int len = 1;

        //找到环的长度，p1走一步，p2走两步
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[nums[p2]];
            len++;
        }
        //p2走到环里
        p1 = nums[0];
        for (; len >= 0; len--)
            p2 = nums[p2];
        //同时前进 直到找到相同
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }

        return p1;
    }
    /**
     * 方法二
     * 设 l 为左值， r 为右值， mid 为两者的中间值。值得注意的是，这里的 l, r, mid 均是指元素的值，不是指下标，之所以可以这么做，是因为题目的条件“ n+1 长的数组里面只有 1...n 的数值”。
     * 将数组扫一遍，得到大于等于 l 且 小于等于 mid 的元素个数，即为 num_l_mid。
     * 当 num_l_mid 大于 本应该有的个数，则将重复值定位在 [l, mid] 之间，缩小范围。
     * 当 num_l_mid 小于等于 本应该有的个数，则将重复值定位在 [mid, r] 之间，缩小范围。
     * 重复前面步骤，直到找到重复值。
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
    	//二分查找
        int length = nums.length;
        int left = 1;
        int right = length-1;

        while(left<right){
            int mid = (left+right)/2;
            int count = 0;
            int base = 0;
            for(int i = 0;i<length;i++){
                if(nums[i]<mid)
                    count++;
                else if(nums[i]==mid)
                    base++;
            }
            if(base>1)
                return mid;
            else if(count+base>mid)
                right = mid-1;
            else
                left = mid+1;
        }
        return left;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

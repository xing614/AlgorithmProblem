package medium;

/**
 * 摆动序列
 * 
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。

例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。

给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。

示例:

输入: [1,7,4,9,2,5]
输出: 6
解释: 整个序列就是一个摆动序列。

输入: [1,17,5,10,13,15,10,5,16,8]
输出: 7
解释: 它的几个子序列满足摆动序列。其中一个是[1,17,10,13,10,16,8]。

输入: [1,2,3,4,5,6,7,8,9]
输出: 2
进阶:
你能否用 O(n) 时间复杂度完成此题?
 * @author liang
 *
 */
public class WiggleSubsequence {
	/**
	 * 三种思路
	 * @param nums
	 * @return
	 */
	
	/**
	 * 思路一：
	 * 在序列向前延伸过程中，是一个找“拐点”的过程，拐点满足摇摆条件，每遇到一个拐点就在摇动序列添加一个元素
	 * 如果是相等的连续元素，在拐点判断中这些元素可以视为一个元素，遇到相等的连续元素跳过即可
	 * 
	 * 这个思路有问题,在于flag
	 * @param nums
	 * @return
	 */
    public static int wiggleMaxLength1(int[] nums) {
    	int len = nums.length;
    	if(len == 0) return 0;
    	boolean flag = false;//用于判断相邻两点是正还是负，
    	int length = 1;//摇动序列的长度,最初默认为1
    	int prev = nums[0];//前一个元素
    	for(int i=0;i<len;i++) {
    		if(nums[i]==prev) continue;
    		if(flag != nums[i]>prev) {//这是拐点，当前相邻点差值与前一组正好相反
    			flag = nums[i]>prev;//设当前拐点差值
    			length++;
    		}
    		prev = nums[i];
    	}
		return length;
        
    }
    
    /**
     * 思路2：动态规划
     * 维护两个数组up,down.
     * up[i]数组表示从0到i为止以上升为结束的最长摆动序列长度
     * down[i]数组表示从0到i为止以下降为结束的最长摆动序列长度
     * 遍历数组，如果num[i]>num[i-1]表明从i-1到i元素是上升的，因此up[i]=max(up[i-1],down[i-1]+1)  也可以不这样，最后比较up[len-1] down哪个大即可
     * 如果nums[i]<nums[i-1],表明是下降的，down[i]=max(down[i-1],up[i-1]+1)
     * @param nums
     * @return
     */
    public static int wiggleMaxLength2(int[] nums) {
    	int len = nums.length;
    	if(len == 0) return 0;
    	int[] up = new int[len];
    	int[] down = new int[len];
    	up[0] = down[0] = 1;//默认为1
    	for(int i =1;i<len;i++) {
    		if(nums[i]>nums[i-1]) {
    			//up[i] = up[i-1]>(down[i-1]+1)?up[i-1]:(down[i-1]+1);
    			up[i] = down[i-1] + 1;
    			down[i] = down[i-1];
    		}else if(nums[i]<nums[i-1]) {
    			down[i] = up[i-1]+1;
    			up[i] = up[i-1];
    		}else {
    			up[i] = up[i-1];
    			down[i] = down[i-1];
    		}
    	}
		return up[len-1]>down[len-1]?up[len-1]:down[len-1];
    	
    	
    }
    
    /**
     * 贪心算法：O（n）时间复杂度
     * 维护两个变量p q，遍历数组，如果当前数字比前一个数字大，则p=q+1，如果比前一个数字小，则q=p+1，最后取p和q中的较大值跟n比较，取较小的那个
     * 就是贪婪，当num[i]>num[i-1]时，觉得上升序列为下降序列+1
     * @param nums
     * @return
     */
    public static int wiggleMaxLength3(int[] nums) {
    	if(nums.length == 0) return 0;
        int p = 1, q = 1, n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) p = q + 1;
            else if (nums[i] < nums[i - 1]) q = p + 1;
        }
        return p>q?p:q;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] aa = {3,3,3,2,5};
		System.out.println(wiggleMaxLength2(aa));
	}

}

package hard;
/**
 * 41. 缺失的第一个正数
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
说明:

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * @author liang
 *
 */
public class FirstMissingPositive {

	/**
	 * 利用数组本身，利用数组的index来作为数字本身的索引，把正数按照递增顺序依次放到数组中。
	 * 即让A[0]=1, A[1]=2, A[2]=3, ... , 
	 * 这样一来，最后如果哪个数组元素违反了A[i]=i+1即说明i+1就是我们要求的第一个缺失的正数。
	 * 对于那些不在范围内的数字，直接跳过，比如说负数，0，或者超过数组长度的正数，这些都不是答案
	 * @param nums
	 * @return
	 */
    public static int firstMissingPositive(int[] nums) {
        if(nums.length == 0||nums == null) {
        	return 1;
        }
        for(int i=0;i<nums.length;i++) {//重新整理数组中的数
        	System.out.println(i);
        	//i里的数不超过数组长度的正数 且  不是负数  且  i位置数据和要转换的  （i中数据理应对应的位置nums[i]-1]中的数据） 不一样
        	//nums[nums[i]-1]==nums[i]说明nums[i] = i+1 这种情况 当前的数字所对应的下标已经是对应数字，就跳过
        	//nums[i]<nums.length就不会让超出数组角标的数据判断
        	if(nums[i]<nums.length && nums[i]>0 && nums[nums[i]-1]!=nums[i]) {
        		System.out.println("i=="+i+".nums[i]=="+nums[i]);
        		//互换数据
        		int temp = nums[nums[i]-1];
        		nums[nums[i]-1] = nums[i];
        		nums[i] = temp;
        		i--;//接着判断这个i的位置
        	}
        }
        for(int i=0;i<nums.length;i++) {
        	System.out.print(" "+nums[i]);
        }
        //找出最小的不符合A[i]=i+1规则的数，他就是缺失的第一个正数
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]!=i+1) {
        		return i+1;
        	}
        }
        
        return nums.length+1;
    }
    	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,8,9,11,12};
		System.out.println(firstMissingPositive(nums));
	}

}

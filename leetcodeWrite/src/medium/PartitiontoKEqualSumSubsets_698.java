package medium;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

示例 1：

输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 

注意:

1 <= k <= len(nums) <= 16
0 < nums[i] < 10000
 * @author liang
 *
 */
public class PartitiontoKEqualSumSubsets_698 {

	int K;
	/**
	 * 回溯法，通过helper,每组假设的时候 减去值，退出假设再加回去
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean canPartitionKSubsets1(int[] nums, int k) {
		int len =nums.length;
		int sum = 0;
		if(len == 0 || k == 0)
			return false;
		K = k;
		int[] arr = new int[k];//初始每个位置为sum/k,用于存放这k组数组，每组数组还差多少和就是sum/k了
		for(int num:nums) {
			sum+=num;
		}
		int target = sum/k;
		if(sum%k!=0)
			return false;
		Arrays.fill(arr, target);//arr都填值为target
		Arrays.sort(nums);
		return helper(nums,len-1,arr);
		
	}
	
	
	
	
	private boolean helper(int[] nums, int cur, int[] arr) {
		// TODO Auto-generated method stub
		if(cur<0)
			return true;
		int temp = nums[cur];
		for(int i=0;i<K;i++) {
//        	for(int n:arr) {
//        		System.out.print(n +" ");
//        	}
//        	System.out.println();
			if(arr[i] == temp || (cur>0 &&arr[i]-temp >= nums[0])) {
				arr[i] -= temp;
				if(helper(nums,cur-1,arr)) {

					return true;
				}
				arr[i] += temp;
				
			}
		}
		return false;
	}




	//这个方法有问题,在面对6 6 6 7 7 7 7 7 7 10 10 10 时 第一组称为10 10 10，然后后面都失败
	int[] nums;
	int count = 0;//当前符合要求的数组数，最后与k做对比
	/**
	 * 先排序，判断%k是否为0，target = sum/k,从后往前遍历，每次与target做对比是否匹配，匹配就设置当前位置为0说明这个位置被使用了
	 * @param nums
	 * @param k
	 * @return
	 */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length == 0)
        	return false;
        int sum = 0;
        for(int num:nums) {
        	sum +=num;
        }
        if(sum%k !=0)
        	return false;
        int target = sum/k;
        Arrays.sort(nums);
        if(nums[nums.length-1]>target)
        	return false;
        this.nums = nums;
        System.out.println(target);
        for(int i = this.nums.length-1;i>=0;i--) {
        	for(int n:nums) {
        		System.out.print(n +" ");
        	}
        	System.out.println();
        	
        	if(this.nums[i] == 0)
        		continue;//这个位置被用过了 就跳过
        	else {
        		recursive(target,i);//递归整合以第i位为基础要组合的数组和为target
        	}

        }
        System.out.println(this.count);
        return this.count == k;
    }
    
	private boolean recursive(int target, int begin) {
		// TODO Auto-generated method stub
		for(int i= begin;i>=0;i--) {
			if(this.nums[i] == 0)
				continue;//用过就跳过
			if(this.nums[i]>target)
				continue;
			if(this.nums[i] == target) {
				this.count++;//多了一组和为target的，就++
				this.nums[i] = 0;//当前位置用过了 就设为0
				return true;//返回匹配成功
			}
			if(recursive(target-this.nums[i], begin-1)) {//加入当前位置后可以匹配
				this.nums[i] = 0;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitiontoKEqualSumSubsets_698 pp = new PartitiontoKEqualSumSubsets_698();
		int[] nums = {10,10,10,7,7,7,7,7,7,6,6,6};
		//System.out.println(pp.canPartitionKSubsets(nums, 3));
		int[] nums2 = {4,3,2,3,5,2,1};
		System.out.println(pp.canPartitionKSubsets1(nums, 3));
				
	}

}

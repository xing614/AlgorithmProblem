package medium;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * @author liang
 *
 */
public class NextPermutation {

	/**
	 * 全排列
	 * 具体排列过程是 看当前排列顺序 比如1 2 7 4 3 1，看到从7开始后面都是降序，即锁定了1 和 2
	 * 它的下一个排列是将2锁定为3，然后升序排列后面四个数，即 1 3 1 2 4 7
	 * @param nums
	 */
    public static void nextPermutation(int[] nums) {
        int index = nums.length-1;
        System.out.println(index);
        if(index <1) {
        	return;
        }
        while( index>0 && nums[index]<=nums[index-1])//例子就是1<3 3<4 4<7直到7!<2
        {
        	--index;//最终Index==2
        }
        if(index==0) {//到最后一个排列了，然后重新排列
        	Arrays.sort(nums);
        	return;
        }
        int exchangeIndex = 0;
        for(int i = nums.length-1; i >= index; i--){
           if(nums[i] > nums[index-1]){//寻找index-1位的下一个代替者，应该是大于index-1的最近值,因为后面几位是降序排列，所以从最后依次找即可
               exchangeIndex = i;
               break;
           }
        }
        //将替代者与index-1位互换
        int temp = nums[index - 1];
        nums[index - 1] = nums[exchangeIndex];
        nums[exchangeIndex] = temp;
        Arrays.sort(nums, index, nums.length);//最后几位升序排列

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2};//{3,2,1};
		nextPermutation(nums);
		System.out.println(nums[0]+" "+nums[1]);//+" "+nums[2]);
	}

}

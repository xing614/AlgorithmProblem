package medium;
/**
 * 75. 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @author liang
 *
 */
public class SortColors_75 {

	/**
	 * 常数空间
	 * 设一个指针red 在开头，blue 在最后。
	 * 想法就是，遇到红色0，就交换，把0放到最左边去；
	 * 遇到蓝色2就交换，把2都放到最右边去，这样1就会被保留在最中间。
	 * 需要注意的是，当把蓝色2交换完毕之后，需要i--， 停留 i 在原地一次，因为还需要继续检查 被2交换回来的数字。
	 * 那当遇到红色0，交换完毕不需要停留i 的原因是， 交换回来的只可能是1，对于1，我们不需要做任何处理，直接过就可以。
	 * @param nums
	 */
    public void sortColors(int[] nums) {
        int red= 0;
        int blue = nums.length-1;
        for(int i=0;i<=blue;i++) {
        	if(nums[i]==0) {
        		int temp = nums[i];
        		nums[i] = nums[red];
        		nums[red] = temp;
        		red++;
        		//这不用i--是因为交换回来的只可能是1，对于1，我们不需要做任何处理，直接过就可以。
        	}
        	else if(nums[i]==2) {
        		int temp = nums[i];
        		nums[i] = nums[blue];
        		nums[blue] = temp;
        		blue--;
        		i--;//因为这个位置  还需要继续检查 被2交换回来的数字
        	}
        }
    }
    
    /**
     * 方法二
     * 本质上也是设置前部分是0，i代表从0位置直到0数字用完，j代表数字1，k是数字2
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int i = -1,j = -1,k = -1;
		 for(int m = 0; m < nums.length; m++){
		     if(nums[m] == 0){
		         nums[++k] = 2;
		         nums[++j] = 1;
		         nums[++i] = 0;
		     }else if(nums[m] == 1){
		         nums[++k] = 2;
		         nums[++j] = 1;
		     }else{
		         nums[++k] = 2;
		     }
		 }

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

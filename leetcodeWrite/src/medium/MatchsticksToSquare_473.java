package medium;
/**
 * 473. 火柴拼正方形
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。

示例 1:

输入: [1,1,2,2,2]
输出: true

解释: 能拼成一个边长为2的正方形，每边两根火柴。
示例 2:

输入: [3,3,3,3,4]
输出: false

解释: 不能用所有火柴拼成一个正方形。
注意:

给定的火柴长度和在 0 到 10^9之间。
火柴数组的长度不超过15。
 * @author liang
 *
 */
public class MatchsticksToSquare_473 {

	/**
	 * dfs深度搜索
	 * @param nums
	 * @return
	 */
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for(int i= 0;i<nums.length;i++) {
        	sum+=nums[i];
        }
        if(sum%4 != 0) {//不能被四整除
        	return false;
        }
        int[] sums = new int[4];//正方形每一条边的长度
        return find(nums,sums,0,sum/4);
    }

    /**
     * 
     * @param nums
     * @param sums
     * @param index 当前所处nums位置
     * @param average 边平均长度
     * @return
     */
	private boolean find(int[] nums, int[] sums, int index, int average) {
		// TODO Auto-generated method stub
		if(nums.length<=3 || nums.length<index)
			return false;
		//搜索到最后位置
		if(index == nums.length) {
			if(sums[0]==average && sums[1]==average && sums[2]==average&& sums[3]==average)
	        	return true;
	        else
	        	return false;
		}
		//搜索
		for(int i=0;i<4;i++) {
			if(nums[index]+sums[i]<=average) {
				 if( i>0 && sums[i]==sums[i-1] ) continue; //边相同则跳过  这句很重要 剪枝
                 //加上此根火柴
                 sums[i]+=nums[index];
                 //继续往下搜索 
                 if(find(nums,sums,index+1,average)) return true;
                 //还原
                 sums[i]-=nums[index];
			}
		}
		return false;
	}
    
}

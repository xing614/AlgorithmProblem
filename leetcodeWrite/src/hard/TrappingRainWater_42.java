package hard;
/**
 * 42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 * @author liang
 *
 */
public class TrappingRainWater_42 {

	/**
	 * 第一种方法，动态规划
	 * 维护一个一维的dp数组，这个DP算法需要遍历两遍数组，
	 * 第一遍遍历dp[i]中存入i位置左边的最大值，（即dp[i]保存的是i位置左边最大的值）
	 * 然后开始第二遍遍历数组，第二次遍历时找右边最大值，
	 * 然后和左边最大值比较取其中的较小值，（即保存的是i位置右边和左边最大值中小的那个）
	 * 然后跟当前值A[i]相比，
	 * 如果大于当前值，则将差值存入结果（表示当前i位置可存储的雨滴数）
	 * @param height
	 * @return
	 */
    public int trap(int[] height) {
        int[] dp = new int[height.length];
        int len = height.length;
        if(len == 0)return 0;
        int res = 0;//依次累加雨滴数
        int max = 0;//中间数，找（左/右）最大值
        //从左边开始遍历
        for(int i=0;i<len;i++) {
        	dp[i] = max;//dp记录i位置之前的最大值
        	max = Math.max(max, height[i]);//max去i之前的最大值和height[i]比较的最大值
        }
        max = 0;
        for(int i=len-1;i>=0;i--) {
        	dp[i] = Math.min(dp[i], max);//将右边最大值和左边最大值比较小的放入dp
        	max = Math.max(max, height[i]);
        	if(dp[i]-height[i]>0)//说明左右最大值小的那个值>当前i位置的深度，这是dp和height的高度差就是可放雨滴数
        		res +=dp[i]-height[i];
        }
        return res;
    }
    /**
     * 第二种方法
     * 一次遍历
     * 需要left和right两个指针分别指向数组的首尾位置，
     * 从两边向中间扫描，在当前两指针确定的范围内，先比较两头找出较小值，
     * 如果较小值是left指向的值，则从左向右扫描，
     * 如果较小值是right指向的值，则从右向左扫描，
     * 若遇到的值比当较小值小，则将差值存入结果，
     * 如遇到的值大，则重新确定新的窗口范围，以此类推直至left和right指针重合
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int mn = Math.min(height[l], height[r]);
            if (height[l] == mn) {
                ++l;
                while (l < r && height[l] < mn) {
                    res += mn - height[l++];
                }
            } else {
                --r;
                while (l < r && height[r] < mn) {
                    res += mn - height[r--];
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

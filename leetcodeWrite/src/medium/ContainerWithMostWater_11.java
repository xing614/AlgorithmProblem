package medium;
/**
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

注意：你不能倾斜容器，n 至少是2。

表示：给一组数组。找到最大的(j-i)*(min(aj,ai)),就是求矩形面积最大的值
 * @author liang
 *
 */
public class ContainerWithMostWater_11 {
	/**
	 * 暴力解法，两层循环找最大
	 * 但是超时了
	 * @param height
	 * @return
	 */
    public int maxArea(int[] height) {
    	int hlen = height.length;
    	int max = 0;
    	for(int i=0;i<hlen;i++) {
    		for(int j=i+1;j<hlen;j++) {
    			max = Math.max(max,Math.min(height[i],height[j])*(j-i));
    		}
    	}
		return max;
        
    }
    /**
     * 第二种
     * 从最左最右两侧开始找最大值，每次最左或最由向另一侧移动，
     * 如 如果a[left]<a[right]，则left++，因为者才有可能让矩形面积的值变大
     * 时间复杂度n
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
    	int left = 0,right=height.length-1,max=0;
    	while(left<right) {
    		max = Math.max(max, Math.min(height[left], height[right])*(right-left));
    		if(height[left]<height[right]) {
    			left++;
    		}else {
    			right--;
    		}
    	}
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

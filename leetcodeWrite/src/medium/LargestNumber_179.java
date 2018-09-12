package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 179. 最大数
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例 2:

输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * @author liang
 *
 */
public class LargestNumber_179 {

	/**
	 * 直接将两个数进行拼接，比较是s1+s2大还是s2+s1大
	 * @param nums
	 * @return
	 */
    public static String largestNumber(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();//用来在List排序
        for(int i=0;i<length;i++) {
        	list.add(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        //对list排序,结果就是组合在一起为最大值
        Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int tmpVar1 = o1,tmpVar2 = o2;//用来之后保存两数先后位相加后的结果
				int var1 = o1,var2 = o2;
				
				while(true) {//找出o2的长度，对应让o1扩大那么多长度
					var2/=10;
					tmpVar1*=10;
					if(var2 == 0)
						break;
				}
				tmpVar1+=o2;//扩大后加在后位
				
				while(true) {
					var1/=10;
					tmpVar2*=10;
					if(var1 == 0)
						break;
				}
				tmpVar2+=o1;
				
				return tmpVar1-tmpVar2;
			}
        	
        });
        
        if((int)list.get(length-1)==0)//说明nums为空
        	return "0";
        for(int i=length-1;i>=0;i--) {
        	sb.append(list.get(i));
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,30,34,5,9};
		System.out.println(largestNumber(nums));
	}

}

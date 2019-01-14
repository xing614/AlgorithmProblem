package medium;
/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。

示例 1 :

输入: 2736
输出: 7236
解释: 交换数字2和数字7。
示例 2 :

输入: 9973
输出: 9973
解释: 不需要交换。
注意:

给定数字的范围是 [0, 108]
 * @author liang
 *
 */
public class MaximumSwap_670 {

	/**
	 * 方法1：使用Int[10]保存num中数字 0 ~ 9 的最后出现位置，从左到右遍历num的数字，对于每个位置，查找是否在之后的位置中存在一个比它更大的数（从 9 一直找到当前位置的数字大小）。也需要确保 这个更大的数字的位置 是 位于当前位置 之后的。如果找到了，交换这两个数字的位置，返回结果。
	 * @param num
	 * @return
	 */
    public int maximumSwap(int num) {
        char[] charArray = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for(int i=0;i<charArray.length;i++) {
        	buckets[charArray[i]-'0'] = i;//保存到buckets,只是每个数字最后出现的次数
        }
        for(int i=0;i<charArray.length;i++) {//从最高位开始
        	for(int k=9;k>charArray[i]-'0';k--) {// k需要比数字charArray[i]大
        		if(buckets[k]>i) {//说明i后面存在比charArray[i]大的数
        			char tmp = charArray[i];
        			charArray[i] = charArray[buckets[k]];
        			charArray[buckets[k]] = tmp;
        			return Integer.valueOf(new String(charArray));
        		}
        	}
        }
        return num;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

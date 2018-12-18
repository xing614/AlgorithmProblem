package medium;
/**
 * 477. 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

计算一个数组中，任意两个数之间汉明距离的总和。

示例:

输入: 4, 14, 2

输出: 6

解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
注意:

数组中元素的范围为从 0到 10^9。
数组的长度不超过 10^4。
 * @author liang
 *
 */
public class TotalHammingDistance_477 {

	/**
	 * int长度32bit，
	 * 一共n个数，如果某一位上有k个数为1，则有n-k个数为0
	 * 那么这个位置贡献的总汉明距离是k(n-k)
	 * 
	 * 0x开头在java中表示16进制数， 0开头的话代表是8进制数,此处也可直接写1
	 * @param nums
	 * @return
	 */
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int i = 0;i<32;i++) {
        	int counter = 0;
        	for(int j =0;j<n;j++) {
        		//得到k
        		counter+=(nums[j]>>i) & 0x01;//意思是，nums[j]数先右移i位，然后与1与，即只得到第i位数是0还是1
        	}
        	total+=counter*(n-counter);
        }
        return total;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

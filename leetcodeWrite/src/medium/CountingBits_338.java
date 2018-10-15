package medium;
/**
 * 338.比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
 * @author liang
 *
 */
public class CountingBits_338 {

	/**
	 * 对于2^N的数，末尾N-1位的重复规律，正好等于前N-1个数的重复规律，而这时只需要加1即可。
	 * @param num
	 * @return
	 */
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        
        int base = 1;//末尾为1的情况
        while(base<=num) {
        	int next = base *2;//下一个末尾全为0的值     1，2，4，8
        	for(int i=base;i<next && i<=num;i++) {//从base到next 规律
        		res[i] = res[i-base] +1;//看规律，重复前一半数据的1的个数 然后+1（第一位）
        	}
        	base = next;//然后从下一个末位0的位置开始
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package medium;
/**
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299
说明: N 是在 [0, 10^9] 范围内的一个整数。
 * @author liang
 *
 */
public class MonotoneIncreasingDigits_738 {

	/**
	 * 从第一位数开始，如果前一位数大于后一位数，则前一位数--，后面所有位数设为9，然后重新判断符合递增条件
	 * @param N
	 * @return
	 */
    public int monotoneIncreasingDigits(int N) {
        int res;
        int len = getNumLen(N);
        int[] num = new int[len];
        num = intToArray(N,len);
        find(num);
        res = arrayToInt(num,len);
        return res;
    }
    
    //找递增最大值
    private void find(int[] num) {
		// TODO Auto-generated method stub
		for(int i=0;i<num.length-1;i++) {
			if(num[i]>num[i+1]) {//不符合递增规则
				num[i]--;
				num=set9(num,i+1);//从i+1位开始都置为9
				find(num);//在从头遍历
			}
		}
	}


	private int[] set9(int[] num, int start) {
		// TODO Auto-generated method stub
		for(int i = start;i<num.length;i++) {
			num[i] = 9;
			
		}
		return num;
	}

	private int arrayToInt(int[] num, int len) {
		// TODO Auto-generated method stub
    	int n = 0;
    	int bit = 1;
    	for(int i=len-1;i>=0;i--) {
    		n+=num[i]*bit;
    		bit*=10;
    	}
		return n;
	}
	//将数字变为数组格式
    private int[] intToArray(int n, int len) {
		// TODO Auto-generated method stub
    	int[] num = new int[len];
    	for(int i = len-1;i>=0;i--) {
    		num[i] = n%10;
    		n/=10;
    	}
		return num;
	}
	//过去数字长度
	private int getNumLen(int n) {
		// TODO Auto-generated method stub
		int res = 1;
		while(n/10>0) {
			res++;
			n/=10;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

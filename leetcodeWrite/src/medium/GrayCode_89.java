package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。

示例 1:

输入: 2
输出: [0,1,3,2]
解释:
00 - 0
01 - 1
11 - 3
10 - 2

对于给定的 n，其格雷编码序列并不唯一。
例如，[0,2,3,1] 也是一个有效的格雷编码序列。

00 - 0
10 - 2
11 - 3
01 - 1
示例 2:

输入: 0
输出: [0]
解释: 我们定义格雷编码序列必须以 0 开头。
     给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
     因此，当 n = 0 时，其格雷编码序列为 [0]。
 * @author liang
 *
 */
public class GrayCode_89 {

	/**
	 * 总共用2^n个可能
	 * 给出一个整数，要求求出格雷码。格雷码(Gray Code)是一个数列集合，每个数使用二进位来表示，
	 * 假设使用n位元来表示每个数字，任两个数之间只有一个位元值不同。
	 * 例如以下为3位元的格雷码： 000 001 011 010 110 111 101 100 。
	 * 如果要产生n位元的格雷码，那么格雷码的个数为2^n. 
	 * 观察可以发现格雷码除了第一位外 格雷码是上下对称的，比如第一个格雷码与最后一个格雷码对称（除了第一位），第二个格雷码与倒数第二个对称，以此类推。
	 * 
	 * 所以，在实现的时候，我们完全可以利用递归，在每一层前面加上0或者1，然后就可以列出所有的格雷码。
	 * 比如：
	 * 第一步：产生 0, 1 两个字符串。
	 * 第二步：在第一步的基础上，每一个字符串都加上0和1，但是每次只能加一个，所以得做两次。这样就变成了 00,01,11,10 （注意对称）。
	 * 第三步：在第二步的基础上，再给每个字符串都加上0和1，同样，每次只能加一个，这样就变成了 000,001,011,010,110,111,101,100。
	 * 好了，这样就把3位元格雷码生成好了。
	 * 如果要生成4位元格雷码，我们只需要在3位元格雷码上再加一层0,1就可以了： 0000,0001,0011,0010,0110,0111,0101,0100,1100,1101,1110,1010,0111,1001,1000.
	 * 
	 * 也就是说，n位元格雷码是基于n-1位元格雷码产生的。
	 * 因为这里最后需要的是整数，对于每一次在前面加0，值不变；加一则需要加上1*2^(当前数的位数-1)
	 * @param n
	 * @return
	 */
    public List<Integer> grayCode(int n) {
    	 List<Integer> list = new ArrayList<Integer>();
    	 if (n == 0) {
             list.add(0);
             return list;
         }
    	 if (n == 1) {
             list.add(0);
             list.add(1);
             return list;
         }
    	 int[] res = produce(n);
    	 for(int i=0;i<res.length;i++) {
    		 list.add(res[i]);
    	 }
    	 return list;
    }
    
	private int[] produce(int n) {
		int[] strArr=new int[(int) Math.pow(2, n)];
        if(n==1){
            strArr[0]=0;
            strArr[1]=1;
            return strArr;
        }
        int[] lastStrings=produce(n-1);     //当前n的格雷码 从 n-1的格雷码中产生
        for(int i=0;i<lastStrings.length;i++){
            strArr[i]=lastStrings[i];//从0到n/2
            strArr[strArr.length-1-i]=(1<<(n-1))+lastStrings[i];//从n到n/2
        }
        return strArr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

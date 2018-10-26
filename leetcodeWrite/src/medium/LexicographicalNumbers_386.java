package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 386. 字典序排数
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。

例如，

给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。

请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * @author liang
 *
 */
public class LexicographicalNumbers_386 {
	/**
	 * 词典顺序就是10比2靠前，101比11靠前，110比11靠后，你可以简单的尝试一下把数字都转换成字符串数组，然后对字符串数组进行 Arrays.sort()，就会得到字符串下词典顺序的数字。但是这个方法因为用了排序，是会超时的。
	 * 
	 * 1、如果一个数乘以十以后没有超过n，那它后面紧挨着的应该是它的十倍，比如1,10,100。 
	 * 2、如果不满足1，那就应该是直接加一，比如n为13的时候，前一个数为12，120超过了n，那接着的应该是13。但是这里要注意如果前一个数的个位已经是9或者是它就是n了，那就不能加一了，比如 n = 25，前一个数为19，下一个数应该为2而不是19+1=20。25的下一个也没有26了。 
	 * 3、如果不满足2，比如19后面应该接2而不是20，这时候应该将19除以10再加一，比如n=500，399的下一个应该是4，那就是除以十，个位还是9，继续除以10，得到3，加一得到4。
	 * 将上面的过程整理成代码就可以了，循环的次数就是n，也就是总个数。
	 * @param n
	 * @return
	 */
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        for(int i = 1;i<=n;i++) {
        	res.add(cur);
        	if(cur*10<=n) {//第一步，乘以10
        		cur = cur*10;
        	}else if(cur % 10 !=9 && cur+1<=n) {//第二步，+1不到头
        		cur++;
        	}else {
        		while((cur/10) % 10 == 9) {//说明退一位后末位为9，这时候如果+1就要进位，就接着退一位,例如是199最后就变成19
        			cur = cur/10;
        		}
        		System.out.println("前+"+cur);
        		cur = cur/10 + 1;
        		System.out.println("后+"+cur);
        	}
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lexicalOrder(103);
	}

}

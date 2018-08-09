package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"
 * @author liang
 *
 */
public class PermutationSequence {
	
	/**
	 * 规律：
	 * 考虑一个特殊情况，当n=4时，序列为[1,2,3,4]，有以下几种情况： 
	 *  “1+(2,3,4)的全排列” 
  	 *	“2+(1,3,4)的全排列” 
  	 *	“3+(1,2,4)的全排列” 
  	 *	“4+(1,2,3)的全排列” 
	 * 如果k = 14,
	 * 这里取k=13(因为从0开始计数),n=4 则 k/(n-1)! = 13/6 = 2,说明排列经过了1+和2+两轮，14在“3+(1,2,4)的全排列” 中，所以第一个数为3,然后下一轮k=k%(n-1)!=13%6=1
	 * 第二个数  这时n=3(选定了一个数了) k/(n-1)! = 1/2 = 0，在序列[1,2,4] 说明第二个数是1，然后下一轮k=k%(n-1)!=1%2=1
	 * 第三个数  这时n=2  k/(n-1)!=1/1 = 1 在序列[2,4]中，索引为0的数是4，然后下一轮k=0
	 * 第四个数就是  2
	 * 最终结果 3142
	 * 1. 创建一个长度为n 的数组array，存放对应下标n的阶乘值。 
 	 * 2. 再新建一个长度为n 的数组nums，初始值为nums[i]=i+1，用来存放待选的字符序列。 
  	 * 3. 将得到的k减1后，开始迭代。迭代的规则是：迭代n次，每次选nums数组中下标为k/(n-1)!的数放在字符串的末尾，新的k=k%(n-1)!，新的n=n-1。 
 	 * 4. 最后，返回得到的字符串。 	 * 
	 * 
	 * 另一种想法：k/n=14/4=2  k=k%n=2  如果第二个数>0,说明当前处在第一个数+1轮， 即处在第三轮轮 第一个数 =3 
	 * [1,2,4] k/(n-1)=2/3=0 k=2%3=2  =0说明当前轮没出去，第二个数=1  
	 * [2,4]   k/(n-2)=2/2=1  k=2%2=0   =1说明走满一轮，=0说明刚好走慢，所以选最大的数  第三个数=4
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
    public static String getPermutation(int n, int k) {
    	StringBuffer sb =  new StringBuffer();
    	int[] array = new int[n+1];
    	int sum = 1;
    	array[0] = 1;
    	//array用于保存每个n! 1 1 2 6 24
    	for(int i=1;i<=n;i++) {
    		sum *= i;
    		array[i] = sum;
    	}
    	//保证下角标中对应数是123456
    	List<Integer> nums = new LinkedList<>();
    	for(int i =0;i<n;i++) {
    		nums.add(i+1);
    	}
    	
    	k--;
    	for(int i=1;i<=n;i++) {
    		int index = k/array[n-i];
    		sb.append(""+nums.get(index));
    		nums.remove(index);
    		k =k%array[n-i];
    	}
    	
		return sb.toString();
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4,14));
	}

}

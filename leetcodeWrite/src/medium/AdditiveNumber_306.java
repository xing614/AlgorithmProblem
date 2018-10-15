package medium;
/**
 * 306. 累加数
累加数是一个字符串，组成它的数字可以形成累加序列。

一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。

给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。

说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

示例 1:

输入: "112358"
输出: true 
解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
示例 2:

输入: "199100199"
输出: true 
解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
进阶:
你如何处理一个溢出的过大的整数输入?
 * @author liang
 *
 */
public class AdditiveNumber_306 {

	/**
	 * 循环判断
	 * @param num
	 * @return
	 */
    public static  boolean isAdditiveNumber(String num) {
    	//i和j用来分割第一位数和第二位数
        for(int i = 1;i<=num.length()/2;i++)
        	for(int j = 1;j+i<num.length();j++)
        		if(isValid(num,num.substring(0, i),num.substring(i,i+j),i+j))
        			return true;
        return false;	
    }
    /**
     * 判断是否符合
     * @param num
     * @param first
     * @param second
     * @param index
     * @return
     */
    public static boolean isValid(String num,String first,String second,int index) {
    	//数字第一位为0
    	if(first.length()>1 && first.startsWith("0") ||
    			(second.length()>1 && second.startsWith("0"))) {
    		return false;
    	}
    	if(index == num.length())
    		return true;
    	long sum = Long.parseLong(first) +Long.parseLong(second);//两数和
    	//从index位数开始为sum
    	if(num.startsWith(sum+"",index)) {
    		System.out.println(sum);
    		//后面依次判断
    		if(isValid(num,second,sum+"",index+(sum+"").length()))
    			return true;
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(AdditiveNumber_306.isAdditiveNumber("12358"));
		
	}

}

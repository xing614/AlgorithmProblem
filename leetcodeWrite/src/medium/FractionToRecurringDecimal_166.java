package medium;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 166. 分数到小数
题目描述提示帮助提交记录社区讨论阅读解答
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:

输入: numerator = 1, denominator = 2
输出: "0.5"
示例 2:

输入: numerator = 2, denominator = 1
输出: "2"
示例 3:

输入: numerator = 2, denominator = 3
输出: "0.(6)"
 * @author liang
 *
 */
public class FractionToRecurringDecimal_166 {

	/**
	 * 如何循环求数：每次都作除，然后取整数部分，然后余数*10，继续下去。
	 * 如何判断重复：存一个hashmap，key就是出现的除数，然后value就是结果数组的index值。只要包含该key时，就可以停止了。 
	 * 如何结束循环：只要包含有key或者除数为0时就可以停止
	 * 会不会溢出：对待溢出最简单的解决方案是将其转换为更大的类型
	 * @param numerator
	 * @param denominator
	 * @return
	 */
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long,Integer> hm = new HashMap<>();//判断是否重复元素
        List<Long> number  = new ArrayList<>();
        int index = 0;//当前位
        int beginIndex = -1;//开始重复位
        
        StringBuffer sb = new StringBuffer();//用于返回结果
        if(denominator == 0) {//除数是0
        	return "";
        }
        long num = numerator;
        long denum = denominator;
        
        if((num<0 && denum>0) ||(num>0 && denum<0)) {//两数正负
        	sb.append('-');
        }
        
        num = Math.abs(num);//绝对值
        denum = Math.abs(denum);
        
        long var = num/denum;//整数部分
        sb.append(String.valueOf(var));
        num = (num%denum)*10;//取余后扩大10倍，原小数部分
        while(num!=0) {
        	if(hm.containsKey(num)) {//开始重复
        		beginIndex = hm.get(num);//重复位置标志位
        		break;
        	}else {
        		hm.put(num, index);
        		index++;//标志位前进
        		var = num/denum;
        		num = (num%denum)*10;//接着计算
        		number.add(var);//结果的小数部分
        	}
        }
        for(int i = 0;i<index;i++) {
        	if(i == 0) {
        		sb.append('.');//整数后的第一位是.
        	}
        	if(i == beginIndex) {//后面要开始循环了
        		sb.append('(');
        	}
        	sb.append(number.get(i));//中间部分直接添加小数
        }
        if(beginIndex!=-1) {
        	sb.append(')');
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

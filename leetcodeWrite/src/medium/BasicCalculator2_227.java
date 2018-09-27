package medium;

import java.util.Stack;

/**
 * 227. 基本计算器 II
实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

 * @author liang
 *
 */
public class BasicCalculator2_227 {

	/**
	 * 使用栈
	 * 栈内存的是所有的中间结果，最后把站内数据加起来，就是最终结果
	 * @param s
	 * @return
	 */
    public int calculate(String s) {
    	int len = s.length();
        if(s == null || len == 0) {
        	return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';//记录本次数字之前的上一个运算符
        for(int i=0;i<len;i++) {
        	if(Character.isDigit(s.charAt(i))) {//当前位置是数字
        		num = num*10 + s.charAt(i) - '0';//得到这个连贯的数
        	}
        	//先乘除后加减。这里到达了下一个运算符了 ，计算上一个运算符
        	if((!Character.isDigit(s.charAt(i)) && ' '!=s.charAt(i)) 
        			|| i==len-1) {// 到达字符串结束处，需要计算最后一次结果
        		//乘除计算，从栈中弹出一个数字计算结果，再压入栈
        		if(sign == '*') {
        			stack.push(stack.pop() *num);
        		}
        		if(sign == '/') {
        			stack.push(stack.pop() /num);
        		}
        		if(sign == '+') {
        			stack.push(+num);
        		}
        		if(sign == '-') {
        			stack.push(-num);
        		}
        		sign = s.charAt(i);
        		num = 0;//置零
        	}
        }
        int res = 0;
        for(int i:stack) {//stack最后保留的是类似 1 -2 3 -4这样的数字
        	res +=i;
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

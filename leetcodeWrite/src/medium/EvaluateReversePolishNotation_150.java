package medium;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
根据逆波兰表示法，求表达式的值。

有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

说明：

整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：

输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: ((2 + 1) * 3) = 9
示例 2：

输入: ["4", "13", "5", "/", "+"]
输出: 6
解释: (4 + (13 / 5)) = 6
示例 3：

输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
输出: 22
解释: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 * @author liang
 *
 */
public class EvaluateReversePolishNotation_150 {


	/**
	 * 使用栈
	 * @param tokens
	 * @return
	 */
    public int evalRPN(String[] tokens) {
    	if (tokens == null || tokens.length < 1) {
    		return 0;
    	}
    	int op1;
        int op2;
        // 操作数栈
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens) {
        	//如果是运算符，则把栈顶两个元素操作
        	if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
        		//取出栈顶元素
        		op2 = stack.pop();
        		op1 = stack.pop();
        		//进行运算
        		switch(token.charAt(0)) {
        			 case '+':
        				 op1+=op2;
        				 break;
					 case '-':
					     op1 -= op2;
					     break;
					 case '*':
					     op1 *= op2;
					     break;
					 case '/':
					     op1 /= op2;
					     break;
        		}
        		//入栈
        		stack.push(op1);
        	}else {//是操作数，就入栈
        		stack.push(Integer.parseInt(token));
        	}
        }
        return stack.pop();//返回栈顶结果
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

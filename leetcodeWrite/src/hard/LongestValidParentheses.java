package hard;

import java.util.Stack;

/**
 * 32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 * @author liang
 *
 */
public class LongestValidParentheses {
	/**
	 * 使用栈，栈中保存的不是‘(’而是‘(’所在的index，
	 * 每次来了‘(’之后，无条件压栈。
	 * 如果碰到')'的话，如果栈不为空，就消除栈内剩余的'('
	 * 
	 * 1.消除掉'('之后，如果栈内还有剩余的‘(’的话，最长的合法长度就是：maxLength=Math.max(i-(int)stack.peek(), maxLength);  
	 * 也就是取：当前')'的index减去栈顶元素的index  和   原来max_length 两者的最大值。
	 * 
	 * 2.消除掉')'之后，栈内没有剩余的‘(’了。此时需要引入一个新的变量start，用于表示合法括号字符串的起点
	 * 例如：对于这种情况：())()()，可以正确的得出最大值为4。
	 * 
	 * start初始为-1，之后每次碰到‘)’且栈为空的时候更新为当前‘)’的index。
	 * 也就是说无法消除的)之后的括号不可能再和前面的括号合并在一起计算最长序列，所以更新start。
	 * @param s
	 * @return
	 */
    public int longestValidParentheses(String s) {
        if(s.length() == 0 || s == null) return 0;
        Stack st = new Stack();
        int start = -1;
        int maxLength = 0;
        for(int i =0;i<s.length();i++) {
        	if(s.charAt(i) == '(') {
        		st.push(i);
        	}else {
        		if(!st.empty()) {
        			st.pop();
        			if(st.empty()) {
        				maxLength = Math.max(i-start, maxLength);
        			}else {
            			maxLength = Math.max(i-(int)st.peek(), maxLength);
        			}
        		}else {//碰到）且不为空，说明无法在消除）之后的括号，所以不能合并在一起计算最长序列，所以更新start。
        			start = i;
        		}
        	}
        }
        return maxLength;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

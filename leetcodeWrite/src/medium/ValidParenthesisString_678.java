package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 678.有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

任何左括号 ( 必须有相应的右括号 )。
任何右括号 ) 必须有相应的左括号 ( 。
左括号 ( 必须在对应的右括号之前 )。
* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
一个空字符串也被视为有效字符串。
示例 1:

输入: "()"
输出: True
示例 2:

输入: "(*)"
输出: True
示例 3:

输入: "(*))"
输出: True
注意:

字符串大小将在 [1，100] 范围内。
 * @author liang
 *
 */
public class ValidParenthesisString_678 {

	/**
	 * 使用栈+队列，栈保存 左括号 坐标，如果出现右括号 栈就弹出一个；队列保存*的坐标。遍历一遍后看stack是否还有数据，还有就和队列判断匹配
	 * @param s
	 * @return
	 */
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();//保存左括号坐标
        LinkedList<Integer> queue = new LinkedList<>();//保存*坐标
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i) == '*')
        		queue.add(i);
        	else if(s.charAt(i) == '(')
        		stack.add(i);
        	else {//右括号情况
        		if(stack.size()>0)
        			stack.pop();//弹出第一个坐标，即 （）抵消了
        		else {//栈没有左括号，要用*抵消
        			if(queue.size() == 0)
        				return false;
        			queue.remove();//抵消一个*
        		}
        	}
        }
        int count = 0;
        while(stack.size()>0) {//解决未抵消的左括号
        	while(queue.size()>0 && stack.peek()<queue.peekLast()) {//队列不空，且栈顶元素坐标小于队列最后一个元素坐标
        		queue.removeLast();
        		count++;
        	}
        	stack.pop();//弹出
        	count--;
        	if(count<0)
        		return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

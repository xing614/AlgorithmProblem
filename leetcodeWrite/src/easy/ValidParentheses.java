package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 * @author liang
 *
 */
public class ValidParentheses {

	/**
	 * 使用栈，如果要压入的字符是左符号，就直接放入；如果是右符号，就判断前一个是否是对应的左符号，不是就false，是就把最后一个左符号和这个右符号都推出栈
	 * @param s
	 * @return
	 */
    public static boolean isValid(String s) {
    	Map<Character, Character> hm = new HashMap<Character, Character>();
    	hm.put(')', '(');
    	hm.put(']', '[');
    	hm.put('}', '{');
    	Stack<Character> st = new Stack<Character>();
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)!=')' && s.charAt(i)!=']' && s.charAt(i)!='}') {//左符合直接Push进去
    			st.push(s.charAt(i));
    		}else {//右符号
    			if(!st.empty() && hm.get(s.charAt(i)) == st.peek()) {//st不为空，且最后一个字符和要压入的字符匹配
    				st.pop();//推出
    			}else {
    				return false;
    			}
    		}
    	}
    	return st.empty();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()"));
	}

}

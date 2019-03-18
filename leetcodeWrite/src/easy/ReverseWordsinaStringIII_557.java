package easy;

import java.util.Stack;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @author liang
 *
 */
public class ReverseWordsinaStringIII_557 {

	/**
	 * 使用栈,后进先出代替翻转，一个单词翻转后 sb插入一个空格
	 * @param s
	 * @return
	 */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> word = new Stack<>();
        for(int i=0,j=0;i<s.length() || j<s.length();) {
        	if(i!=s.length() && s.charAt(i)!=' ') {//不是空格就加进去
        		word.push(s.charAt(i));
        		i++;
        	}else {
        		if(j<i) {//把当前栈内有的元素都放入sb中
        			sb.append(word.pop());
        			j++;
        		}else {
        			sb.append(' ');//加入单词间的空格
        			j=j+1;
        			i=i+1;
        		}
        		
        	}
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

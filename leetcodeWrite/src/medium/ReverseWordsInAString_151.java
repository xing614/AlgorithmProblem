package medium;

import java.util.Stack;

/**
 * 151. 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。

示例:  

输入: "the sky is blue",
输出: "blue is sky the".
说明:

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
进阶: 请选用C语言的用户尝试使用 O(1) 空间复杂度的原地解法。
 * @author liang
 *
 */
public class ReverseWordsInAString_151 {

	/**
	 * 方法一 \s表示空格，+表示至少一个空格，这样就可以将多个空格分隔的word提取出来了
	 * 使用正则表达式
	 * @param s
	 * @return
	 */
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");//  \\s表示 空格,回车,换行等空白符 +表示一个或多个
        StringBuffer sb = new StringBuffer();
        for(int i= words.length-1;i>=0;--i) {
        	sb.append(words[i]+" ");
        }
        return sb.toString().trim();//去除字符串的首尾空格
    }
    /**
     * 方法二，
     * 借助一个堆栈，从前向后遍历字符串，遇到空，跳过，直到非空字符，拼接word，等再次遇到空时，得到一个word，加入堆栈，
     * 以此类推，直到遍历到s的最后一个字符为止。
     * 最后，将堆栈中的word依次输出
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        if(s == null || s.length() == 0)
            return s;
        int index = 0; //the pointer to traverse
        int len = s.length();
        Stack<String> stack = new Stack<String>(); //堆栈，先进后出，顺序存入单词，逆序输出
        StringBuilder sBuilder = new StringBuilder(); //记录每一个单词
        char[] characters = s.toCharArray();
        while(index<len) {
        	for(;index<len && characters[index] == ' ';++index);//跳过空格
    		for(;index<len && characters[index] != ' ';++index) {//拼接word
    			sBuilder.append(characters[index]);
    		}
    		if(sBuilder.length()>0) {//将字符组成一个串压入栈
    			stack.push(sBuilder.toString());//合成字符串 压栈
    			sBuilder.delete(0, sBuilder.length());//清空
    		}
        }
        sBuilder.delete(0, sBuilder.length());//清空
        while(!stack.isEmpty()) {//输出，空格分隔
        	sBuilder.append(stack.pop()+' ');
        }
        return sBuilder.toString().trim();
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

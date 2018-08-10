package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 电话号码的字母组合  
 * 看手机 九宫格  abc在2  edf在3 等。
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @author liang
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	
	/**
	 * 回溯法
	 * @param digits
	 * @return
	 */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length() == 0)
        	return list;
        backtracking("",digits,0,list);//回溯。第一个参数表示要输出的字符串，每次得到后放入第四个参数。第三个参数表示遍历到第几位了
        return list;
        
    }
    
	private void backtracking(String s, String digits, int flag, List<String> list) {
		// TODO Auto-generated method stub
		String[] strings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		if(flag>=digits.length()) {//表示已经遍历所有输入的数组，到达底部，该回溯了
			list.add(s);//结果添加到结果集
			return;
		}
		String chars = strings[digits.charAt(flag)-'0'];//表示看digits的第flag位是数字几，然后找到对应的string数组的字符串
		for(int i=0;i<chars.length();i++) {//遍历一个数字对应的所有字母
			backtracking(s+chars.charAt(i),digits,flag+1,list);//将当前字符加到s上并将flag+1循环下一个数字的字母
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digists = "bc";
	}

}

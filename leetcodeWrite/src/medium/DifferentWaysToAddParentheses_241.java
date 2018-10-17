package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

示例 1:

输入: "2-1-1"
输出: [0, 2]
解释: 
((2-1)-1) = 0 
(2-(1-1)) = 2
示例 2:

输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 * @author liang
 *
 */
public class DifferentWaysToAddParentheses_241 {

	private HashMap<String,List<Integer>> hm = new HashMap<String,List<Integer>>();
	
	/**
	 * 分治法+备忘录
	 * 分治算法的基本思想是将一个规模为N的问题分解为K个规模较小的子问题，这些子问题相互独立且与原问题性质相同，求出子问题的解，就可得到原问题的解。那么针对本题，以操作符为分界，将字符串分解为较小的两个子字符串，然后依次对两个子字符串进行同样的划分，直到字符串中只含有数字。再根据操作符对两端的数字进行相应的运算。
	 * 备忘录的自顶向下法，将子问题的计算结果保存下来，下次遇到同样的子问题就直接从备忘录中取出
	 * 新建一个 hashmap，将子字符串放入 hashmap 中，对应的计算结果放入 value 中
	 * @param input
	 * @return
	 */
    public List<Integer> diffWaysToCompute(String input) {
        if(hm.containsKey(input))//当前串在备忘录中有
        	return hm.get(input);
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<input.length();i++) {
        	char ch = input.charAt(i);
        	if(ch == '+' || ch == '-' || ch == '*') {
        		for(Integer l:diffWaysToCompute(input.substring(0, i)))
        			for(Integer r:diffWaysToCompute(input.substring(i+1,input.length())))
        				if(ch == '+') res.add(l+r);
        				else if(ch == '-') res.add(l-r);
        				else if(ch == '*') res.add(l*r);
        	}
        }
        if(res.size() == 0)
        	res.add(Integer.valueOf(input));
        hm.put(input, res);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

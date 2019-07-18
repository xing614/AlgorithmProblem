package medium;

import java.util.List;
import java.util.Stack;

/**
 * 385. 迷你语法分析器
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。

列表中的每个元素只可能是整数或整数嵌套列表

提示：你可以假定这些字符串都是格式良好的：

字符串非空
字符串不包含空格
字符串只包含数字0-9, [, - ,, ]
 

示例 1：

给定 s = "324",

你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 

示例 2：

给定 s = "[123,[456,[789]]]",

返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：

1. 一个 integer 包含值 123
2. 一个包含两个元素的嵌套列表：
    i.  一个 integer 包含值 456
    ii. 一个包含一个元素的嵌套列表
         a. 一个 integer 包含值 789
 * @author liang
 *
 */
public class MiniParser_385 {
	/**
	 * 用栈维护一个包含关系，类似于用栈维护带 '(' 的表达式
	 * 
	 * @param s
	 * @return
	 */
    public NestedInteger deserialize(String s) {
    	Stack<NestedInteger> stack = new Stack<NestedInteger>();
    	String tokenNum = "";
    	for(char c:s.toCharArray()) {
    		switch(c) {
    		case '['://[代表一个list
    			stack.push(new NestedInteger());
    			break;
    		case ']'://list结尾
    			if(!tokenNum.equals(""))//前面token为数字
    				stack.peek().add(new NestedInteger(Integer.parseInt(tokenNum)));//将数字加入到本层list中
    			NestedInteger ni = stack.pop();//本层list结束
    			tokenNum ="";
    			if(!stack.isEmpty()) {//栈内有更高层次的list
    				stack.peek().add(ni);
    			}else {//栈为空，遍历到字符串结尾
					return ni;
				}
				break;
    		case ',':
				if (!tokenNum.equals("")) //将数字加入到本层list中
					stack.peek().add(new NestedInteger(Integer.parseInt(tokenNum)));
				tokenNum = "";
				break;
			default:
				tokenNum += c;
			}
    			
    	}
    	if (!tokenNum.equals(""))//特殊case: 如果字符串只包含数字的情况
			return new NestedInteger(Integer.parseInt(tokenNum));
		return null;
    	}

    }
    public interface NestedInteger {
      // Constructor initializes an empty nested list.
      public NestedInteger();
  
      // Constructor initializes a single integer.
      public NestedInteger(int value);

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

}


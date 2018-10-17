package medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 341.扁平化嵌套列表迭代器
 * 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。

列表中的项或者为一个整数，或者是另一个列表。

示例 1:

输入: [[1,1],2,[1,1]]
输出: [1,1,2,1,1]
解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
示例 2:

输入: [1,[4,[6]]]
输出: [1,4,6]
解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,4,6]。
 * @author liang
 *
 */
public class FlattenNestedListIterator_341  implements Iterator<Integer>{
	/**
	 * 先都塞到STACK里面，如果Peek的元素是单一int就返还TRUE，然后next()会直接返还那个int。
	 * 如果不是单一int，是另一个List，那么把这个List给POP出来，再倒着塞回到stack。
	 * 再PEEK第一个，直到是单一INT。
	 * 如果没元素了直接返还FALSE就行了
	 */
	public Stack<NestedInteger> stack = new Stack<>();
	
    public FlattenNestedListIterator_341(List<NestedInteger> nestedList) {
    	for(int n = nestedList.size()-1; n >=0;n--)
        {
            stack.push(nestedList.get(n));
        }
    }

    @Override
    public Integer next() {
    	if(hasNext())
    		return stack.pop().getInteger();//弹出
    	else
    		return null;
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
        	if(stack.peek().isInteger()) {//得到第一个值，判断是否是Int
        		return true;
        	}else {
        		//将list中数据放入stack
        		NestedInteger tempNested = stack.pop();
        		for(int n=tempNested.getList().size()-1;n>=0;n--) {
        			stack.push(tempNested.getList().get(n));
        		}
        	}
        }
        return false;
    }
    
    public interface NestedInteger {
   
       public boolean isInteger();
   
       public Integer getInteger();
   
       public List<NestedInteger> getList();
   }
}


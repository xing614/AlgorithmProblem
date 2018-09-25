package medium;

import java.util.Iterator;

/**
 * 284. 顶端迭代器
题目描述提示帮助提交记录社区讨论阅读解答
给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。

示例:

假设迭代器被初始化为列表 [1,2,3]。

调用 next() 返回 1，得到列表中的第一个元素。
现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
 * @author liang
 *
 */
public class PeekingIterator_284  implements Iterator<Integer>{

	/**
	 * 对于迭代器而言，没有peek的函数项，同样也没有添加的功能。
	 * 所以能够获取数据的唯一渠道就是通过next，但是一旦next之后，迭代器中的元素就会删掉一个，那如何保持被删掉的元素存活呢？
	 * 就是在属性中添加个值，来保持alive，同时使用isValid来验证该值是否还有效
	 */
	Iterator<Integer> it;
	int value;
	boolean isValid;
	
	public PeekingIterator_284(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
	    value = -1;
	    isValid = false;
	}

	/**
	 * 返回第一个元素但不删除
	 * @return
	 */
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(isValid) {//当前值有效就返回当前值
        	return value;
        }
        int val = it.next();
        value = val;
        isValid = true;
        return val;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(isValid) {//当前值有效就返回当前值，并设置无效
	    	isValid = false;
	    	return value;
	    }
	    return it.next();
	}

	@Override
	public boolean hasNext() {
	    if(isValid)
	    	return true;
	    return it.hasNext();
	}

}

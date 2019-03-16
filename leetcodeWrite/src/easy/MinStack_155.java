package easy;
/**
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 * @author liang
 *
 */
public class MinStack_155 {
	private int[] items;//数组当栈
	private int count;//栈中元素数
	private int size = 200;//默认栈中大小
	private int[] items_min;//辅助栈保存最小元素
	private int min_count;//辅助栈元素数
    public MinStack_155() {
        items = new int[size];
        items_min = new int[size];
        this.count = 0;
    }
    
    public void push(int x) {
        if(count == size || min_count == size)
        	return;
        if(min_count == 0 || items_min[min_count-1]>=x) {//这里是>= 如果多个最小值 则辅助栈++
        	items_min[min_count] = x;
        	++min_count;
        }
        items[count] = x;
        ++count;
    }
    
    public void pop() {
        if (count == 0 || min_count == 0) return;
        
        if (items[count - 1] == items_min[min_count - 1])
            --min_count;
        
        --count;
    }
    
    public int top() {
        if (count == 0 || min_count == 0) return -1;
        
        return items[count - 1];
    }
    
    public int getMin() {
        if(min_count == 0 )
        	return -1;
        return items_min[min_count-1];
    }
}

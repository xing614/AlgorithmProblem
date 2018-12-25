package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 636. 函数的独占时间
 * 给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。

每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。

日志是具有以下格式的字符串：function_id：start_or_end：timestamp。例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。

函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。你需要根据函数的 Id 有序地返回每个函数的独占时间。

示例 1:

输入:
n = 2
logs = 
["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]
输出:[3, 4]
说明：
函数 0 在时刻 0 开始，在执行了  2个时间单位结束于时刻 1。
现在函数 0 调用函数 1，函数 1 在时刻 2 开始，执行 4 个时间单位后结束于时刻 5。
函数 0 再次在时刻 6 开始执行，并在时刻 6 结束运行，从而执行了 1 个时间单位。
所以函数 0 总共的执行了 2 +1 =3 个时间单位，函数 1 总共执行了 4 个时间单位。
说明：

输入的日志会根据时间戳排序，而不是根据日志Id排序。
你的输出会根据函数Id排序，也就意味着你的输出数组中序号为 0 的元素相当于函数 0 的执行时间。
两个函数不会在同时开始或结束。
函数允许被递归调用，直到运行结束。
1 <= n <= 100
 * @author liang
 *
 */
public class ExclusiveTimeofFunctions_636 {

	/**
	 * 后进先出可以使用栈，使用一个int[]保存ID、timePoint、被占用时间 保存到Stack
	 * @param n
	 * @param logs
	 * @return
	 */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        //int[0]存:Id,int[1]存:timePoint,int[2]存:被别人占用的时间
        Stack<int[]> stack = new Stack<>();
        for(String st:logs) {
        	String[] lo = st.split(":");
        	int id = Integer.parseInt(lo[0]);
        	String type = lo[1];
        	int curTime = Integer.parseInt(lo[2]);
        	if(type.equals("start")) {
        		stack.push(new int[]{id,curTime,0});//初始
        	}else {
        		int[] the = stack.pop();//后进先出 栈弹出的第一个就是结束的那个
        		int useTime = curTime - the[1] +1 - the[2];
        		res[id]+=useTime;
        		//对于当前还在栈中的每个function,都被当前function占用了时间
        		ArrayList<int[]> list = new ArrayList<>();
        		while(!stack.isEmpty()) {
        			int[] tmp = stack.pop();
        			tmp[2] +=useTime;
        			list.add(tmp);
        		}
        		//后进先出，先插入最大范围的function
        		for(int i=list.size()-1;i>=0;i--) {
        			stack.push(list.get(i));
        		}
        		
        	}
        }
        return res;
    }
    
    /**
     * 拿到上一个log的 start/stop time 设为prev，再拿到当前 log 的 start/stop time ，计算出两个time之间的时间差
     * @param n
     * @param logs
     * @return
     */
    public int[] exclusiveTime2(int n, List<String> logs) {
    	Stack<Integer> stack = new Stack<>();//保存id
    	int[] res = new int[n];
    	String[] st = logs.get(0).split(":");
    	stack.push(Integer.parseInt(st[0]));
    	int i=1;//遍历
    	int prev = Integer.parseInt(st[2]);//前一个位置的时间点
    	while(i<logs.size()) {
    		st = logs.get(i).split(":");
    		if(st[1].equals("start")) {
    			if(!stack.isEmpty()) {
    				res[stack.peek()]+=Integer.parseInt(st[2])-prev;//当前位置是下一个起点，所以前一个id部分时间为st[2]-prev
    			}
    			stack.push(Integer.parseInt(st[0]));//压入当前位置id
    			prev = Integer.parseInt(st[2]);
    		}else {
    			res[stack.peek()]+=Integer.parseInt(st[2]) - prev + 1;//当前位置是结束点，所以-prev+1
    			stack.pop();//移除这个id
    			prev = Integer.parseInt(st[2]) + 1;//st[2]已经算作了该function的终点，不能再作为起点(起点肯定算)
    		}
    		i++;
    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

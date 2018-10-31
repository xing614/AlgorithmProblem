package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 433. 最小基因变化
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。

假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。

与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

注意:

起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
所有的目标基因序列必须是合法的。
假定起始基因序列与目标基因序列是不一样的。
示例 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

返回值: 1
示例 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

返回值: 2
示例 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

返回值: 3
 * @author liang
 *
 */
public class MinimumGeneticMutation_433 {

	/**
	 * 类似127题 用广度优先搜索查找最短路径。
	 * 利用queue遍历，每次将可能的下一个字符串放入队列
	 * 使用hashSet放未被遍历的元素，用过后移除
	 * @param start
	 * @param end
	 * @param bank
	 * @return
	 */
    public int minMutation(String start, String end, String[] bank) {
        if(bank == null || bank.length == 0)
        	return -1;
        char[] mess = {'A','C','G','T'};
        HashMap<String,Integer> res = new HashMap<>();//返回结果使用 key是使用的字符串，value是第几个使用
        Queue<String> q = new LinkedList<>();//队列，用于保存遍历顺序
        HashSet bankhs = new HashSet();//用于存放未被使用的bank
        for(String bs:bank) {
        	bankhs.add(bs);
        }
        q.add(start);
        res.put(start, 0);
        while(!q.isEmpty()) {
        	String poll = q.poll();
        	bankhs.remove(poll);
        	for(int i=0;i<poll.length();i++) {
        		char[] charArray = poll.toCharArray();
        		for(char me:mess) {
        			charArray[i] = me;
        			String nextS = new String(charArray);
        			if(bankhs.contains(nextS)) {
        				res.put(nextS, res.get(poll)+1);
        				if(nextS.equals(end))
        					return res.get(nextS);
        				q.add(nextS);
        			}
        		}
        	}
        }
        return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package EightAlgorithms;
/**
 * KMP算法，用于解决从长串找子串问题，返回子串位置
 * 
 * @author liang
 *
 */
public class KMPAlgorithms {

	/**
	 * KMP核心思想：利用已经部分匹配这个有效信息，保持i指针不回溯，通过修改j指针，让模式串尽量地移动到有效的位置
	 * 每次j位置不匹配后，j要移动到的下一个位置k 存在特性：最前面的k个字符和j之前的最后k个字符是一样的。
	 * 例子T字符串   ABCABCDHIJK  这时i在C位置
	 * 例子P字符串   ABCABD		这时j在D位置
	 * 最前面的k个字符和j之前的最后k个字符是一样的-》 k=2  AB = AB  P[0~(k-1)]==P[(j-k)~(j-1)]
	 * 因为在P的每一个位置都可能发生不匹配,要计算每一个位置j对应的k，所以用一个数组next来保存，next[j] = k，表示当T[i] != P[j]时，j指针的下一个位置
	 * 另外 当P[k] == P[j]时，next[j+1] == next[j] + 1（即本身k和j的值相当，k-1和j-1指针都后移一位的情况下 0~k和 (j-k)~j字符串还是相同的，next对应可直接后移一位）
	 * 如果P[k] != P[j]，则k = next[k]，就是说j要先变成k 再往前变成了next[k]。如ABACDABABC 这时j=倒数第一个B，k=第一个C，jk数不一样，k就变为了第一个B位置 也就是k=next[k]
	 * 
	 * 再另外优化 当P[j] == P[next[j]]时，即本身j位置和T的i位置元素就不匹配，而j位置和它原本要的next[j]数据相同 还是和i位置不匹配 这时就改为next[j] = next[k]
	 * @param ts
	 * @param tp
	 * @return
	 */
	public static int kmp(String ts,String tp) {
		char[] t = ts.toCharArray();
		char[] p = tp.toCharArray();
		int i = 0;
		int j = 0;
		int[] next = getNext(tp);//获取next数组，就直接根据tp字符串自身的字符得到关联关系
		while(i<t.length && j<p.length) {
			if(j == -1 || t[i]==p[j]) {// 当两个字符相同，就比较下一个 (j=-1也就是Next[]=-1，就是子串指针回到初始位置了)
				i++;
				j++;
			}else {
				//i = i-j+1;//退后到i++位置  i不需要回溯了
				//j = 0;
				j = next[j];//j到指定位置
			}
		}
		if(j == p.length) {
			return i-j;
		}else {
			return -1;
		}
	}
	
	//对tp字符串 得到他要重新遍历时的j的新起点，
	private static int[] getNext(String tp) {
		// TODO Auto-generated method stub
		char[] p = tp.toCharArray();
	    int[] next = new int[p.length];
	    next[0] = -1;//初始为-1，
	    int j = 0;
	    int k = -1;
	    while (j < p.length - 1) {
	        if (k == -1 || p[j] == p[k]) {//两值相等
	            if (p[++j] == p[++k]) { // 当两个字符相等时要跳过。就是说的P[j] == P[next[j]]问题，j位置的next就在k位置的基础上再next[k]
	               next[j] = next[k];
	            } else {//不等就是k位置了
	               next[j] = k;
	            }
	        } else {
	            k = next[k];
	        }
	     }
	     return next;
	}

	//暴力破解，就是设置i j 两个指针分别指向ts和tp某个位置，判断是否一样，不一样就i倒退到最初的下一个位置，j变为0；否则 i++ j++
	public static int bf(String ts,String tp) {
		char[] t = ts.toCharArray();
		char[] p = tp.toCharArray();
		int i = 0;
		int j = 0;
		while(i<t.length && j<p.length) {
			if(t[i]==p[j]) {// 当两个字符相同，就比较下一个
				i++;
				j++;
			}else {
				i = i-j+1;//退后到i++位置
				j = 0;
			}
		}
		if(j == p.length) {
			return i-j;
		}else {
			return -1;
		}
	}
}

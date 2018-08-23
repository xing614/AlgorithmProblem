package hard;
/**
 * 76. 最小覆盖子串
给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * @author liang
 *
 */
public class MinimumWindowSubstring_76 {

	/**
	 * T中字符可能有重复,S包含T的条件：S中包含所有T中的字符；T中所有字符出现次数都不大于S中对应字符出现次数；
	 * 所以思路可以是：首先对T中出现的字符以及出现次数做统计，之后查找S中是否有对应字符，以及对应字符出现次数是否不小于T中出现次数。
	 * 数据结构：为了统计字符串中出现的字符以及次数，使用其ASCII码作为Hash表索引，利用一个长度为128的数组（英文字母ASCII码值不超过128）来存储出现字符，以及字符出现次数。例如如果字符'A'出现了3次，则统计数组c['A']=3（相当于c[65]=3，因为'A'的ASCII码是65）。
	 * 1.设置2个指针start和end，分别指向S中包含T的最小Window的开始和结束位置。
	 * 2.由于要找到包含T的最小Window，所以需要遍历整个字符串。又由于时间复杂度为O(n)，所以只能遍历一次。
	 * 3.为了比较S中字符出现次数与T中字符出现次数，用一个标志count来计数。count表示T的长度，当S中找到的字符次数都与T中字符次数对应相等，并且count等于T的长度，则可知找到了包含T的Window。
	 * 4.为了判断Window是否最小，用一个minwin来存储找到的Window。
	 * 
	 * 算法过程：1.遍历T，将T中字符出现次数存入数组ta[]；新建数组sa[]存储S中字符出现次数；
	 * 2.设置指针start和end，都指向S开始位置；
	 * 3.end向后遍历，若遇到的字符在ta[]中的值不为0（即T中存在的字符），
	 * 则有两种情况：一、sa[]中该字符值等于ta[]中该字符值，则说明该字符已经找够，不需要再找，则忽略该字符，继续遍历；
	 * 二、sa[]中该字符值小于ta[]中该字符值（sa[]中该字符值可能为0，即未出现过的字符），则说明该字符还未找全，将sa[]中该字符值加1，count加1，继续遍历。
	 * 若遇到的字符在ta[]中的值为0，忽略该字符，继续遍历；
	 * 4.当count值等于T的长度，则说明已经找到了T中所有元素，end暂停遍历；
	 * 此时关注start，在此时的start处或者start向后一段内，可能都是T中不存在的字符，但由于这些字符未计入count值，所以是否包含这些字符不影响判断条件；
	 * 但是为了找到最小的Window，需要start向后遍历，将T中不存在的字符都排除，找到T中存在的第一个字符位置，即找到了一个包含T的Window；
	 * 将此时的Window长度与minwin长度比较，若小于minwin长度，说明找到了更小的Window，更新minwin为当前找到的Window；
	 * 5.找到一个Window后end继续遍历。
	 * 每当end后移一步，就考察start处字符，若start处字符次数大于T中该字符次数，则start后移，若start处字符不存在T中，start也后移，直到找到包含T的最小Window，再进行记录。
	 * @param s
	 * @param t
	 * @return
	 */
    public String minWindow(String s, String t) {
    	//ta['I']表示字符串T中I字符出现的次数,sa表示字符串S中的
        int[] ta = new int[128];//使用ASCII码值不超过128，c['A']=3（相当于c[65]=3，因为'A'的ASCII码是65）
        int[] sa = new int[128];
        int min =Integer.MAX_VALUE;//当前选中的S子串的长度
        String minwin = "";//表示最小符合的子串
        for(int i=0;i<t.length();i++) {
        	ta[t.charAt(i)]++;//所有字符出现次数设置
        }
        int count = 0;//表示已经找到多少个符合T的字符，如果=t.length说明找完了
        int end = 0,start = 0;//窗口的两个指针
        while(end<s.length()) {
        	if(ta[s.charAt(end)]!=0) {//S字符串当前位置的字符在T中有
        		if(sa[s.charAt(end)]<ta[s.charAt(end)]) {//表示S字符串当前找到的符合的字符出现的次数不够
        			count++;
        		}
        		sa[s.charAt(end)]++;
        	}
        	if(count == t.length()) {//找够了T，该筛选和start移动了
        		//起始位置start的字符在T中没有，或者 起始位置的字符在当前minwin中出现的次数大于T串该字符出现的次数
        		while(ta[s.charAt(start)]==0 || sa[s.charAt(start)]>ta[s.charAt(start)]) {
        			if(sa[s.charAt(start)]>ta[s.charAt(start)]) {//该字符出现次数多
        				sa[s.charAt(start)]--;
        			}
        			start++;//右移
        		}
        		if(end-start+1<min) {
        			minwin = s.substring(start, end+1);//截取窗口
        			min = end-start+1;
        		}
        	}
        	end++;//右移
        }
        return  minwin;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

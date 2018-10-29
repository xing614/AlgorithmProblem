package medium;
/**
 * 424. 替换后的最长重复字符
 * 
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

注意:
字符串长度 和 k 不会超过 104。

示例 1:

输入:
s = "ABAB", k = 2

输出:
4

解释:
用两个'A'替换为两个'B',反之亦然。
示例 2:

输入:
s = "AABABBA", k = 1

输出:
4

解释:
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
 * @author liang
 *
 */
public class LongestRepeatingCharacterReplacement_424 {

	boolean isReadDigit;
	/**
	 * 使用滑动窗口做
	 * 1.设置窗口初始大小
	 * 2.在一个数组中记录这个窗口内每个字符出现的次数
	 * 3.预处理，在窗口内判断[0,0+窗口大小]这个范围内的字符串，如果符合 出现次数最大值+k>窗口尺寸，直接窗口大小++，循环，直到不符合。
	 * 4.移动窗口，while中每次for 窗口后面的长度，如果窗口-最长字符长度<=k，就表示他更长，如果更长就窗口长度+1
	 * 5.找最长字符长度函数，先设置窗口内各个字符出现的次数，找最大值；如果设置过了那就重新规划出移动后窗口个字符出现次数；找出出现最大值
	 * @param s
	 * @param k
	 * @return
	 */
    public int characterReplacement(String s, int k) {
        if(s.length() <=k)
        	return s.length();
        int minWin = (int)((double)k/25 * 26);//最小窗口长度.在k大于52的时候，最多字符数量肯定是大于1的。
        int windowSize = minWin > k+1 ? minWin :k+1;
        char[] arr = s.toCharArray();
        int[] digit = new int[26];//每个字符出现的次数
        for(int i=0;i<windowSize-1;i++) {
        	digit[arr[i]-'A']++;
        }
        //预处理
        while(windowSize <=s.length()) {
        	int Max = -1;
        	digit[arr[windowSize-1] - 'A']++;//添加当前位置
        	for(int i:digit) {
        		Max = Max>i?Max:i;
        	}
        	if(Max + k>=windowSize) {//说明窗口还能放大
        		windowSize++;
        	}else {
        		break;
        	}
        }
        
        //移动窗口
        while(windowSize<=s.length()) {
        	boolean isFindLongest = false;//标志位 判断是否有更长的，如果有就windowSize++
        	isReadDigit = false;//默认最开始 窗口内字符出现次数未更新
        	digit = new int[26];//重置
        	for(int i=0;i<=arr.length - windowSize;i++) {//窗口后面的长度
        		if(windowSize - findMaxDigit(i,windowSize,digit,arr)<=k) {
        			isFindLongest = true;
        			break;
        		}
        	}
        	if(isFindLongest) {
        		windowSize++;
        	}else {
        		break;
        	}
        }
        return windowSize-1;
    }
    //找到这个位置内最长长度
	private int findMaxDigit(int index, int windowSize, int[] digit, char[] arr) {
		// TODO Auto-generated method stub
		
		if(!isReadDigit) {//初始化
			for(int i=index;i<index+windowSize;i++) {
				digit[arr[i]-'A']++;
				isReadDigit = true;
			}
		}else {//更新
			digit[arr[index-1]-'A']--;//窗口前一个位置数字-1
			digit[arr[index+windowSize-1]-'A']++;//新入的位置数字+1
		}
		int Max = -1;
		for(int i:digit) {
			Max = Max>i?Max:i;
		}
		return Max;
	}
    

}

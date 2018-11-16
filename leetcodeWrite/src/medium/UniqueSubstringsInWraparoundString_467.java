package medium;
/**
 * 467. 环绕字符串中唯一的子字符串
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 

现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。 

注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。

 

示例 1:

输入: "a"
输出: 1
解释: 字符串 S 中只有一个"a"子字符。
 

示例 2:

输入: "cac"
输出: 2
解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 

示例 3:

输入: "zab"
输出: 6
解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
 * @author liang
 *
 */
public class UniqueSubstringsInWraparoundString_467 {

	/**
	 * 这道题是说给了一个字符串P，需要从其中找到所有出现在S中的子串。 
	 * 这里的S就是abcdedf..zabcde…这样无限迭代下去的一个串，也就是只要P的字符串一直递增就好（z->a进位）
	 * 所以解题方法也很直接： 
	 * 找出以’a-z’每个字符结尾的情况下，最长的子串有多长，然后将其相加就可以
	 * 
	 * 考虑为一个26进制的数的序列
	 * 使用dp的方式，找到以某个字符结尾的最长的有多少种可能
	 * 动态规划只考虑以固定字母结尾的最大长度，不需要考虑重复性（已经自动筛除），考虑所有的26个字母
	 * @param p
	 * @return
	 */
    public int findSubstringInWraproundString(String p) {
        int[] pInt = new int[p.length()];//将p的每个位置字符转变为数字，这样对26取余为0说明经历z->a
        int count[] = new int[26];//以某个字符为结尾的最长长度
        for(int i=0;i<p.length();i++) {
        	pInt[i] = p.charAt(i)-'a';
        }
        int res = 0;
        int maxLen = 0;
        for(int i=0;i<p.length();i++) {
        	//说明当前位置字符和它的前一个字符在26个字母上是前后顺序的
        	if(i>0 && (pInt[i-1] +1) %26 == pInt[i]) {
        		maxLen++;//则最长长度+1，其实就是说 从0~(i-1)有maxLen个可能，然后从0~i有maxLen+1可能，就是i自己是一种 i-1~i是第二种 i-2~i是第三种直到头不连续
        	}else {
        		maxLen = 1;
        	}
        	count[pInt[i]] = Math.max(count[pInt[i]], maxLen);//当前字母为结尾的最长的可能数
        }
        //
        for(int i=0;i<26;i++) {
        	res += count[i];
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

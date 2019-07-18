package medium;
/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。

示例 1:

输入: S = "aab"
输出: "aba"
示例 2:

输入: S = "aaab"
输出: ""
注意:

S 只包含小写字母并且长度在[1, 500]区间内。
 * @author liang
 *
 */
public class ReorganizeString_767 {

	/**
	 * 1.记录每个字符出现的次数 使用int[26] 位置就是每个字符-'a'。2记录出现次数最多的字符的次数 如果 max*2-1>len，则不能隔开。3.将字符串中的字符按照奇数偶数放在新建的char数组中。将相同的字符个数小于字符串长度的一半的字符放在奇数下标位置，否则放在偶数下标位置。注意这里需要判断奇数位置是否大于字符串长度
	 * @param S
	 * @return
	 */
    public String reorganizeString(String S) {
        int[] arr = new int[26];
        int len = S.length();
        char[] res = new char[len];
        if(len==1)
        	return S;
        int maxLen = 0;
        for(char ch:S.toCharArray()) {
        	if(maxLen<++arr[ch - 'a'])
        		maxLen = arr[ch-'a'];
        }
        if(maxLen*2-1>len)
        	return "";
        int odd = 0,even = 1;
        for(int i = 0;i<26;i++) {
        	while(arr[i]>0 && arr[i]<len/2+1 && even<len) {//放入奇数位置
        		res[even] = (char)(i+'a');
        		even+=2;
        		arr[i]--;
        	}
        	while(arr[i]>0) {//奇数位置放满了  该放偶数了
        		res[odd] = (char)(i+'a');
        		arr[i]--;
        		odd+=2;
        	}
        }
        return new String(res);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

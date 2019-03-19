package medium;

import java.util.Arrays;

/**
 * 556. 下一个更大元素 III
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。

示例 1:

输入: 12
输出: 21
示例 2:

输入: 21
输出: -1
 * @author liang
 *
 */
public class NextGreaterElementIII_556 {
	/**
	 * 意思是用n这个数的各个位的数重新排列组合，形成比n大的数
	 * 1、从右向左找第一个不符合升序的数，位置记为index，如果index为-1，返回-1
	 * 2、从右向index找第一个比他大的数，交换index位置的数和这个比他大的数
	 * 3、从index+1到末尾进行升序排列
	 * @param n
	 * @return
	 */
    public int nextGreaterElement(int n) {
        char[] chs = (n+"").toCharArray();
        int index = chs.length-2;
        while(index>=0) {
        	if(chs[index]>=chs[index+1]) {
        		index--;
        	}else
        		break;
        }
        if(index == -1) {
        	return -1;
        }else {
        	int j = chs.length-1;
        	while(chs[j]<=chs[index]) {
        		j--;
        	}
        	char tmp = chs[j];
        	chs[j] = chs[index];
        	chs[index] = tmp;
        	Arrays.sort(chs,index+1,chs.length);
        }
        long res = Long.parseLong(new String(chs));
        return res>Integer.MAX_VALUE? -1:(int)res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package medium;
/**
 * 372. 超级次方
 * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。

示例 1:

输入: a = 2, b = [3]
输出: 8
示例 2:

输入: a = 2, b = [1,0]
输出: 1024
 * @author liang
 *
 */
public class SuperPow_372 {

    public int superPow(int a, int[] b) {
        int ans = 1;
        a  = a % 1337;
        while(notZero(b)) {
        	if(b[b.length-1] %2 !=0)//如果当前b是奇数，通过ans = (ans * a) % c;来弥补多出来的这一项
        		ans = (ans *a) %1337;
        	div(b);
        	a = (a *a)%1337;
        }
        return ans;
    }
    
    public boolean notZero(int[] b) {
    	for(int i = b.length-1; i>=0;i--) {
    		if(b[i]>0)
    			return true;
    	}
    	return false;
    }
    
    public void div(int[] b) {
    	int tmp = 0;
    	for(int i=0;i<b.length;i++) {
    		b[i] +=tmp*10;
    		tmp = b[i]%2;
    		b[i] = b[i]/2;
    	}
    }
}

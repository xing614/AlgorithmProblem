package medium;
/**
 * 396. 旋转函数
 * 给定一个长度为 n 的整数数组 A 。

假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。

计算F(0), F(1), ..., F(n-1)中的最大值。

注意:
可以认为 n 的值小于 105。

示例:

A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 * @author liang
 *
 */
public class RotateFunction_396 {

	/**
	 * 直接求解。O(n^2)，会超时
	 * @param A
	 * @return
	 */
    public int maxRotateFunction(int[] A) {
        if(A.length == 0) {
        	return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0,k=0;i<A.length;i++,k++) {
        	int temp = 0;
        	for(int j=0;j<A.length;j++) {
        		temp += j * A[(j - k + A.length) % A.length];//加每一个位置 
        	}
        	max = (max<temp)?temp : max;
        }
        return max;
    }
    
    /**
     * 方法二：动态规划
     * F(0)与F(1)的区别，就是F(0)中除了A[n-1]之外，其他的数字都增加了一倍，并且还要再减去（n-1）*A[n-1]
     * 以例子：[0]就是增加了4，3，2，然后再减去了3*6，F[1] = F[0] + 4 + 3 + 2 - 3 * 6 = 16。
     * F[n] = F[n - 1] + (sum - A[sumIndex]) - (A.length - 1) * A[sumIndex] 
     * sumIndex = -n + A.length，即旋转时要从索引n-1移动到0的那个值
     * sum为数组A中所有值的和，
     * 而(sum - A[sumIndex]) 自然就是数组A中除了索引为sumIndex之外其他所有值的和。 
     * O(n)
     * @param A
     * @return
     */
    public int maxRotateFunction2(int[] A) {
    	int sum = 0;
    	//计算sum
    	for(int i=0;i<A.length;i++) {
    		sum += A[i];
    	}
    	int base = 0;
    	//计算F[0]
    	for(int i=0;i<A.length;i++) {
    		base += i * A[i];
    	}
    	
    	int max = base;
    	for(int i=1;i<A.length;i++) {
    		int sumIndex = -i + A.length;
    		base += sum - A.length * A[sumIndex];//f[x] = f[x-1] + sum - A[sumIndex]) - (A.length - 1) * A[sumIndex]
    		max = (max<base)?base :max;
    	}
    	return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package medium;
/**
 * 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？

如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。

你允许：

装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
示例1: (From the famous "Die Hard" example)

输入: x = 3, y = 5, z = 4
输出: True
示例2:

输入: x = 2, y = 6, z = 5
输出: False
 * @author liang
 *
 */
public class WaterAndJugProblem {

	/**
	 * 可以转化为一公式 z = m*x+n*y
	 * m，n为舀水和倒水的次数，正数表示往里舀水，负数表示往外倒水
	 * 通过裴蜀定理 再转化为 看z是不是x和y的最大公约数的倍数
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
    public boolean canMeasureWater(int x, int y, int z) {
		return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
        
    }
    
    /**
     * 最大公约数
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x,int y) {
    	return y == 0 ? x : gcd(y, x % y);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

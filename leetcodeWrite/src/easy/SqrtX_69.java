package easy;
/**
 * 69. x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
 * @author liang
 *
 */
public class SqrtX_69 {

	/**
	 * 二分搜索法，每次找中间数，平方看与x相等不 
	 * @param x
	 * @return
	 */
    public static int mySqrt(int x) {
        if(x==1)return 1;
        double low = 0;
        double high = x;
        while(low<high) {
        	double mid = (low+high)/2;
        	if(Math.abs(mid*mid-x)<0.01) {
        		return (int)mid;
        	}else if(mid*mid<x) {
        		low=mid;
        	}else {
        		high = mid;
        	}
        }
        return (int)low;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(801924993));
	}

}

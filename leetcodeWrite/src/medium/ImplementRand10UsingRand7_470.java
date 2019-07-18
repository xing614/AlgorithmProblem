package medium;
/**
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。

不要使用系统的 Math.random() 方法。

 

示例 1:

输入: 1
输出: [7]
示例 2:

输入: 2
输出: [8,4]
示例 3:

输入: 3
输出: [8,1,10]
 

提示:

rand7 已定义。
传入参数: n 表示 rand10 的调用次数。
 

进阶:

rand7()调用次数的 期望值 是多少 ?
你能否尽量少调用 rand7() ?
 * @author liang
 *
 */
public class ImplementRand10UsingRand7_470  extends SolBase{

	/**
	 * 7*（Rand7() - 1） = {0， 7， 14， 21， 28， 35， 42}，这7个数等概率
	 * 7*（Rand7() - 1） + Rand() - 1表示{0,1,2,3,4,5,6,......40, ... 48}，这49个数等概率
	 * 再将这49个数分为两部分， {0, 1, 2, ... , 39}和{40, 41, .., 48}，
	 * 如果生成的数处于第2部分，再将第二部分等概率分到第1部分，总概率 = 1/10
	 * @return
	 */
    public int rand10() {
    	int num = 0;
        while (true){
            num = 7*(rand7() - 1) + rand7() - 1;
            if (num < 40){
                return (num%10) + 1;
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

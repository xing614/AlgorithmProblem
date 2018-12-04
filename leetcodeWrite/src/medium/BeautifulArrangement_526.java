package medium;
/**
 * 526. 优美的排列
 * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

第 i 位的数字能被 i 整除
i 能被第 i 位上的数字整除
现在给定一个整数 N，请问可以构造多少个优美的排列？

示例1:

输入: 2
输出: 2
解释: 

第 1 个优美的排列是 [1, 2]:
  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除

第 2 个优美的排列是 [2, 1]:
  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
说明:

N 是一个正整数，并且不会超过15。
 * @author liang
 *
 */
public class BeautifulArrangement_526 {

	/**
	 * 递归回溯
	 * 从第一位到第N位，找到对应的没有放置过的数字放
	 * 从1位置开始  优美数组第一位是1
	 * @param N
	 * @return
	 */
    public int countArrangement(int N) {
        int[] num = new int[N];
        int res = find(num,1);
        return res;
    }
    
	private int find(int[] num, int index) {
		// TODO Auto-generated method stub
		if(index  == num.length+1)//说明这一组数组时完美数组
			return 1;
		int total = 0;
		for(int i=0;i<num.length;i++) {
			if(num[i]!=1) {
				if((i+1) % index ==0 ||index %(i+1) == 0) {//符合优美数组条件就递归下一个数
					int[] newNum = num.clone();//要克隆出新的数组
					newNum[i] = 1;
					total+=find(newNum,index+1);
				}
			}
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

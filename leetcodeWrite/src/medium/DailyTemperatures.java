package medium;
/**
 * 每日温度问题
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 * @author liang
 *
 */
public class DailyTemperatures {

	/**
	 * 暴力解法，循环判断
	 * @param temperatures
	 * @return
	 */
    public int[] dailyTemperatures(int[] temperatures) {
        int tlen = temperatures.length;
        int[] result = new int[tlen];
        for(int i=0;i<tlen;i++) {
        	for(int j=i+1;j<tlen;j++) {
        		if(temperatures[j]>temperatures[i]) {
        			result[i] = j-i;
        			break;
        		}
        	}
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package medium;
/**
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。

如果方程没有解，请返回“No solution”。

如果方程有无限解，则返回“Infinite solutions”。

如果方程中只有一个解，要保证返回值 x 是一个整数。

示例 1：

输入: "x+5-3+x=6+x-2"
输出: "x=2"
示例 2:

输入: "x=x"
输出: "Infinite solutions"
示例 3:

输入: "2x=x"
输出: "x=0"
示例 4:

输入: "2x+3x-6x=x+2"
输出: "x=-1"
示例 5:

输入: "x=x+2"
输出: "No solution"

 * @author liang
 *
 */
public class SolveTheEquation_640 {

	/**
	 * 用=分割左右两个部分，然后分别获取两部分的x系数和常数项，最后左右求解
	 * @param equation
	 * @return
	 */
    public String solveEquation(String equation) {
        String[] leftAndRight = equation.split("=");
        int[] left = helper(leftAndRight[0]);
        int[] right = helper(leftAndRight[1]);
        int x_xishu = left[0] - right[0];
        int changshu = right[1] - left[1];
        System.out.println(x_xishu);
        if(x_xishu == 0 && changshu != 0) {
        	return "No solution";
        }
        if(x_xishu == 0 && changshu == 0) {
        	return "Infinite solutions";
        }
        int num = changshu/x_xishu;
        return "x="+num;
    }
    
    /**
     * int[0]返回当前表达式中x的系数,int[1]返回当前表达式中的常数大小
     * @param string
     * @return
     */
	private int[] helper(String s) {
		// TODO Auto-generated method stub
		int begin = 0;
		int end = 1;
		char fuhao = '+';
		int x_xishu = 0;
		int changshu = 0;
		if(s.charAt(0) == '-') {
			fuhao = '-';
			begin = 1;
			end = 2;
		}
		while(end<=s.length()) {
			while(end<s.length() && s.charAt(end)!='+' && s.charAt(end)!='-') {
				end++;
			}
			String theS = s.substring(begin, end);
			if(theS.indexOf('x')!=-1) {//说明这个串里有x,则现在获取的是x的系数
				String xx = theS.substring(0,theS.indexOf('x'));
				int num  = 1;
				if(!xx.equals("")) {
					num = Integer.parseInt(xx);
				}
				if(fuhao=='+') {
					x_xishu+=num;
				}else {
					x_xishu-=num;
				}
			}
			else {//说明是常数项 
				int num = Integer.parseInt(theS);
				if(fuhao=='+') {
					changshu+=num;
				}else {
					changshu-=num;
				}
			}
			if(end<s.length()) {
				fuhao = s.charAt(end);
			}
			begin = end+1;
			end = begin+1;
		}
		
		return new int[]{x_xishu,changshu};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolveTheEquation_640 ss = new SolveTheEquation_640();
		ss.solveEquation("-x+x+3x=2x-x+x");
	}

}

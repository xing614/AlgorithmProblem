package medium;
/**
 * 592.分数加减运算
 * 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。

示例 1:

输入:"-1/2+1/2"
输出: "0/1"
 示例 2:

输入:"-1/2+1/2+1/3"
输出: "1/3"
示例 3:

输入:"1/3-1/2"
输出: "-1/6"
示例 4:

输入:"5/3+1/3"
输出: "2/1"
说明:

输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
输入的分数个数范围是 [1,10]。
最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 * @author liang
 *
 */
public class FractionAdditionAndSubtraction_592 {

	/**
	 * 每次截取分子和分母，找到最大公约数。
	 * @param expression
	 * @return
	 */
    public String fractionAddition(String expression) {
        int n = 0,d = 1;//n表示最终生成的数字的分子，d为分母
        String newExpress = expression.replace("-", "+-");
        String[] exprS;
        if(newExpress.charAt(0) == '+') {
        	exprS = newExpress.substring(1).split("\\+");//+有特殊含义 需要用转义符号
        }else {
        	exprS = newExpress.split("\\+");
        }
        
        for(int i=0;i<exprS.length;i++) {
        	String[] expreG = exprS[i].split("/");
        	int nn = Integer.parseInt(expreG[0]);
        	int dd = Integer.parseInt(expreG[1]);
        	int gcd1 = gcd(d,dd);//得到公约数
        	n = n*dd/gcd1 + nn*d/gcd1;//上*下+上*下
        	d = d*dd/gcd1;//下*下
        }
        int gcd2 = gcd(Math.abs(n),d);
        return n/gcd2+"/"+d/gcd2;
    }
    
	private int gcd(int a, int b) {
		// TODO Auto-generated method stub
		while(b!=0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String r  ="-1/2+1/2";
		String newExpress = r.replace("-", "+-");
        String[] exprS;
        if(newExpress.charAt(0) == '+') {
        	System.out.println(11);
        	exprS = newExpress.substring(2).split("\\+");
        }else {
        	exprS = newExpress.split("\\+");
        }
		//String[] exprS = newExpress.split("+");
	}

}

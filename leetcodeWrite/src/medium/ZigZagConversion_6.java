package medium;
/**
 * 6.Z字形变换
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：

	P   A   H   N
	A P L S I I G
	Y   I   R
	之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
	
	实现一个将字符串进行指定行数变换的函数:
	
	string convert(string s, int numRows);
	示例 1:
	
	输入: s = "PAYPALISHIRING", numRows = 3
	输出: "PAHNAPLSIIGYIR"
	示例 2:
	
	输入: s = "PAYPALISHIRING", numRows = 4
	输出: "PINALSIGYAHRPI"
	解释:
	
	P     I    N
	A   L S  I G
	Y A   H R
	P     I
 * @author liang
 *
 */
public class ZigZagConversion_6 {

	/**
	 * 找规律法2
	 * 分成num行，第一行和最后一行的数据是前后相差(2*num-2)位置的字符；
	 * 中间行数会在(2*num-2)间距之中插入一个数据，这个数据的位置是(2*num-2 - i*2)i是当前第几行
	 * @param s 字符串
	 * @param numRows 行数
	 * @return
	 */
    public static String convert(String s, int numRows) {
    	if(numRows == 1 )return s;
    	StringBuffer sb = new StringBuffer();
    	int point = 0;
    	for(int i=0;i<numRows;i++) {
    		for(int j=i;j<s.length();) {
    			if(i == 0 ||i==(numRows-1)) {//第一行和最后一行
    				sb.append(s.charAt(j));
    				j += 2*numRows -2;
    			}else {
    				if(j>numRows) {//插入那个补上的数据
    					sb.append(s.charAt(j-i*2));
    				}
    				sb.append(s.charAt(j));
    				point = j+2*numRows-2;
        			if(point>=s.length() && (point-i*2)<s.length()) {//本身有个问题如果j大于长度，就不会对j-i*2的数据补上
        				sb.append(s.charAt(point-i*2));
        			} 
    				j += 2*numRows -2;
    			}

    		}
    	}
		return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING",3));
		System.out.println(convert("PAYPALISHIRING",4));
	}

}

package medium;
/**
 * Z���α任
 * ���ַ��� "PAYPALISHIRING" ��Z�������гɸ�����������

	P   A   H   N
	A P L S I I G
	Y   I   R
	֮��������ң����ж�ȡ�ַ���"PAHNAPLSIIGYIR"
	
	ʵ��һ�����ַ�������ָ�������任�ĺ���:
	
	string convert(string s, int numRows);
	ʾ�� 1:
	
	����: s = "PAYPALISHIRING", numRows = 3
	���: "PAHNAPLSIIGYIR"
	ʾ�� 2:
	
	����: s = "PAYPALISHIRING", numRows = 4
	���: "PINALSIGYAHRPI"
	����:
	
	P     I    N
	A   L S  I G
	Y A   H R
	P     I
 * @author liang
 *
 */
public class ZigZagConversion {

	/**
	 * �ҹ��ɷ�2
	 * �ֳ�num�У���һ�к����һ�е�������ǰ�����(2*num-2)λ�õ��ַ���
	 * �м���������(2*num-2)���֮�в���һ�����ݣ�������ݵ�λ����(2*num-2 - i*2)i�ǵ�ǰ�ڼ���
	 * @param s �ַ���
	 * @param numRows ����
	 * @return
	 */
    public static String convert(String s, int numRows) {
    	if(numRows == 1 )return s;
    	StringBuffer sb = new StringBuffer();
    	int point = 0;
    	for(int i=0;i<numRows;i++) {
    		for(int j=i;j<s.length();) {
    			if(i == 0 ||i==(numRows-1)) {//��һ�к����һ��
    				sb.append(s.charAt(j));
    				j += 2*numRows -2;
    			}else {
    				if(j>numRows) {//�����Ǹ����ϵ�����
    					sb.append(s.charAt(j-i*2));
    				}
    				sb.append(s.charAt(j));
    				point = j+2*numRows-2;
        			if(point>=s.length() && (point-i*2)<s.length()) {//�����и��������j���ڳ��ȣ��Ͳ����j-i*2�����ݲ���
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

package easy;

/**
�������ְ������������ַ���I�� V�� X�� L��C��D �� M��

�ַ�          ��ֵ
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��

ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������

I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90�� 
C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
����һ���������֣�����ת��������������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�

ʾ�� 1:

����: "III"
���: 3
ʾ�� 2:

����: "IV"
���: 4
ʾ�� 3:

����: "IX"
���: 9
ʾ�� 4:

����: "LVIII"
���: 58
����: C = 100, L = 50, XXX = 30, III = 3.
ʾ�� 5:

����: "MCMXCIV"
���: 1994
����: M = 1000, CM = 900, XC = 90, IV = 4.
 * @author liang
 *
 */
public class RomanToInteger {

	/**
	 * ���ʼֵΪ�ַ�����һ���ַ���
	 * �����һ��ֵ����ǰһ��ֵ��˵����ֵӦ�ü�ȥǰһ��ֵ�����ֵ�趨Ϊ��һ��ֵ��������Ҫ��2��ǰһ��ֵ���ټ��Ϻ�һ��ֵ
	 * �����һ��ֵС��ǰһ��ֵ���������Ӽ���
	 * @param s
	 * @return
	 */
    public static int romanToInt(String s) {
    	String[] ssr = s.split("");
    	int ret = getNumber(ssr[0]);
    	for(int i=1;i<ssr.length;i++) {
    		if(getNumber(ssr[i-1])<getNumber(ssr[i])) {
    			ret += getNumber(ssr[i]) - 2* getNumber(ssr[i-1]);
    		}else {
    			ret += getNumber(ssr[i]);
    		}
    	}
		return ret;
    }
    public static int getNumber(String ss) {
    	switch(ss) {
        case "I": return 1;  
        case "V": return 5;  
        case "X": return 10;  
        case "L": return 50;  
        case "C": return 100;  
        case "D": return 500;  
        case "M": return 1000; 
    	}
    	return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MCMXCIV"));
	}

}

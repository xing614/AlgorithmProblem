package easy;
/**
 * ���Ǹ�����ת��Ϊ���Ӧ��Ӣ�ı�ʾ��ȷ������С�� 2^31 - 1 ��
 * ����: 123
 * ���: "One Hundred Twenty Three"
 * 
 * ����: 1234567
 * ���: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * ��������Ϊһ�飬��ʮ����Ȼ��ÿ��λ���Thousand��Million billion����ߵ�2^31
 * Ӣ��1-19��ͬ��Ȼ����20��30��������90
 * @author liang
 *
 *�ո�������
 */
public class IntegerToEnglishWords {

    public static String numberToWords(int num) {
    	String[] t = {" Thousand ", " Million ", " Billion "};
    	String res = convertHundred(num%1000);//ÿ��λһ���ĳ�Ӣ�ģ�Ȼ�����м��ǧ�����򣬰���
    	for(int i=0;i<num;i++) {
    		num /= 1000;
    		res = num%1000>0 ?convertHundred(num%1000)+t[i]+res:res;
    	}
    	
		return res.isEmpty()? "Zero":res.trim();//Ϊ0��ɾ�����һ���ո�
        
    }
    //����λ��ת��ΪӢ��
    public static String convertHundred(int num) {
    	String[] tw = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
    			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    	String[] tw2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    	
    	String res;
    	int a = num/100;
    	int b = num%100;
    	int c = num%10;
    	res = b<20? tw[b]:tw2[b/10] + (c>0 ?""+tw[c]:"");//���Ӣ�ġ�20���ڴ�tw��ȡ�𰸣�����20��tw��tw2��
    	if(a>0)
    		res = tw[a]+" Hundred "+res;
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberToWords(100));
	}

}

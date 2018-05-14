package easy;
/**
 * 将非负整数转换为其对应的英文表示，确保输入小于 2^31 - 1 。
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * 三个数字为一组，百十个；然后每三位添加Thousand，Million billion。最高到2^31
 * 英文1-19不同，然后是20，30，。。。90
 * @author liang
 *
 *空格有问题
 */
public class IntegerToEnglishWords {

    public static String numberToWords(int num) {
    	String[] t = {" Thousand ", " Million ", " Billion "};
    	String res = convertHundred(num%1000);//每四位一个改成英文，然后在中间加千，百万，百亿
    	for(int i=0;i<num;i++) {
    		num /= 1000;
    		res = num%1000>0 ?convertHundred(num%1000)+t[i]+res:res;
    	}
    	
		return res.isEmpty()? "Zero":res.trim();//为0或删除最后一个空格
        
    }
    //将三位数转化为英文
    public static String convertHundred(int num) {
    	String[] tw = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
    			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    	String[] tw2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    	
    	String res;
    	int a = num/100;
    	int b = num%100;
    	int c = num%10;
    	res = b<20? tw[b]:tw2[b/10] + (c>0 ?""+tw[c]:"");//获得英文。20以内从tw获取答案，大于20则tw和tw2加
    	if(a>0)
    		res = tw[a]+" Hundred "+res;
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberToWords(100));
	}

}

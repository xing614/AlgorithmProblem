package easy;
/**
 * 整数转罗马数字
 * @author liang
 *
 */
public class IntegerToRoman {
	
    public static String intToRoman(int num) {
    	StringBuffer str = new StringBuffer();
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] inter = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i=0;num!=0;i++) {
        	while(num>=inter[i]) {
        		num -= inter[i];
        		str.append(roman[i]);
        	}
        }
        return str.toString();
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(1994));
	}

}

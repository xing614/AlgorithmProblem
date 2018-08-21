package hard;
/**
 * 65. 有效数字
验证给定的字符串是否为数字。

例如:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。

更新于 2015-02-10:
C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
 * @author liang
 *
 */
public class ValidNumber_65 {

	/**
	 * 正则方法
	 * @param s
	 * @return
	 */
	public boolean isNumber2(String s) { 
        if(s.trim().isEmpty()){ 
            return false; 
        } 
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?"; 
        if(s.trim().matches(regex)){ 
            return true; 
        }else{ 
            return false; 
        } 
    } 
	
	/**
	 * 如果看到数字，就将numberSeen设为true
     * 如果看到小数点，则判断是否已有小数点或是e，因为e后只能有整数
     * 对于'e'，最多只允许出现1次，其前后都必须有数字，但后面一定是整数，即不能出现'.'
     * e只能遇到一次，如果第一次遇到e但是没有遇到数字，则返回错误。
     * 遇到第一个e后，将numberAfterE flag标注为否以便判断后序是否有数字
     * 正负号的位置只能位于最开始和e紧邻着右边那个位置
     */
    public boolean isNumber(String s) {
        s = s.trim();//除去字符串开头和结尾空格
        boolean pointSeen = false;//已经遇到过小数点则该位置设为true
        boolean eSeen = false;//已经遇到过e则该位置设为true
        boolean numberSeen = false;//是否遇到过数字，遇到过数字设置为true
        boolean numberAfterE = true;//遇到第一个e后，将numberAfterE标注为否以便判断后序是否有数字
        for(int i=0;i<s.length();i++) {
        	//当前位为数字
        	if('0'<=s.charAt(i) && s.charAt(i)<='9') {
        		numberSeen = true;
        		numberAfterE = true;
        	}
        	//当前位为小数点
        	else if(s.charAt(i) == '.') {
        		//已经遇到小数点或是e，则出错
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;//之前没遇到小数点则设置为true
        	}
        	//当前位为e
        	else if(s.charAt(i) == 'e') {
        		//已经遇到e或是尚未遇到数字
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;//设置遇到过e
        	}
        	////遇到正负号，只能在首位或是e后面
        	else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
        		if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            //遇到其它符号一定是错的
            } else {
                return false;
            }
        }   
        //是否遇到小数点或是e均不重要
        return numberSeen && numberAfterE;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

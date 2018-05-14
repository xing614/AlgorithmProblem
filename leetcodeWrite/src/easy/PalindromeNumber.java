package easy;
/**
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 *  ����: 121
	���: true
	
	ʾ�� 2:
	����: -121
	���: false
	����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
 * @author liang
 *
 */
public class PalindromeNumber {
	/**
	 * ����1����xֵ��ת����
	 * @param x
	 * @return
	 */
    public static boolean isPalindrome(int x) {
    	if(x<0) {
    		return false;
    	}else if(x==0) {
    		return true;
    	}else {
    		int tem = x;
    		int y = 0;
    		while(x!=0) {
    			y = y*10 + x%10;//x%10��ȡ��ǰx�����һλ���֣���һ��y*10�Ὣ�������λ�ƶ�
    			x = x/10;//ȥ�����λ
     		}
    		if(y==tem)
    			return true;
    		else 
    			return false;
    	}
    }

    /**
     * �����������ν����λ�����λ�Ƚϣ����ֲ�ͬ��false
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
    	if(x<0) {
    		return false;
    	}else if(x==0) {
    		return true;
    	}else {
    		int num = 1;//�������2121����numΪ1000
    		while(x/num >=10)
    			num *= 10;
    		while(x!=0) {
    			//���λ
    			int left = x/num;
    			//���λ
    			int right = x%10;
    			if(left!=right)//���ڲ��Ⱦ�Ϊfalse
    				return false;
    			x = (x % num) / 10;//x%num��ʾȥ��x�����λ��/10��ʾȥ�����λ
    			num /=100; //��ʾ��ǰx����
    		}
    		return true;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome2(123321));
	}

}

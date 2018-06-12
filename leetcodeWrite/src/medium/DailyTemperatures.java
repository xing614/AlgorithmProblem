package medium;
/**
 * ÿ���¶�����
 * ����ÿ�� ���� �б�����������һ���б���Ӧλ�õ�����������Ҫ�ٵȴ�����¶ȲŻ����ߵ����������֮�󶼲������ߣ������� 0 �����档

���磬����һ���б� temperatures = [73, 74, 75, 71, 69, 72, 76, 73]��������Ӧ���� [1, 1, 4, 2, 1, 1, 0, 0]��

��ʾ������ �б��ȵķ�Χ�� [1, 30000]��ÿ�����µ�ֵ�Ķ��� [30, 100] ��Χ�ڵ�������
 * @author liang
 *
 */
public class DailyTemperatures {

	/**
	 * �����ⷨ��ѭ���ж�
	 * @param temperatures
	 * @return
	 */
    public int[] dailyTemperatures(int[] temperatures) {
        int tlen = temperatures.length;
        int[] result = new int[tlen];
        for(int i=0;i<tlen;i++) {
        	for(int j=i+1;j<tlen;j++) {
        		if(temperatures[j]>temperatures[i]) {
        			result[i] = j-i;
        			break;
        		}
        	}
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

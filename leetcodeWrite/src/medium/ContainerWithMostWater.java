package medium;
/**
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ���� n ����ֱ�ߣ�ʹ�ô�ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)���ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��

ע�⣺�㲻����б������n ������2��

��ʾ����һ�����顣�ҵ�����(j-i)*(min(aj,ai)),����������������ֵ
 * @author liang
 *
 */
public class ContainerWithMostWater {
	/**
	 * �����ⷨ������ѭ�������
	 * ���ǳ�ʱ��
	 * @param height
	 * @return
	 */
    public int maxArea(int[] height) {
    	int hlen = height.length;
    	int max = 0;
    	for(int i=0;i<hlen;i++) {
    		for(int j=i+1;j<hlen;j++) {
    			max = Math.max(max,Math.min(height[i],height[j])*(j-i));
    		}
    	}
		return max;
        
    }
    /**
     * �ڶ���
     * �������������࿪ʼ�����ֵ��ÿ���������������һ���ƶ���
     * �� ���a[left]<a[right]����left++����Ϊ�߲��п����þ��������ֵ���
     * ʱ�临�Ӷ�n
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
    	int left = 0,right=height.length-1,max=0;
    	while(left<right) {
    		max = Math.max(max, Math.min(height[left], height[right])*(right-left));
    		if(height[left]<height[right]) {
    			left++;
    		}else {
    			right--;
    		}
    	}
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

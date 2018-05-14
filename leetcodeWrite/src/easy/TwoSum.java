package easy;

import java.util.HashMap;
/**
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
	����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
	
	���� nums = [2, 7, 11, 15], target = 9
	��Ϊ nums[0] + nums[1] = 2 + 7 = 9
	���Է��� [0, 1]
	
 * @param nums
 * @param target
 * @return
 */
public class TwoSum {

	/**
	 * ����ѭ��ֱ�ӱ����ƽ�
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] twoSum0(int[] nums, int target) {
    	int[] result = new int[2];
    	for(int i=0;i<nums.length;i++) {
    		for(int j=i+1;i<nums.length;i++) {
    			if(nums[i]+nums[j]==target) {
    				result[0] = i;
    				result[1] = j;
    			}
    		}
    	}
    	return result;
    }
	
	/**
	 * �Ƚ���������ֵ����map�У�keyΪֵ��valueΪ�����±�
	 * ��map���ҵ�target-nums[i]��ֵ������ҵ��������ֵ���±겻��i�������ҵ���
	 * @param nums ��������
	 * @param target Ŀ���
	 * @return  ��ΪĿ��ֵ��������
	 */
    public static int[] twoSum(int[] nums, int target) {
    	HashMap<Integer,Integer> hm = new HashMap();
    	int[] result = new int[2];
    	for(int i=0;i<nums.length;i++) {
    		hm.put(nums[i], i);
    	}
    	for(int i=0;i<nums.length;i++) {
    		int second = target - nums[i]; 
    		if(hm.containsKey(second)&& hm.get(second) != i) {
    			result[0] = i;
    			result[1] = hm.get(second);
    		}
    	}
		return result;
    }
    
    /**
     * �ⷨ2��һ��ѭ��ֱ���ж�
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] var = {2,7,11,15};
		int[] result = twoSum(var,9);
		System.out.println(result[0]+" "+result[1]);
	}

}

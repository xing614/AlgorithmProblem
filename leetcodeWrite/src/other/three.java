package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * 三种颜色的球，相邻颜色不一样
 * @author liang
 *
 */
public class three {

	int count = 0;
	
	public void dd() {
		int np = 2;
		int nq = 1;
		int nr = 1;
		char[] nu = {'P','P','Q','R'};
		HashMap<List<Character>,Integer> res = new HashMap<List<Character>,Integer>();
		dfs(nu,0,res);
		System.out.println(res.size());
	}
	

	private void dfs(char[] nums, int start, HashMap<List<Character>, Integer> res) {
		// TODO Auto-generated method stub
		if(start==nums.length) {
			if(isOk(nums)) {
				List<Character> te = new ArrayList<Character>();
				for(char num:nums) {
					te.add(num);
				}
				res.put(te, 0);
			}

		}
		for(int i=start;i<nums.length;i++) {
			swap(nums,start,i);
			dfs(nums,start+1,res);//这里是start+1,进入当前层的下一层
			swap(nums,start,i);
		}
	}



	private static boolean isOk(char[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i] == nums[i+1]) {
				return false;
			}
		}
		return true;
	}


	private static void swap(char[] nums, int start, int i) {
		// TODO Auto-generated method stub
		char temp = nums[i];
		nums[i] = nums[start];
		nums[start] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		three th = new three();
		th.dd();
	}

}

package other;

import java.util.ArrayList;
import java.util.List;

public class qkl {

	public static void dfs(List<List<Integer>> res, List<Integer> list,int[] nums,int k,int start) {
		if(start == k-1) {
			if(list.size() == 0)
				return;
			if(isOk(list,nums,k)) {
				res.add(new ArrayList<Integer>(list));
			}
			return;
		}
		
		dfs(res,list,nums,k,start+1);
		list.add(start);
		dfs(res,list,nums,k,start+1);
		list.remove(list.size()-1);
		
	}
	
	private static boolean isOk(List<Integer> list,int[] nums,int k) {
		int fr = 0;
		int ba = 0;
		for(int i=0;i<list.size();i++) {
			ba = list.get(i)+1;
			int count = 0;
			for(int j=fr;j<ba;j++) {
				if(nums[j] ==1)
					count ++;
			}
			if(count!=1)
				return false;
			fr = list.get(i)+1;
		}
		int count = 0;
		for(int j=fr;j<k;j++) {
			if(nums[j] ==1)
				count ++;
		}
		if(count!=1)
			return false;		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 4;
		int[] nums = {1,0,1,1};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		dfs(res,list,nums,k,0);
		System.out.println(res.size());
	}

}

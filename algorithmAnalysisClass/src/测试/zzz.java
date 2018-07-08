package ≤‚ ‘;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TestBasicInfoQueryPojo> tlist = new ArrayList<TestBasicInfoQueryPojo>();
		tlist.add(new TestBasicInfoQueryPojo(1,"aa"));
		tlist.add(new TestBasicInfoQueryPojo(2,"bb"));
		tlist.add(new TestBasicInfoQueryPojo(3,"cc"));
		
		List<TestBasicInfoQueryPojo> tlist2 = new ArrayList<TestBasicInfoQueryPojo>();
		tlist2.add(new TestBasicInfoQueryPojo(4,"dd"));
		
		tlist2.addAll(tlist);
		
		Iterator<TestBasicInfoQueryPojo> it1 = tlist.iterator();
		while(it1.hasNext()){
			System.out.println("1=="+it1.next().aa);
		}
		Iterator<TestBasicInfoQueryPojo> it2 = tlist.iterator();
		while(it2.hasNext()){
			System.out.println("1-=="+it2.next().aa);
		}	
		
		Iterator<TestBasicInfoQueryPojo> it3 = tlist2.iterator();
		while(it3.hasNext()){
			System.out.println("2=="+it3.next().aa);
		}		
		
		tlist2.removeAll(tlist);
		
		Iterator<TestBasicInfoQueryPojo> it4 = tlist2.iterator();
		while(it4.hasNext()){
			System.out.println("2-=="+it4.next().aa);
		}	
	}

}

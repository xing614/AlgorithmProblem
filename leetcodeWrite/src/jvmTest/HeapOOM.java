package jvmTest;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 * java堆溢出
 * @author liang
 *
 */
public class HeapOOM {

	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true) {
			list.add(new OOMObject());
		}
	}

}

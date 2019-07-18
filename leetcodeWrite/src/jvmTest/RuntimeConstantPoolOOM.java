package jvmTest;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=10m -XX:MaxPermSize=10m
 * 运行时常量池导致的内存溢出异常
 * @author liang
 *
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();

        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());//将String对象加入常量池
        }	

	}
}
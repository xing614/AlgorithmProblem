package jvmTest;

/**
 * jdk1.6以前是返回两个false
 * 1.7开始返回true和false
 * 1.6以前 intern()会把首次遇到的字符串实例复制到永久代，返回的也是永久代这个字符串实例引用，而StringBuilder创建的字符在java堆中，必然不是同一个引用 所以false
 * 1.7开始常量池在堆中,intern不会再复制实例，只是在常量池中记录首次出现的实例引用，因此intern返回的引用和StringBuilder建立的字符串实例是同一个
 * 而对于str2返回false是因为java这个字符串在执行.toString()之前已经出现过，字符串常量池中已经有它的引用，不符合“首次出现”原则
 *  "java" 字符串常量比较特殊, 它是固定存在字符串常量池中的
 * @author liang
 *
 */
public class RuntimeConstantPoolOOM2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}

}

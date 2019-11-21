package memory.oom;

import java.util.concurrent.TimeUnit;

public class RuntimeConstantPoolOOM {
	public static void main(String[] args) throws InterruptedException {
//		List<String> list = new ArrayList<String>();
//		int i = 0;
//		while (true) {
//			list.add(String.valueOf(i++).intern());
//		}
//		String str1 = new StringBuilder("�����").append("���").toString();
//		System.out.println(str1.intern() == str1);
		
//		String str1 = new StringBuilder("rt").append("vs").toString();
//		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println("str2.intern() == str2 " + (str2.intern() == str2));
		String str3 = "1234";
		System.out.println("str3.intern() == str3 " + (str3.intern() == str3));
		String str4 = new String("123");
		System.out.println("str4.intern() == str4 " + (str4.intern() == str4));

		String str5 = "你好的";
		System.out.println("str5.intern() == str5 " + (str5.intern() == str5));

		TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
	}
	

}

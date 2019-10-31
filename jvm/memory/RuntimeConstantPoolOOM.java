package memory;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
//		int i = 0;
//		while (true) {
//			list.add(String.valueOf(i++).intern());
//		}
//		String str1 = new StringBuilder("�����").append("���").toString();
//		System.out.println(str1.intern() == str1);
		
//		String str1 = new StringBuilder("rt").append("vs").toString();
//		System.out.println(str1.intern() == str1);
		
//		String str2 = new StringBuilder("ja").append("va").toString();
//		System.out.println(str2.intern() == str2);


//		String str1 = "todo";
//		String str2 = "todo";
//		String str3 = "to";
//		String str4 = "do";
//		String str5 = str3 + str4;
//		String str6 = new String(str1);
//
//		System.out.println("------普通String测试结果------");
//		System.out.print("str1 == str2 ? ");
//		System.out.println( str1 == str2);
//		System.out.print("str1 == str5 ? ");
//		System.out.println(str1 == str5);
//		System.out.print("str1 == str6 ? ");
//		System.out.print(str1 == str6);
//		System.out.println();
//
//		System.out.println("---------intern测试结果---------");
//		System.out.print("str1.intern() == str2.intern() ? ");
//		System.out.println(str1.intern() == str2.intern());
//		System.out.print("str1.intern() == str5.intern() ? ");
//		System.out.println(str1.intern() == str5.intern());
//		System.out.print("str1.intern() == str6.intern() ? ");
//		System.out.println(str1.intern() == str6.intern());
//		System.out.print("str1 == str6.intern() ? ");
//		System.out.println(str1 == str6.intern());

		String a = "abc";
//		String b = new String("abc");
		System.out.println(a == "abc");
		System.out.println(a == a.intern());
	}
	

}

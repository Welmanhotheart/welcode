package exercise.typeinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;

import testcase.typeinfo.pets.Rat;
//exercise8,9,10
public class PrintsHierarchy {
	public static void printsHierarchy(Object o, int layer) {
		Class<? extends Object> cls = o.getClass();
		printsHierarchy(cls, layer);
		cls.getSigners();
		
	}
	public static void printsHierarchy(Class cls, int layer) {
		String tabs = getTabs(layer);
		System.out.println(tabs + "simple name:" + cls.getSimpleName());
		System.out.println(tabs + "cononical name:" + cls.getCanonicalName());
		Field[] declaredFields = cls.getDeclaredFields();
		Method[] declaredMethods = cls.getDeclaredMethods();
		String tabs2 = getTabs(layer+1);
		if (declaredFields != null && declaredFields.length > 0) {
			for (int i = 0; i < declaredFields.length; i++) {
				Field field = declaredFields[i];
				System.out.println(tabs2 + "field name:" + field.getName());
				System.out.println(tabs2 + "field type:" + field.getType().getCanonicalName());
				System.out.println(tabs2 + "field nodifier:" + Modifier.toString(field.getModifiers()));
			}
		}
		if (declaredMethods != null && declaredMethods.length > 0) {
			for (Method method : declaredMethods) {
				System.out.println(tabs2 + "method name:" + method.getName());
				System.out.println(tabs2 + "method parameters:" + Arrays.asList(method.getParameterTypes()));
				System.out.println(tabs2 + "method return type:" + Arrays.asList(method.getReturnType()));
			}
		}
		Class<?> superclass = cls.getSuperclass();
		if (null != superclass) {
			printsHierarchy(superclass, layer + 1);
		}
		
		for (Class intface : cls.getInterfaces()) {
			printsHierarchy(intface, layer + 1);
		}
	}
	public static String getTabs(int layer) {
		StringBuffer sbf = new StringBuffer(layer);
		for (int i = 0; i < layer; i++) {
			sbf.append('\t');
		}
		return sbf.toString();
	}
	
	public static void main(String[] args) {
//		printsHierarchy(new BigRat(),0);
//		printsHierarchy(new char[]{'a','c'},0);
		Class cls = (new char[]{'a','c'}).getClass();
		System.out.println(cls.isPrimitive());
		
	}
}

class BigRat extends Rat {
	private String name;
	private String gender;
	public BigRat() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
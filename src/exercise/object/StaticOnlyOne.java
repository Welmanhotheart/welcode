package exercise.object;
////exercise8
public class StaticOnlyOne {
	public static void main(String[] args) {
		for(int i = 100; i > 0; i--) {
			System.out.println(new StaticOnlyHelp().staticMember);
		}
	}
}

class StaticOnlyHelp{
	static Object staticMember;
	static{
		System.out.println("initinize static member");
		staticMember = new Object();
	}
}

/**
 * initinize static member
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02
java.lang.Object@33c1b02

 */


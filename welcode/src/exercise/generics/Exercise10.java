package exercise.generics;


class GenericMethods_ {
public  void f(Object...argrs) {
	for (Object arg: argrs) {
		System.out.println(arg.getClass().getName());
	}
}
public static void main(String[] args) {
	GenericMethods_ gm = new GenericMethods_();
 gm.f("","", 1f);
 gm.f('c',1L,1.0);
 gm.f(1,(byte)1, gm);
}
} 

public class Exercise10 {
	public static void main(String[] args) {
		GenericMethods_.main(null);
	}
}

/**
 * output:
 *java.lang.String
	java.lang.String
	java.lang.Float
	
	java.lang.Character
	java.lang.Long
	java.lang.Double
	
	java.lang.Integer
	java.lang.Byte
	exercise.generics.GenericMethods_ 
 */

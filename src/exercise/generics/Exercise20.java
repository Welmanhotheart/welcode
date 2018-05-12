
package exercise.generics;

interface generic_interface_20 {
	void method1();
	void method2();
}

class generic_class_20 implements generic_interface_20 {

	@Override
  public void method1() {
	  // TODO Auto-generated method stub
	  System.out.println("method1");
  }

	@Override
  public void method2() {
	  // TODO Auto-generated method stub
		System.out.println("method2");
  }
	
	public void mehtod3() {
		System.out.println("method3");
	}
}

class generic_bound_class<T extends generic_interface_20> {
	private T obj;
	public generic_bound_class(T obj) {
		this.obj = obj;
	}
	void show_bounds_method() {
		this.obj.method1();
		this.obj.method2();
	}
}
public class Exercise20 {
	public static void main(String[] args) {
		generic_bound_class<generic_class_20> name 
					= new generic_bound_class<generic_class_20>(new generic_class_20());
		name.show_bounds_method();
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
	exercise.generics.GenericMethods 
 */

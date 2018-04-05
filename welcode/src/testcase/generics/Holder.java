package testcase.generics;

//: generics/Holder.java

public class Holder<T> {
  private T value;
  public Holder() {}
  public Holder(T val) { value = val; }
  public void set(Object val) { value = (T) val; }
  public T get() { return value; }
  public boolean equals(Object obj) {
    return value.equals(obj);
  }	
  public static void main(String[] args) {
    Holder<Apple> Apple = new Holder<Apple>(new Apple());
    Apple d = Apple.get();
    Apple.set(d);
    // Holder<Fruit> Fruit = Apple; // Cannot upcast
    Holder<? extends Fruit> fruit = Apple; // OK
    Fruit p = fruit.get();
    d = (Apple)fruit.get(); // Returns 'Object'
    try {
      Orange c = (Orange)fruit.get(); // No warning
    } catch(Exception e) { System.out.println(e); }
//     fruit.set(new Apple()); // Cannot call set()
//     fruit.set(new Fruit()); // Cannot call set(), yeah it's ok if the argument type of ‘set’ method is 'Object'
    System.out.println(fruit.equals(d)); // OK
  }
} /* Output: (Sample)
java.lang.ClassCastException: Apple cannot be cast to Orange
true
*///:~
/**
 * We can see that the compiler doesn't analyze the code to see if you perform any actual writes or reads,
 * it only pay attention to the types of objects that are passed and returned.
 */

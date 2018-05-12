package exercise.generics;




//: generics/LinkedStack.java
//A stack implemented with an internal linked structure.

class LinkedStack<T> {
	/**
	 * here if I use static to decorate it ,it cast errors
	 * @author Administrator
	 * If I remove the static key word, will it alway initialize the
	 * node.class byte file? No
	 */
	private  /*static*/ class Node {
	  T item;
	  Node next;
	  Node() { item = null; next = null; }
	  Node(T item, Node next) {
	    this.item = item;
	    this.next = next;
	  }
	  boolean end() { return item == null && next == null; }
	}
	private Node top = new Node(); // End sentinel
	public void push(T item) {
//		System.out.println(t);
	  top = new Node(item, top);
	}	
	
	public T pop() {
	  T result = top.item;
	  if(!top.end())
	    top = top.next;
	  return result;
	}
	
	public static void main(String[] args) {
	  LinkedStack<String> lss = new LinkedStack<String>();
	  Class cls = lss.new Node().getClass();
	  System.out.println(LinkedStack.Node.class);
	  for(String s : "Phasers on stun!".split(" "))
	    lss.push(s);
	  String s;
	  while((s = lss.pop()) != null) {
	  	System.out.println(s);
	  }
	  lss = new LinkedStack<String>();
	  System.out.println(lss.new Node().getClass() == cls);
	}
} /* Output:
stun!
on
Phasers
*///:~



public class Exercise5 {
	public static void main(String[] args) {
		LinkedStack.main(null);
	}
}

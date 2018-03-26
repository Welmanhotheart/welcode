//: net/mindview/util/Sets.java
package testcase.net.mindview.util;
import java.util.*;

public class Sets {
  public static <T> Set<T> union(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.addAll(b);
    return result;
  }
  public static <T>
  Set<T> intersection(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.retainAll(b);
    return result;
  }	
  // Subtract subset from superset:
  public static <T> Set<T>
  difference(Set<T> superset, Set<T> subset) {
    Set<T> result = new HashSet<T>(superset);
    result.removeAll(subset);
    return result;
  }
  // Reflexive--everything not in the intersection:
  public static <T> Set<T> complement(Set<T> a, Set<T> b) {
    return difference(union(a, b), intersection(a, b));
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Set<T> clone(Set<T> original) {
  	/**
  	 * this doesn't pass the compilation,what should I do 
  	 */
//  	return original instanceof EnumSet?
//  				((EnumSet<T>)original).clone() : new HashSet<T>(original);
	  	return original instanceof EnumSet?
	  				((EnumSet)original).clone() : new HashSet<T>(original);
  }
} ///:~

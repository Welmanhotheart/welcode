//: annotations/HashSetTest.java
package annotations;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

import java.util.LinkedList;
import java.util.List;

public class HashSetTest {
//    HashSet<String> testObject = new HashSet<String>();
    List<String> testObject = new LinkedList<String>();

    @Test
    protected void initialization() {
        assert testObject.isEmpty();
    }

    @Test
    protected void _contains() {
        testObject.add("one");
        assert testObject.contains("one");
    }

    @Test
    protected void _remove() {
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command(
                "java net.mindview.atunit.AtUnit HashSetTest");
    }
} /* Output:
annotations.HashSetTest
  . initialization
  . _remove
  . _contains
OK (3 tests)
*///:~

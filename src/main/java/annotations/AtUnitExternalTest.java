//: annotations/AtUnitExternalTest.java
// Creating non-embedded tests.
package annotations;

import net.mindview.atunit.*;
import net.mindview.util.*;

public class AtUnitExternalTest extends AtUnitExample1 {
    @Test
    boolean _methodOne() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return methodTwo() == 2;
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command(
                "java net.mindview.atunit.AtUnit D:/learnjavaworkspace/welcode/target/classes/annotations/AtUnitExternalTest");
    }
}

/*
 Exec:java annotations.AtUnitExternalTest
 Output:
annotations.AtUnitExternalTest
  . _methodOne
  . _methodTwo This is methodTwo

OK (2 tests)
*///:~

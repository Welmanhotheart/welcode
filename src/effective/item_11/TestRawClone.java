package effective.item_11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRawClone {
    static class CloneableObject implements Cloneable{
        protected CloneableObject clone() throws CloneNotSupportedException {
            return new CloneableObject();
            /**
             * is it right? wrong, as this class is non-final, someday,sb may create a subclass
             * of this class, thus then, the method clone invocation on the instance of such a
             * subclass will work out to be always  of the wrong class, not the subclass itself
              */

        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
       CloneableObject object = new CloneableObject();
        Object cloneobj = object.clone();
        System.out.println(cloneobj.getClass().equals(object.getClass()));
    }
}
/**
 * Well, if we did not define the method 'clone' ，
 * even resorting to reflection to achieve invocation of 'clone' may still fail.
 * Before adding override method "clone", there throws java.lang.NoSuchMethodException.
 * After we override the method 'clone' in the CloneableObject class,
 * invocation of 'clone' using reflection works well.However, all of above is under such
 * an condition that
 * the class type of the instance that the method 'clone' is invoked on must implement Cloneable interface
 * unless within your clone method, you didn't touch the super.clone
 *
 */
package effective.item_11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectionClone {
    static class FatherCloneableObject {
//        protected CloneableObject clone() throws CloneNotSupportedException {
//            return (CloneableObject) super.clone();
//        }
    }
    static class CloneableObject extends  FatherCloneableObject/* implements Cloneable*/{
        protected CloneableObject clone() throws CloneNotSupportedException {
            return (CloneableObject) super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
       CloneableObject object = new CloneableObject();
//        Object cloneobj = object.clone();
//        System.out.println(cloneobj.getClass().equals(object.getClass()));
        //'clone()' has protected access in 'java.lang.Object, couldn't be accessed
        Class<? extends CloneableObject> cls = object.getClass();
        Method clone = null;
        try {
            clone = cls.getDeclaredMethod("clone");
            try {
                Object invoke = clone.invoke(object);
                System.out.println(invoke);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

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
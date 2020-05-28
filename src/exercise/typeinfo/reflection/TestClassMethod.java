package exercise.typeinfo.reflection;

import annotations.database.SQLChar;

import javax.annotation.Resource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestClassMethod {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<?> cls = SubClass.class;
        printWithTag("toString" , cls.toString());

        printWithTag("isInstance", String.valueOf(cls.isInstance(new SubClass())));

        printWithTag("isAssignableFrom", cls.isAssignableFrom(SubClass.class));

        printWithTag("isInterface", cls.isInterface());

        printWithTag("getName", cls.getName());

        printWithTag("getGenericSuperclass", cls.getGenericSuperclass());

        printWithTag("getPackage", cls.getPackage());

        printWithTag("getComponentType", cls.getComponentType());

        printWithTag("getModifiers", cls.getModifiers());

        printWithTag("getSigners", cls.getSigners());//这里signer指的是啥意思

        printWithTag("getEnclosingMethod", cls.getEnclosingMethod()); //待测试

        printWithTag("getEnclosingConstructor", cls.getEnclosingConstructor()); //待测试

        printWithTag("getDeclaringClass", cls.getDeclaringClass()); //待测试

        printWithTag("getEnclosingClass", cls.getEnclosingClass()); //待测试

        printWithTag("getSimpleName", cls.getSimpleName());

        printWithTag("getCanonicalName", cls.getCanonicalName());

        printWithTag("isAnonymousClass", cls.isAnonymousClass());//待测试

        printWithTag("isLocalClass", cls.isLocalClass());//待测试


        printWithTag("isMemberClass", cls.isMemberClass());//待测试

        printWithTag("getClasses", cls.getClasses());//待测试


        printWithTag("getFields", cls.getFields());

        printWithTag("getMethods", cls.getMethods());

        printWithTag("getConstructors", cls.getConstructors());


        printWithTag("getField subId", getFiled(cls, "subId"));

        printWithTag("getField pubSub", getFiled(cls, "pubSub"));

        printWithTag("getField superId", getFiled(cls, "superId"));

        printWithTag("getField superPubField", getFiled(cls, "superPubField"));


        printWithTag("getField subPriStaticCounter", getFiled(cls, "subPriStaticCounter"));

        printWithTag("getField subPubStaticCounter", getFiled(cls, "subPubStaticCounter"));

        printWithTag("getField superStaticPrivateCounterer", getFiled(cls, "superStaticPrivateCounterer"));


        printWithTag("getField superStaticPublicCounterer", getFiled(cls, "superStaticPublicCounterer"));


        printWithTag("getMethod subPrivateStaticMethod",getMethod(cls, "subPrivateStaticMethod"));

        printWithTag("getMethod getSubPubStaticCounter",getMethod(cls, "getSubPubStaticCounter"));

        printWithTag("getMethod superPrivateStaticMethod",getMethod(cls, "superPrivateStaticMethod"));

        printWithTag("getMethod getSuperStaticPrivateCounterer",getMethod(cls, "getSuperStaticPrivateCounterer"));



        printWithTag("getConstructor",getConstructor(cls));

        printWithTag("getConstructor int",getConstructor(cls, int.class));

        printWithTag("getConstructor int int",getConstructor(cls, int.class, int.class));

        printWithTag("getDeclaredFields", cls.getDeclaredFields());

        printWithTag("getDeclaredMethods", cls.getDeclaredMethods());

        printWithTag("getDeclaredConstructors", cls.getDeclaredConstructors());



        printWithTag("getDeclaredField superStaticPublicCounterer", getDeclaredField(cls, "superStaticPublicCounterer"));

        printWithTag("getDeclaredField superPubField", getDeclaredField(cls, "superPubField"));

        printWithTag("getDeclaredField subPriStaticCounter", getDeclaredField(cls, "subPriStaticCounter"));

        printWithTag("getDeclaredField subId", getDeclaredField(cls, "subId"));

        printWithTag("getDeclaredMethod getSuperStaticPrivateCounterer", getDeclaredMethod(cls, "getSuperStaticPrivateCounterer"));

        printWithTag("getDeclaredMethod getSuperStaticPrivateCounterer", getDeclaredMethod(cls, "getSuperStaticPrivateCounterer"));


        printWithTag("getResourceAsStream", cls.getResourceAsStream("source.txt"));

        printWithTag("getResource", cls.getResource("source.txt"));

        printWithTag("getProtectionDomain", cls.getProtectionDomain());//待讨论

        printWithTag("isEnum",cls.isEnum());


        printWithTag("desiredAssertionStatus",cls.desiredAssertionStatus()); //待讨论


        printWithTag("cast", cls.cast(new SubClass()));

        try {
            printWithTag("SuperClass asSubclass", SuperClass.class.asSubclass(SubClass.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        printWithTag("isAnnotationPresent", cls.isAnnotationPresent(Resource.class));

        printWithTag("isAnnotationPresent", cls.isAnnotationPresent(SQLChar.class));

        printWithTag("getAnnotations", cls.getAnnotations());

        printWithTag("getDeclaredAnnotations", cls.getDeclaredAnnotations());//待探测



    }



    private static List<Object> getMethod(Class cls, String methodName,Class<?>... parameterTypes) {
        List<Object> messages = new ArrayList<Object>(2);
        try {
            Method method = cls.getMethod(methodName, parameterTypes);
            messages.add(method);
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            messages.add("\n\t" + e.getClass().getSimpleName() + "\n");
            for (StackTraceElement element : stackTrace) {
                messages.add("\t\t" + element + "\n");
            }
        }
        return messages;
    }

    private static List<Object> getDeclaredMethod(Class cls, String methodName,Class<?>... parameterTypes) {
        List<Object> messages = new ArrayList<Object>(2);
        try {
            Method method = cls.getDeclaredMethod(methodName, parameterTypes);
            messages.add(method);
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            messages.add("\n\t" + e.getClass().getSimpleName() + "\n");
            for (StackTraceElement element : stackTrace) {
                messages.add("\t\t" + element + "\n");
            }
        }
        return messages;
    }

    private static List<Object> getConstructor(Class cls, Class<?>... parameterTypes) {
        List<Object> messages = new ArrayList<Object>(2);
        try {
            Constructor constructor = cls.getConstructor(parameterTypes);
            messages.add(constructor);
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            messages.add("\n\t" + e.getClass().getSimpleName() + "\n");
            for (StackTraceElement element : stackTrace) {
                messages.add("\t\t" + element + "\n");
            }
        }
        return messages;
    }

    private static List<Object> getFiled(Class cls, String fieldName) {
        List<Object> messages = new ArrayList<Object>(2);
        try {
            Field field = cls.getField(fieldName);
            messages.add(field);
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            messages.add("\n\t" + e.getClass().getSimpleName() + "\n");
            for (StackTraceElement element : stackTrace) {
                messages.add("\t\t" + element + "\n");
            }
        }
        return messages;
    }

    private static List<Object> getDeclaredField(Class cls, String fieldName) {
        List<Object> messages = new ArrayList<Object>(2);
        try {
            Field field = cls.getDeclaredField(fieldName);
            messages.add(field);
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            messages.add("\n\t" + e.getClass().getSimpleName() + "\n");
            for (StackTraceElement element : stackTrace) {
                messages.add("\t\t" + element + "\n");
            }
        }
        return messages;
    }

    private  static void printWithTag(String tag, Object o) {
        if (o != null) {
            Class<?> cls = o.getClass();
            if(!(cls.isArray() || Iterator.class.isAssignableFrom(cls))) {
                System.out.println(tag + " : " + o);
            } else {
                System.out.println(tag + " : ");
                for (Object o1 : (Object[])o) {
                    System.out.println("\t" +
                            o1
                    );
                }
            }
        } else {
            System.out.println(tag + ":");
        }
        System.out.println();
    }
}
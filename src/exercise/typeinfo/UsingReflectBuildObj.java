package exercise.typeinfo;



import static testcase.net.mindview.util.Print.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UsingReflectBuildObj {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class cls = Toy.class;
		Constructor[] constructors = cls.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			Class[] types = constructor.getParameterTypes();
			if (types == null && types.length == 0) {
				Object newInstance = cls.newInstance();
				System.out.println(newInstance);
				return;
			}
			Object[] os = new Object[types.length];
			int i = 0;
			for (Class cls1 : types) {
				os[i++] = getValue(cls1);
			}
			Object newInstance = constructor.newInstance(os);
			System.out.println(newInstance);
		}
	}
	
	public static Object getValue(Class cls) {
		if (cls.isPrimitive()) {
			return 0;
		}else if(cls.isArray()) {
			if(cls.isAssignableFrom(byte[].class)) {
				return new byte[]{0,0};
			} else if(cls.isAssignableFrom(short[].class)) {
				return new short[]{0,0};
			} else if(cls.isAssignableFrom(char[].class)) {
				return new char[]{0,0};
			} else if(cls.isAssignableFrom(int[].class)) {
				return new int[]{0,0};
			} else if(cls.isAssignableFrom(long[].class)) {
				return new long[]{0,0};
			} else if(cls.isAssignableFrom(float[].class)) {
				return new float[]{0,0};
			} else if(cls.isAssignableFrom(double[].class)) {
				return new double[]{0,0};
			}
		} else if(cls.isSynthetic()) {
			return null;
		}
		return null;
	}
}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

interface NewToy{
	
}

class Toy {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
//    Toy() {//Exercise1
//    }

    Toy(int i) {
    }
}
//Exercise2
class FancyToy extends Toy
        implements HasBatteries, Waterproof, NewToy {
    FancyToy() {
        super(1);
    }
}

 class ToyTest {
    static void printInfo(Class cc) {
        print("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

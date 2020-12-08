package com.wei.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Proxy {
    private static int count;
    private static Lock lock = new ReentrantLock();
    private static void increment() {
        boolean b = lock.tryLock();
        try {
            count++;
        } finally {
            if(b) {
                lock.unlock();
            }
        }
    }
    private static final String variablePrefix = "var";
    public static Object newInstance(ClassLoader loader,
                                     Class<?>[] interfaces,
                                     InvocationHandler h)  {
        String packageName = Proxy.class.getPackage().getName();
        String className = "$Prox"+ count;
        String src = "" +
                Proxy.class.getPackage()+";\n" +
                getAllImportedInterfaces(interfaces) +"\n" +
                "public class " + className + " implements "+getCommaDelimetedInterfaceNames(interfaces)+" {\n" +
                "   private " + InvocationHandler.class.getName() + " h;\n" + getInterfaceMethodsString(interfaces) +
                "   public " + className + "(" + InvocationHandler.class.getName() + " handler) {\n" +
                "       this.h = handler;\n" +
                "   }\n" +
                "}\n";

            String useDir = System.getProperty("user.dir");
            File file = new File(useDir + "\\src\\design-pattern\\" +
                    Proxy.class.getPackage().getName().replaceAll("\\.", "/")
                    + "/"+ className +".java");
            try {
                if(!file.exists()) {
                    file.createNewFile();
                }
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)))
                    );
                    bufferedWriter.write(src);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                    StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
                    Iterable units = fileMgr.getJavaFileObjects(file.getAbsolutePath());
                    JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
                    t.call();
                    fileMgr.close();
                    URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") +"/src/main/java")};
                    //load into memory and create an instance
                    URLClassLoader ul = new URLClassLoader(urls, null);
                    System.out.println(URLClassLoader.class.getClassLoader());
                    System.out.println(ul.getParent());
                    Class c = ul.loadClass(Proxy.class.getPackage().getName() + "." + className);
                    Constructor constructor = c.getDeclaredConstructor(InvocationHandler.class);
                    return constructor.newInstance(h);
                } finally {
                    increment();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }




       return null;
    }

    private static String getAllImportedInterfaces(Class<?>[] interfaces) {
        StringBuffer buffer = new StringBuffer(20);
        for (Class<?> anInterface : interfaces) {
            buffer.append("import ");
            buffer.append(anInterface.getName());
            buffer.append(";\n");
        }
        return buffer.toString();
    }


    private static String getInterfaceMethodsString(Class[] interfaces) {
        Map<String, Object> methodMap = new HashMap<String, Object>();
        StringBuffer buffer = new StringBuffer();
        for (Class anInterface : interfaces) {
            Method[] methods = anInterface.getDeclaredMethods();
            for (Method method : methods) {
                String key = method.toString();
                Object o = methodMap.get(key);
                if (null == o) {
                    buffer.append(getOverrideMethodString(method));
                    methodMap.put(key, method);
                }
            }
        }
        methodMap.clear();
        return buffer.toString();
    }

    private static String getOverrideMethodString(Method method) {
        StringBuffer buffer = new StringBuffer();
        Class<?> returnType = method.getReturnType();
        String name = method.getName();
        Class<?> declaringClass = method.getDeclaringClass();
        Class<?>[] classes = new Class<?>[]{};
        buffer.append("" +
                "   @Override\n" +
                "   public " + returnType.getName() + " " + name +"(" + getParameterTypesVariableStr(method) +
                ")  {\n" +
                "       Object[] args = new Object[]{" + getParameterTypesVariableName(method) + "};\n" +
                "       Class<?>[] calsses = new Class<?>[]{" + getParameterClassTypesStr(method) + "};\n"+
                "       " + (returnType == Void.TYPE ? "": returnType.getName() + " value = null;\n") +
                "       try { \n" +
                "           " + Method.class.getName() + " method = " + declaringClass.getName()+ ".class.getMethod(\"" + name + "\",calsses);\n" +
                "           " + ( returnType == Void.TYPE ? "h.invoke(this,method, args)" : " value = (" + returnType.getName() + ") h.invoke(this,method, args)")
                            + ";\n" +
                "       } catch(Exception e) {\n" +
                "           throw new RuntimeException(e);\n" +
                "       }\n" +
                "       " + (returnType == Void.TYPE ? "":"return value;\n") +
                "   }\n");

        return buffer.toString();
    }

    private static String getParameterClassTypesStr(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for(int i = 0, len = parameterTypes.length; i < len; i++) {
            if (i > 0) {
                buffer.append(",");
            }
            buffer.append(parameterTypes[i].getName() + ".class" );
        }
        return buffer.toString();
    }


    private static String getParameterTypesVariableStr(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for(int i = 0, len = parameterTypes.length; i < len; i++) {
            if (i > 0) {
                buffer.append(",");
            }
            buffer.append(parameterTypes[i].getName() + " " + variablePrefix + i);
        }
        return buffer.toString();
    }

    private static String getParameterTypesVariableName(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for(int i = 0, len = parameterTypes.length; i < len; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            buffer.append(variablePrefix + i);
        }
        return buffer.toString();
    }

    private static String getCommaDelimetedInterfaceNames(Class<?>[] interfaces) {
        StringBuffer buffer = new StringBuffer(10);
        for (int i = 0, len = interfaces.length; i < len; i++) {
            if (i > 0) {
                buffer.append(",");
            }
            buffer.append(interfaces[0].getSimpleName());
        }
        return buffer.toString();
    }

}





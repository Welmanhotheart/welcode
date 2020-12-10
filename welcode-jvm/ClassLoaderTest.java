import interface_data.interface_1;
import tool.bytecode.impls.MoneyCalculaterImpl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ClassLoaderTest{
    public static void main(String[]args)throws Exception{
//        URL resource = MoneyCalculaterImpl.class.getResource("files/me.txt");
//        System.out.println(resource.getPath());
//        resource = MoneyCalculaterImpl.class.getResource("/noteBook_2018_11_07.txt");
//        System.out.println(resource.getPath());
        ClassLoader myLoader=new ClassLoader(){
            @Override
            public String toString() {
                return "myLoader";
            }

            @Override
            public Class<?>loadClass(String name)throws ClassNotFoundException{
                try{
                    String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is=getClass().getResourceAsStream(fileName);
                    if(is==null){
                        return super.loadClass(name);
                    }
                    byte[]b=new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch(IOException e){
                    throw new ClassNotFoundException(name);
                }}};
        Object obj=myLoader.loadClass("interface_data.interfaceImpl1").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof interface_1);
    }}

/**
 * myLoader.loadClass("java.lang.MyClass")
 * Exception in thread "main" java.lang.SecurityException: Prohibited package name: java.lang
 at java.lang.ClassLoader.preDefineClass(ClassLoader.java:658)
 at java.lang.ClassLoader.defineClass(ClassLoader.java:794)
 at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
 at java.net.URLClassLoader.defineClass(URLClassLoader.java:449)
 at java.net.URLClassLoader.access$100(URLClassLoader.java:71)
 at java.net.URLClassLoader$1.run(URLClassLoader.java:361)
 at java.net.URLClassLoader$1.run(URLClassLoader.java:355)
 at java.security.AccessController.doPrivileged(Native Method)
 at java.net.URLClassLoader.findClass(URLClassLoader.java:354)
 at java.lang.ClassLoader.loadClass(ClassLoader.java:425)
 at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:308)
 at java.lang.ClassLoader.loadClass(ClassLoader.java:412)
 at java.lang.ClassLoader.loadClass(ClassLoader.java:358)
 at ClassLoaderTest$1.loadClass(ClassLoaderTest.java:15)
 at ClassLoaderTest.main(ClassLoaderTest.java:23)
 */
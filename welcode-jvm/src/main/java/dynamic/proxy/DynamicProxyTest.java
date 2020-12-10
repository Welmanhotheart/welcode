package dynamic.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;

public class DynamicProxyTest{
    interface IHello{
        void sayHello();
    }
    static class Hello implements IHello{
        public void sayHello(){
            System.out.println("hello world");
        }
    }
        static class DynamicProxy implements InvocationHandler {
        Object originalObj;
        Object bind(Object originalObj){
            this.originalObj=originalObj;
            return
                    Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),originalObj.getClass().getInterfaces(),this);
        }
        public Object invoke(Object proxy, Method method, Object[]args)throws Throwable{
            System.out.println("welcome");
            return method.invoke(originalObj,args);
        }}
        public static void main(String[]args){
//            System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
            IHello hello=(IHello)new DynamicProxy().bind(new Hello());
            hello.sayHello();
            try {

                String proxyClassName = "dynamic.proxy.$Proxy0";
                String root = DynamicProxyTest.class.getClassLoader().getResource("").getPath();
                byte[] bytes = ProxyGenerator.generateProxyClass(proxyClassName, new Class[]{Class.forName("dynamic.proxy.DynamicProxyTest$IHello")});
                FileOutputStream var1 = new FileOutputStream(root + "/" + proxyClassName.replace('.', '/') + ".class");
                var1.write(bytes);
                var1.close();
            } catch (Exception e) {

            }
        }}
package tool.bytecode.tests;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import tool.bytecode.impls.MoneyCalculaterImpl;
import tool.bytecode.interfaces.MoneyCalculater;

import java.lang.reflect.Method;

public class TestCglib {
    public static void main(String[] args) {
//        OSExecute.commandJavaDecode(Enhancer.class);
        Enhancer enhancer=new Enhancer( ) ;
        enhancer.setSuperclass(MoneyCalculaterImpl.class);
        enhancer.setInterfaces(new Class[]{MoneyCalculater.class});
        enhancer.setUseCache( false) ;
        enhancer.setCallback( new MethodInterceptor( ) {
            public Object intercept(Object obj, Method method, Object[]args, MethodProxy proxy) throws Throwable{
                System.out.println("begin add");
                return proxy.invokeSuper( obj,args) ;
            }}
        ) ;
        MoneyCalculater calculater = (MoneyCalculater) enhancer.create();
        int add = calculater.add(2, 34);
        System.out.println(add);
    }
}

package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class BookFacadeCglib implements MethodInterceptor {
    private Object target;//业务类对象，供代理方法中进行真正的业务方法调用

    //相当于JDK动态代理中的绑定
    public Object getInstance(Object target) {
        //给业务对象赋值
        this.target = target;
        //创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        enhancer.setSuperclass(this.target.getClass());
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return enhancer.create();
    }
    // 实现回调方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("预处理——————");
        //调用业务类（父类中）的方法
        proxy.invokeSuper(obj, args);
        System.out.println("调用后操作——————");
        return null;
    }
}

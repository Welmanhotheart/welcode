package com.wei.proxy;
import com.wei.proxy.Moveable;

public class $Prox1 implements Moveable {
   private com.wei.proxy.InvocationHandler h;
   @Override
   public void move(com.wei.proxy.Animal var0,com.wei.proxy.Food var1,int var2)  {
       Object[] args = new Object[]{var0, var1, var2};
       Class<?>[] calsses = new Class<?>[]{com.wei.proxy.Animal.class,com.wei.proxy.Food.class,int.class};
              try { 
           java.lang.reflect.Method method = com.wei.proxy.Moveable.class.getMethod("move",calsses);
           h.invoke(this,method, args);
       } catch(Exception e) {
           throw new RuntimeException(e);
       }
          }
   public $Prox1(com.wei.proxy.InvocationHandler handler) {
       this.h = handler;
   }
}

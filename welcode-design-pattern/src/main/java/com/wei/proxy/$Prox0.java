package com.wei.proxy;
import com.wei.proxy.Animal;

public class $Prox0 implements Animal {
   private com.wei.proxy.InvocationHandler h;
   @Override
   public java.lang.String sleep(int var0)  {
       Object[] args = new Object[]{var0};
       Class<?>[] calsses = new Class<?>[]{int.class};
       java.lang.String value = null;
       try { 
           java.lang.reflect.Method method = com.wei.proxy.Animal.class.getMethod("sleep",calsses);
            value = (java.lang.String) h.invoke(this,method, args);
       } catch(Exception e) {
           throw new RuntimeException(e);
       }
       return value;
   }
   @Override
   public void eat(com.wei.proxy.Food var0,int var1)  {
       Object[] args = new Object[]{var0, var1};
       Class<?>[] calsses = new Class<?>[]{com.wei.proxy.Food.class,int.class};
              try { 
           java.lang.reflect.Method method = com.wei.proxy.Animal.class.getMethod("eat",calsses);
           h.invoke(this,method, args);
       } catch(Exception e) {
           throw new RuntimeException(e);
       }
          }
   @Override
   public void eat(com.wei.proxy.Food var0)  {
       Object[] args = new Object[]{var0};
       Class<?>[] calsses = new Class<?>[]{com.wei.proxy.Food.class};
              try { 
           java.lang.reflect.Method method = com.wei.proxy.Animal.class.getMethod("eat",calsses);
           h.invoke(this,method, args);
       } catch(Exception e) {
           throw new RuntimeException(e);
       }
          }
   public $Prox0(com.wei.proxy.InvocationHandler handler) {
       this.h = handler;
   }
}

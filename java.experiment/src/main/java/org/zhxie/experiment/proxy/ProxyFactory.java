package org.zhxie.experiment.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

  public static void main(String[] args) {
    final Caculator c = new CaculatorImpl();
    InvocationHandler handler = new InvocationHandler() {

      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method run");
        Object object = method.invoke(c, args);
        System.out.println("before method run");
        return object;
      }
    };
    Caculator newProxyInstance = (Caculator) Proxy.newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces(), handler);
    newProxyInstance.caculate(3, 2);
  }


}

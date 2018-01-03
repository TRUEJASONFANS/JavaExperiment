package org.zhxie.experiment.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyFactory {

  @SuppressWarnings("unchecked")
  public static <T> T getProxy(T object) {

    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(object.getClass());
    // 回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
    enhancer.setCallback(new CglibProxy());
    // 此刻，base不是单纯的目标类，而是增强过的目标类
    T proxyObj = (T) enhancer.create();
    return proxyObj;
  }

  static class CglibProxy implements MethodInterceptor {

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
      System.out.println("before-------------");
      proxy.invokeSuper(obj, args);
      System.out.println("after--------------");
      return null;
    }
  }

  public static void main(String[] args) {
    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "H:\\Githup\\JavaExperiment\\java.experiment\\bin");
    CaculatorImpl proxyObj = getProxy(new CaculatorImpl());
    proxyObj.caculate(3, 4);
  }
}

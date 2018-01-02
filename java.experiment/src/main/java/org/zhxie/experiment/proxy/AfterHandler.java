package org.zhxie.experiment.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class AfterHandler implements InvocationHandler {

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object object = method.invoke(proxy, args);
    handleAfter(proxy, args);
    return object;
  }

  public abstract void handleAfter(Object proxy, Object[] args);
}

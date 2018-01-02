package org.zhxie.experiment.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class BeforeHandler implements InvocationHandler {

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    handleBefore(proxy, args);
    Object object = method.invoke(proxy, args);
    return object;

  }

  public abstract void handleBefore(Object proxy, Object[] args);

}

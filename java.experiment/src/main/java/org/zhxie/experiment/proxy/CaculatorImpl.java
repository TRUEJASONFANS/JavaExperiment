package org.zhxie.experiment.proxy;

public class CaculatorImpl implements Caculator {

  public int caculate(int a, int b) {
    System.out.println("a+b=" + (a+b));
    return a+b;
  }

}

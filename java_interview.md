1. JDK&JVM&JRE 概念和区别
## 面向对象的一些问题
    1. Java抽象类和接口的区别
        * 抽象类在 Java 语言中表示的是一种继承关系，一个类只能使用一次继承关系。但是，一个类却可以实现多个接口。

        * 在抽象类中可以有自己的数据成员，也可以有非抽象的成员方法，而在接口中，只能够有静态的不能被修改的数据成员（也就是必须是static final的，不过在接口中一般不定义数据成员，接口中只能定义常量），所有的成员方法都是抽象的。

        * 抽象类和接口所反映出的设计理念不同。其实抽象类表示的是"is-a"关系，接口表示的是"like-a"关系。

        * 实现抽象类和接口的类必须实现其中的所有方法。抽象类中可以有非抽象方法。接口中则不能有实现方法。

        * 接口中定义的变量默认是publicstatic final 型，且必须给其初值，所以实现类中不能重新定义，也不能改变其值。

        * 抽象类中的变量默认是friendly 访问级别，其值可以在子类中重新定义，也可以重新赋值。

        * 接口中的方法默认都是public, abstract 类型的。

    2. 组合和继承的区别
    3. 静态变量和实例变量的区别
    4. override vs overload
    5. 知道啥设计模式？ 可以讲讲和据一些例子吗？

### 单例模式的实现几种方式
        1. 静态final 字段
        2. double check 双重锁的方式
        3. 静态类内部类（延迟加载）
        4. 枚举方式

## Spring
Spring IOC 的实现原理：
Spring 通过一个配置文件（或者基于java配置类，基于注解） 描述 Bean 及 Bean 之间的依赖关系，利用 Java 语言的反射功能实例化 Bean 并建立 Bean 之间的依赖关系。

## 考察内存模型理解

### Java是如何判断某对象是否可回收的？ 
答： 该对象到GC root节点是否存在引用路径可达
四种GC roots对象： （1） 虚拟机栈中的引用对象 （2）定义的全局静态对象 （3）常量引用 (4) JNI技术使用本地方法栈中的对象

### JVM如何做垃圾回收的？

答由垃圾回收器负责对各区进行回收，比如堆区的回收策略
	1) minor gc， 什么时候触发？ 当eden区满的时候
	2) major gc 
	3) full gc 什么时候触发？ 当老年代空间不足，方法区空间不足等

### 有没有遇到过内存泄漏问题，如何解决的？

### 有没有遇到过性能问题，如何解决的？

1. 缓存 
2. 异步调用

### JVM 对内存的抽象分为主要哪几区
1. heap (new 出来的对象存放位置）&& method area (It stores per-class structures such as the run-time constant pool, field and method data, and the code for methods and construct)
2. 线程私有隔离区：VM Stack, Native mathod stack, program counter register

### 堆又可以分为哪几个区？
young->Tenured(eden->survior->old gen)




## 考察数据结构

1. 链表和数组的区别： 时间和空间上谈， 对应其优缺点和应用场景
    1. 如何判断一个链表有环

2. Java hashMap 是基于冲突链表实现的。 影响hash map的两个因素：初始容量（初始大小）和负载因素（自动扩容的临界值） 
插入一个元素的过程是怎么样的？ 如果有两个冲突的值会怎样？

3. 对于有hash冲突的键值对， 会存在冲突链表中， 新的值是插在链表头的

4. 高阶 hashset实现：由hashMap实现

5. 寻找数组中第K小的数

  1. 快排 n*logn
  2. 改进选择算法 一次选取K个数，从中选出Kmax 复杂度n*o(K)
  3. 算法2改进， 利用K个数的最大堆算法选出kmax, 复杂度n*logK
  4. 基于快排的改进算法
  	选取S中一个元素作为枢纽元v，将集合S-{v}分割成S1和S2，就像快速排序那样
如果k <= |S1|，那么第k个最小元素必然在S1中。在这种情况下，返回QuickSelect(S1, k)。
如果k = 1 + |S1|，那么枢纽元素就是第k个最小元素，即找到，直接返回它。
否则，这第k个最小元素就在S2中，即S2中的第（k - |S1| - 1）个最小元素，我们递归调用并返回QuickSelect(S2, k - |S1| - 1)。
此算法的平均运行时间为O(n)。

## 考察操作系统

1. 线程和进程的区别
    1. 线程 share 内存， 独立的栈，局部变量，寄存器，程序计数器， 进程独占内存空间（从空间上）
    2. 线程是cpu是计算机调度的基本单位。
    3. 一个进程无法直接访问其他进程资源

## 多线程 面试题
[多线程面试题]](https://www.cnblogs.com/dolphin0520/p/3958019.html)
## spring 

What are the roles of an IOC (Inversion of Control) Container?

IOC Container does the following things-

(i) Find Beans

(ii) Identify their dependencies and wire the dependencies

(iii) Manage Lifecycle of the Bean (creation, processing, and destruction)

## 喜欢做一些什么领域或者产品，为什么？

## 当一个UI 事件响应处理函数耗时过长时候 要注意什么？

## Jdk 8

### 什么是函数式编程?


## 机试题 （主要考察代码风格）
1.字符串过滤，对于一串字符串，若该字符串中间包含“*",去掉”*"后输出；若该字符串首字符或尾字符为“*",则保留该处的“*"；若该字符不包含”*"或包含其他字符，可直接输出


测试用例
 1. ""
 2. null
 3. "*www((***))*&&(*"
 4. "*www&&*"
 5. "*www"
 6. " we2 *"
 7. ***
 8. ****
 



# javascript面试题

1. == 和 === 的区别
```
var valueOne = 3;
var valueTwo = "3";
if (valueOne === valueTwo) {
    console.log("ValueOne and ValueTwo are the same");
} else {
    console.log("ValueOne and ValueTwo are NOT the same");
}
```
2. new 一个函数返回发生了社么 ?


3. 谈谈你对es6的了解， 有哪些新特性让你欣喜？
4. typescript 呢？
5. Promise 的状态有哪些？ 用过promise吗？ 
   如何实现一个需要等待两个异步请求的异步操作？ promise.all or aync/await， 各有什么好处
   如果我需要


## 在浏览器中输入URL到页面进行渲染的过程中发生了什么

语言描述：经过了以下几步

* 浏览器解析主机名
* DNS进行域名解析，即将语义化的主机名转换成IP地址
* 浏览器获得端口号
* 浏览器根据得到的ip地址和端口号发起TCP连接
* 浏览器发起HTTP请求
* 浏览器读取服务器返回的响应报文
* 浏览器对返回的HTML进行渲染
* 浏览器断开TCP连接

1. 从这几个过程中， 如果让你想优化页面加载速度， 你能想到有些点
2. 


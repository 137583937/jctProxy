# jctProxy

> jctProxy是一种实现java代理工具包

# 代理
## 静态代理
- 手工实现代理
## 动态代理
- jdk代理
- spring aop代理

# Jctproxy原理
- 利用java编译期的注解处理器Annotation Processing
- 通过修改语法树的构建过程，重新组织目标方法，自动植入代理类
- 保留原有方法签名
- 类似lombok的实现
![image](https://user-images.githubusercontent.com/12370942/233395591-9c68482f-6c08-4ab1-884b-a154ea25acbf.png)

## 代理前
``` java
public int add(int x,int y){
    return x+y;
}


```
## 代理后

``` java
// 原有方法 => private 
// 原有方法 => add$
private int add$(int x,int y){
    return x+y;
}
// 新方法，自动插入代理
public int add(int x,int y){
    return Proxy.invoke(new ProxyReq(x,y),()->{add$(x,y)});
}

```

# 优点
- 利用注解替代手动代理
- 不会创建新的类，运行高效
- 不修改字节码，兼容性好，安全稳定，代理结果清晰可见
- 方法栈影响最小，运行高效
- 不受运行时框架影响

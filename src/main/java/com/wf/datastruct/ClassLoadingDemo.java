package com.wf.datastruct;

import java.io.File;
import java.util.stream.Stream;

public class ClassLoadingDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();


        String className = "com.wf.datastruct.User";
        /*String classFileName = className.replace('.', '/').concat(".class");
        String classPath = System.getProperty("user.dir") + "/target/classes/";
        File classFile = new File(classPath, classFileName);

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> userClass = myClassLoader.defineClass(className, classFile);*/


        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> userClass =  myClassLoader.loadClass(className);

        Class<?> userClassFromThreadContextClassLoader = classLoader.loadClass(className);
        // User.class 被 MyClassLoader 加载后，是否与线程上下文加载的 User.class 对象是否一致？
        // 这个现象能够解释 Spring spring-boot-devtools 模块 Class!=Class 问题
        System.out.println("userClass == userClassFromThreadContextClassLoader ? "
                           + (userClass == userClassFromThreadContextClassLoader));

        // 重新替换掉线程上下文 ClassLoader
        // myClassLoader -> Thread.currentThread().getContextClassLoader()
        Thread.currentThread().setContextClassLoader(myClassLoader);
        // 老的线程上下文 ClassLoader 是 MyClassLoader 的 parent，由于双亲委派，及时是 MyClassLoader 重新调用
        // loadClass(String) 方法，也不会重新加载
        Class<?> userClassFromMyClassLoader = classLoader.loadClass(className);
        System.out.println("userClass == userClassFromMyClassLoader ? " +
                           (userClass == userClassFromMyClassLoader));

        // 已加载 Class 是如何实现，目标方法： java.lang.ClassLoader.findLoadedClass0
        System.out.println(
                "userClassFromThreadContextClassLoader == userClassFromMyClassLoader ? " +
                (userClassFromThreadContextClassLoader == userClassFromMyClassLoader));
    }
}

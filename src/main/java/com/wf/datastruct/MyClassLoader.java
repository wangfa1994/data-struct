package com.wf.datastruct;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MyClassLoader  extends ClassLoader {

    public MyClassLoader() {
        // 当前线程上下文 ClassLoader 作为 Parent
        super(Thread.currentThread().getContextClassLoader());
    }

    // 文件 -> 定义某个 Class
    public Class<?> defineClass(String name, File classFile) {
        String className = "com.wf.datastruct.User";
        String classFileName = className.replace('.', '/').concat(".class");
        String classPath = System.getProperty("user.dir") + "/target/classes/";
         classFile = new File(classPath, classFileName);
        // File classFile -> byte[]
        byte[] bytes = loadBytes(classFile);
        // 利用 ClassLoader defineClass 方法来定义 Class
        // 可用于动态加载
        return super.defineClass(name, bytes, 0, bytes.length);

    }

    private byte[] loadBytes(File classFile) {
        byte[] bytes = null;
        try {
            bytes = FileUtils.readFileToByteArray(classFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bytes;
    }
}

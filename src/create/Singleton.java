package create;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/17
 */
public class Singleton {
}
//饿汉式（线程安全，空间换时间）
class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1 (){
    }
    public static Singleton1 getInstance() {
        return instance;
    }
}
//直接懒汉式（线程不安全，时间换空间）
class Singleton2 {
    private static Singleton2 instance;
    private Singleton2 (){
    }
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

//直接加锁的懒汉式（线程安全，时间换空间）
class Singleton3 {
    private static Singleton3 instance;
    private Singleton3 (){
    }
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

//双重检查的懒汉式(可以思考一下为啥要这样子,包括双重检查和volatile关键字)
class Singleton4 {
    private volatile static Singleton4 instance;
    private Singleton4 (){
    }
    public static Singleton4 getInstance() {
        if (instance== null) {
            synchronized (Singleton4.class) {
                if (instance== null) {
                    instance= new Singleton4();
                }
            }
        }
        return instance;
    }
}

//静态内部类（利用虚拟机加载类只加载一次的特性，关于类加载可以看看我写的ClassLoader类详解，JVM并发编程详解上面认为是最好的方法）
class Singleton5 {
    private Singleton5(){
    }
    public static Singleton5 getInstance(){
        return SingletonHolder.sInstance;
    }
    private static class SingletonHolder {
        private static final Singleton5 sInstance = new Singleton5();
    }
}

//枚举(利用默认枚举实例的创建是线程安全的，并且在任何情况下都是单例)
enum Singleton6 {
    INSTANCE;
    public void doSomeThing() {
    }
    public static Singleton6 getInstance(){
        return INSTANCE;
    }
}

//容器（利用map的key的唯一性）
class Singleton7 {
    private static Map<String, Object> objMap = new HashMap<String,Object>();
    private Singleton7() {
    }
    public static void registerService(String key, Object instance) {
       if (!objMap.containsKey(key) ) {
        objMap.put(key, instance) ;
        }
    }
    public static Object getService(String key) {
        return objMap.get(key) ;
    }
}
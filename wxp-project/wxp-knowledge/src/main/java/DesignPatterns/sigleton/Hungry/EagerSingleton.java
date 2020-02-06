package DesignPatterns.sigleton.Hungry;

/**
 * 饿汉式单例类
 * 在定义静态变量的时候实例化单例类，因此在类加载的时候就已经
 创建了单例对象
 */
public class EagerSingleton {
    private static EagerSingleton singleton=new EagerSingleton();

    public static EagerSingleton getSingleton(){
        return singleton;
    }
}

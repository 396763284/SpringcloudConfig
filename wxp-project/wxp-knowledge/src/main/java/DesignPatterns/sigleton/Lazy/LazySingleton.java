package DesignPatterns.sigleton.Lazy;
/**
 * 懒汉
 *
 */
public class LazySingleton {
    private static LazySingleton singleton=null;

    public static LazySingleton getSingleton(){
        if(singleton==null){
            synchronized(LazySingleton.class){
                if(singleton==null){ //线程B处于排队等待状态,防止线程B 继续执行
                    singleton=new LazySingleton();
                }
            }
        }
        return singleton;
    }
}

package DesignPatterns.Observer;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-26 15:45
 */
public class SUbjectCenter extends Subject {


    public SUbjectCenter(String name){
        this.allyName=name;
    }

    /**
     *  调用观察者的业务方法
     */
    @Override
    public void notifyPlayer() {
        for (Observer observer:list) {
            observer.help();
        }
    }

    /**
     *  调用观察者的业务方法
     */
    @Override
    public void notifyshareholder() {
        for (Observer observer:list) {
            observer.receive(this.count);
        }
    }
}

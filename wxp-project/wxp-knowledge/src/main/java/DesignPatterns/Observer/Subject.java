package DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-26 15:36
 */
abstract class Subject {
    protected String allyName;
    protected int count;
    protected  List<Observer> list= new ArrayList<Observer>();

    public int getCount(){
        return this.count;
    }

    public void setCount(int count){
        this.count=count;
    }

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public void attach(Observer observer){
        System.out.println(observer.getName()+"加入系统"+this.allyName);
        list.add(observer);
    }

    public void detach(Observer observer){
        System.out.println(observer.getName()+"离开系统"+this.allyName);
        list.remove(observer);
    }

    //通知其他玩家
    public abstract void notifyPlayer( );


    //通知股东
    public abstract void notifyshareholder();
}

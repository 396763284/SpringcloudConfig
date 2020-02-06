package DesignPatterns.Observer;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-26 15:40
 */
public class Player implements Observer {

    private String name;
    private int count;

    public Player(String name){
        this.name=name;
    }

    public Player(String name,int count){
        this.name=name;
        this.count=count;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void setCount() {
        this.count = count;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void help() {
        // 具体业务代码
        System.out.println("坚持住，" + this.name + "来救你！");
    }

    @Override
    public void receive(int count) {
        System.out.println("通知用户：" + this.name + "—— 股票的价格为："+count);
    }



    @Override
    public void beChanged(Subject subject) {

        System.out.println("股票"+this.name + "发生变化！现在为："+this.count);
        subject.notifyshareholder();
    }

    @Override
    public void beAttcked(Subject subject) {
        System.out.println(this.name + "被攻击！");
        subject.notifyPlayer();
    }
}

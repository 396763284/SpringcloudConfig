package DesignPatterns.Observer;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-26 16:20
 */
public class ClientTest {
    public static void main(String[] args) {
        Observer ob1,ob2,ob3;
        ob1=new Player("玩家1");
        ob2=new Player("玩家2");
        ob3=new Player("玩家3");

        Subject subject=new SUbjectCenter("组队1");
        subject.attach(ob1);
        subject.attach(ob2);
        subject.attach(ob3);

        ob1.beAttcked(subject);


        Observer sh1,sh2,sh3;
        sh1=new Player("股民1");
        sh2=new Player("股民2");
        sh3=new Player("股民3");

        Subject subject1=new SUbjectCenter("股票1");
        subject1.attach(sh1);
        subject1.attach(sh2);
        subject1.attach(sh3);

        subject1.setCount(30);
        subject1.notifyshareholder();

    }
}

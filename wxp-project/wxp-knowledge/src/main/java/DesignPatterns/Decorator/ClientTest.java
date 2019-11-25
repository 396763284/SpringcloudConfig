package DesignPatterns.Decorator;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 11:17
 */
public class ClientTest {
    public static void main(String[] args) {
        ComponentDecorator cd= new ScrollBarDecorator(new Window());

        cd.display();
    }
}

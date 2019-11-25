package DesignPatterns.Decorator;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 11:16
 */
public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    public void display() {
        setBlackBorder();
        super.display();
    }

    public void setBlackBorder()
    {
        System.out.println("为构件黑色边框！");
    }
}

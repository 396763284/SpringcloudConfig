package DesignPatterns.Decorator;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 11:15
 */
public class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }
    public void display() {
        setScrollBar();
        super.display();
    }

    public void setScrollBar()
    {
        System.out.println("为构件增加滚动条！");
    }

}

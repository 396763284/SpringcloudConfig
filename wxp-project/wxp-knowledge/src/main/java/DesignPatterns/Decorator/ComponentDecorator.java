package DesignPatterns.Decorator;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 11:13
 */
public class ComponentDecorator extends Component {

    private Component component;

    public ComponentDecorator(Component component){
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}

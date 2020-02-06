package DesignPatterns.Factory.abstractFactory;

public class IOSOperationController implements OperationController {
    @Override
    public void operationMethod() {
        System.out.println("ios OperationController");
    }
}

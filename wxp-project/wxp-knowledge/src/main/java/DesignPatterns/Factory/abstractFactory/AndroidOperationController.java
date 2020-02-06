package DesignPatterns.Factory.abstractFactory;

public class AndroidOperationController implements OperationController {
    @Override
    public void operationMethod() {
        System.out.println(" Android operation");
    }
}

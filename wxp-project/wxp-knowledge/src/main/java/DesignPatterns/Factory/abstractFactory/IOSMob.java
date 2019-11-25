package DesignPatterns.Factory.abstractFactory;

public class IOSMob implements MobFactory {
    @Override
    public InterfaceController createInterfaceController() {
        InterfaceController interfaceController=new IOSInterfaceController();
        return interfaceController;
    }

    @Override
    public OperationController createOperationControllerFactory() {
        OperationController operationController=new IOSOperationController();
        return operationController;
    }
}

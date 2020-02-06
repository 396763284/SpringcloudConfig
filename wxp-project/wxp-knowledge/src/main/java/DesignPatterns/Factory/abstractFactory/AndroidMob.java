package DesignPatterns.Factory.abstractFactory;

public class AndroidMob implements MobFactory {
    @Override
    public InterfaceController createInterfaceController() {
        InterfaceController interfaceController =new AndroidInterfaceController();
        return interfaceController;
    }

    @Override
    public OperationController createOperationControllerFactory() {
        OperationController operationController=new AndroidOperationController();

        return operationController;
    }
}

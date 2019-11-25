package DesignPatterns.Factory.abstractFactory;

public interface MobFactory {

    InterfaceController createInterfaceController ();

    OperationController createOperationControllerFactory();

}

package DesignPatterns.Factory.abstractFactory;

public class TestClient {
    public static void main(String[] args) {
        MobFactory mob = new AndroidMob();
        OperationController ope= mob.createOperationControllerFactory();
        InterfaceController intfac=mob.createInterfaceController();
        ope.operationMethod();
        intfac.interfaceMethod();
    }
}

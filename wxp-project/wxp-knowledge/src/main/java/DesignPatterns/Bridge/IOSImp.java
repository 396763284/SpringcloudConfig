package DesignPatterns.Bridge;

public class IOSImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("IOS");
    }
}

package DesignPatterns.Bridge;

public class WindowsImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("Windows");
    }
}

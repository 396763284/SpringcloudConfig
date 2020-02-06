package DesignPatterns.Bridge;

public class UnixImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("Unix");
    }
}

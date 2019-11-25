package DesignPatterns.Factory.methodFactory;

public class DbLogger  implements  Logger{
    @Override
    public void printLogger() {
        System.out.println("db logger");
    }
}

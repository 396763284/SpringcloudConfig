package DesignPatterns.Factory.methodFactory;

public class FileLogger implements Logger{
    @Override
    public void printLogger() {
        System.out.println("file logger");
    }
}

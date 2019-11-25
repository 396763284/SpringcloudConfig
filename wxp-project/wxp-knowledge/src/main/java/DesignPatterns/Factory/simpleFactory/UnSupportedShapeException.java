package DesignPatterns.Factory.simpleFactory;

public class UnSupportedShapeException extends  Exception {

    public UnSupportedShapeException(String msg){
        super(msg);
    }
}

package DesignPatterns.Factory.methodFactory;

public class ClientTest {

    public static void main(String[] args) {
        LoggerFactory loggerFactory =new FileLoggerFactory();
        Logger logger=loggerFactory.createLogger();
        logger.printLogger();
    }
}

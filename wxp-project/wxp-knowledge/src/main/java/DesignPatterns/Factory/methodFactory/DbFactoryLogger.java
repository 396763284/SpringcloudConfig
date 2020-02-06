package DesignPatterns.Factory.methodFactory;

public class DbFactoryLogger implements LoggerFactory {
    @Override
    public Logger createLogger() {
        Logger logger= new DbLogger();
        return  logger;
    }
}

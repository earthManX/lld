
public class Logger {

    private volatile static Logger logger;
    private volatile static AbstractLevelLogger abstractLevelLogger;
    private volatile static Publisher publisher;
    private volatile static Strategy strategy;

    private Logger(){}

    public static Logger getInstance(){
        if(  logger == null){
            synchronized( Logger.class ){
                if( logger == null ) {
                    logger = new Logger();
                    abstractLevelLogger = LogManager.createLevelLoggers();
                    publisher = LogManager.getPublisher();
                    strategy = new AStrategy();
                }
            }
        }
        return logger;

    }

    public void logMessage( int level, String message){
        abstractLevelLogger.logMessage( level, message, publisher, strategy);
    }
    
}

public abstract class AbstractLevelLogger {
    
    int level;
    AbstractLevelLogger nextLogger;
    // Constructor

    abstract void log( String message, Publisher publisher, Strategy strategy);

    protected void logMessage( int level, String message, Publisher publisher, Strategy strategy){
        if( this.level <= level){
            log(message , publisher, strategy);
        }
        if( nextLogger != null){
            nextLogger.logMessage(level, message, publisher, strategy);
        }
    }

    public void setNextLogger( AbstractLevelLogger levelLogger){
        this.nextLogger = levelLogger;
    }

}

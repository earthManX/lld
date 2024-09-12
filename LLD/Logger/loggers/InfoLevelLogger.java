public class InfoLevelLogger extends AbstractLevelLogger {

    InfoLevelLogger( int level ){
        this.level = level;
    }

    @Override
    void log(String message, Publisher publisher, Strategy strategy) {
        publisher.publishToSubscribers(level, strategy.format("INFO - " + message));
    }
    
}

public class DebugLevelLogger extends AbstractLevelLogger{
    

    DebugLevelLogger( int level ){
        this.level = level;
    }

    @Override
    void log(String message, Publisher publisher, Strategy strategy) {
        publisher.publishToSubscribers(level, strategy.format("DEBUG : " + message));
    }
}

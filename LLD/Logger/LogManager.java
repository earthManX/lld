public class LogManager {
    
    public static AbstractLevelLogger createLevelLoggers(){

        AbstractLevelLogger infoLevelLogger = new InfoLevelLogger( 1 );
        AbstractLevelLogger debugLevelLogger = new DebugLevelLogger( 2 );
        infoLevelLogger.setNextLogger(debugLevelLogger);
        return infoLevelLogger;

    }

    public static Publisher getPublisher(){
        Publisher pub = new Publisher();
        pub.addSubcriber( 1 , new FileLogSubscriber());
        pub.addSubcriber(2 , new ConsoleSubscriber());
        pub.addSubcriber( 1 , new ConsoleSubscriber());
        return pub;

    }    

}

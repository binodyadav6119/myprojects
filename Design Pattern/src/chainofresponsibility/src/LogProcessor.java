public abstract class LogProcessor {
    public static int INFO =1;
    public static int DEBUG=2;
    public static int ERROR=3;
    LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor logProcessor)
    {
        this.nextLogProcessor = logProcessor;
    }

    public void log(int level, String message)
    {
        if(nextLogProcessor!=null)
        {
            nextLogProcessor.log(level,message);
        }
    }
}

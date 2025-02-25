public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int level, String message)
    {
        if(level==INFO)
        {
            System.out.println("INFO :"+message);
        }
        else
        {
            super.log(level,message);
        }
    }
}

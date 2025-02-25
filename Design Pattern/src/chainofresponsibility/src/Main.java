public class Main {
    public static void main(String[] args) {

        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.INFO,"info of message");
        logProcessor.log(LogProcessor.DEBUG,"debug log processor");
        logProcessor.log(LogProcessor.ERROR,"error of log processor");
        System.out.println("Hello world!");
    }
}
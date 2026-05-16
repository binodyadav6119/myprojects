package terminal;

public class CommandFactory {

    public static Command createCommand(ParsedCommand parsedCommand) {

        String name = parsedCommand.getCommandName();

        switch (name) {

            case "pwd":
                return new PwdCommand();

            case "cd":
                return new CdCommand(parsedCommand);

            case "echo":
                return new EchoCommand(parsedCommand);

            default:
                return new ExternalCommand(parsedCommand);
        }
    }
}

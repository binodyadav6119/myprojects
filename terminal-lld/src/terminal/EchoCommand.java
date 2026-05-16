package terminal;

public class EchoCommand implements Command {

    private final ParsedCommand parsedCommand;

    public EchoCommand(ParsedCommand parsedCommand) {
        this.parsedCommand = parsedCommand;
    }

    @Override
    public CommandResult execute(ShellContext context) {

        String output = String.join(" ", parsedCommand.getArguments());

        return new CommandResult(0, output, "");
    }
}

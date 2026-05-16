package terminal;

public class CommandExecutor {

    public CommandResult execute(
            ParsedCommand parsedCommand,
            ShellContext context
    ) {

        try {

            Command command = CommandFactory.createCommand(parsedCommand);

            return command.execute(context);

        } catch (Exception e) {

            return new CommandResult(
                    1,
                    "",
                    e.getMessage()
            );
        }
    }
}

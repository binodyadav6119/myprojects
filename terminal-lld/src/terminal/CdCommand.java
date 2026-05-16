package terminal;

import java.nio.file.Path;

public class CdCommand implements Command {

    private final ParsedCommand parsedCommand;

    public CdCommand(ParsedCommand parsedCommand) {
        this.parsedCommand = parsedCommand;
    }

    @Override
    public CommandResult execute(ShellContext context) {

        if (parsedCommand.getArguments().isEmpty()) {
            return new CommandResult(1, "", "Path missing");
        }

        try {

            Path path = context.getCurrentDirectory()
                    .resolve(parsedCommand.getArguments().get(0))
                    .normalize();

            context.setCurrentDirectory(path);

            return new CommandResult(0, "", "");

        } catch (Exception e) {
            return new CommandResult(1, "", e.getMessage());
        }
    }
}

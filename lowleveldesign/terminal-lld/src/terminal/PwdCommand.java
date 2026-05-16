package terminal;

public class PwdCommand implements Command {

    @Override
    public CommandResult execute(ShellContext context) {
        return new CommandResult(
                0,
                context.getCurrentDirectory().toString(),
                ""
        );
    }
}

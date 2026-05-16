package terminal;

public interface Command {
    CommandResult execute(ShellContext context) throws Exception;
}

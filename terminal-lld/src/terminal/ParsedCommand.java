package terminal;

import java.util.ArrayList;
import java.util.List;

public class ParsedCommand {

    private String commandName;
    private List<String> arguments = new ArrayList<>();

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}

package terminal;

import java.util.Arrays;

public class CommandParser {

    public ParsedCommand parse(String input) {

        String[] tokens = input.trim().split("\\s+");

        ParsedCommand parsedCommand = new ParsedCommand();

        if (tokens.length > 0) {
            parsedCommand.setCommandName(tokens[0]);
        }

        if (tokens.length > 1) {
            parsedCommand.setArguments(
                    Arrays.asList(tokens).subList(1, tokens.length)
            );
        }

        return parsedCommand;
    }
}

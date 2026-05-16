package terminal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExternalCommand implements Command {

    private final ParsedCommand parsedCommand;

    public ExternalCommand(ParsedCommand parsedCommand) {
        this.parsedCommand = parsedCommand;
    }

    @Override
    public CommandResult execute(ShellContext context) throws Exception {

        List<String> command = new ArrayList<>();

        command.add(parsedCommand.getCommandName());
        command.addAll(parsedCommand.getArguments());

        ProcessBuilder processBuilder = new ProcessBuilder(command);

        processBuilder.directory(context.getCurrentDirectory().toFile());

        Process process = processBuilder.start();

        BufferedReader outputReader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        );

        BufferedReader errorReader = new BufferedReader(
                new InputStreamReader(process.getErrorStream())
        );

        StringBuilder output = new StringBuilder();
        StringBuilder error = new StringBuilder();

        String line;

        while ((line = outputReader.readLine()) != null) {
            output.append(line).append("\n");
        }

        while ((line = errorReader.readLine()) != null) {
            error.append(line).append("\n");
        }

        int exitCode = process.waitFor();

        return new CommandResult(
                exitCode,
                output.toString(),
                error.toString()
        );
    }
}

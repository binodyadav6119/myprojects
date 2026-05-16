package terminal;

import java.util.Scanner;

public class Terminal {

    private final CommandParser parser;
    private final CommandExecutor executor;
    private final ShellContext context;

    public Terminal() {
        this.parser = new CommandParser();
        this.executor = new CommandExecutor();
        this.context = new ShellContext();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("terminal> ");

            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input.trim())) {
                break;
            }

            ParsedCommand parsedCommand = parser.parse(input);

            CommandResult result = executor.execute(
                    parsedCommand,
                    context
            );

            if (!result.getOutput().isEmpty()) {
                System.out.println(result.getOutput());
            }

            if (!result.getError().isEmpty()) {
                System.err.println(result.getError());
            }
        }
    }

    public static void main(String[] args) {
        new Terminal().start();
    }
}

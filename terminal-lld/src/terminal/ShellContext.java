package terminal;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ShellContext {

    private Path currentDirectory;
    private final Map<String, String> environmentVariables;

    public ShellContext() {
        this.currentDirectory = Paths.get(System.getProperty("user.dir"));
        this.environmentVariables = new HashMap<>();
    }

    public Path getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(Path currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public Map<String, String> getEnvironmentVariables() {
        return environmentVariables;
    }
}

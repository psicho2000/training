// #!/usr/local/jdk-14+36-hotspot/bin/java --source 11
// vi: syntax=java
/*
 * Usage
 * 1. Uncomment shebang
 * 2. Rename filename to ShebangExample (i.e. without extension `.java`)
 * 3. Assign executable rights
 * 4. Call using `cat inputfile | ./ShebangExample`
 * Editing
 * In vi, setting `:set syntax=java` helps as we have no file extension
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ShebangExample {

    public static void main(String[] args) throws IOException {
        var lines = readInput();
        // modify the stream according to command line options
        for (var arg : args) {
            lines = modifyStream(arg, lines);
        }
        lines.forEach(System.out::println);
    }

    private static Stream<String> readInput() throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        if (!reader.ready())
            return Stream.empty();
        else
            return reader.lines();
    }

    private static Stream<String> modifyStream(String arg, Stream<String> input) {
        switch (arg) {
            case "--sort":
                return input.sorted();
            case "--unique":
                return input.distinct();
            default: {
                System.out.println("Unknown argument '" + arg + "'.");
                return input;
            }
        }
    }

}

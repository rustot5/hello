package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestingUtils {
    public static String catchStdout(Runnable code) {
        ByteArrayOutputStream stdout = new ByteArrayOutputStream();
        PrintStream saveStdout = System.out;
        try {
            System.setOut(new PrintStream(stdout));
            code.run();
        } finally {
            System.setOut(saveStdout);
        }
        return stdout.toString();
    }

    private TestingUtils() {
        // It's a utility class
    }
}

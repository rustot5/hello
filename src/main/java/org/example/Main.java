package org.example;

/**
 * Just storage for the entry point. Bureaucracy.
 */
public final class Main {
    /**
     * The entry point.
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        if (args.length == 0 || !args[0].matches("-*dry-run")) {
            Hello hello = new Hello();
            System.out.println(hello.doIt());
        }
    }

    private Main() {
        // It's a utility class
    }
}

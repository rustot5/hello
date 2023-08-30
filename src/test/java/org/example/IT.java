package org.example;

import org.junit.jupiter.api.Test;

import static org.example.TestingUtils.catchStdout;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IT {
    @Test
    public void testMain() {
        String stdout = catchStdout(() -> {
            Main.main(new String[0]);
        });
        assertEquals(Utils.HELLO_MESSAGE + System.lineSeparator(), stdout);
    }

    @Test
    public void testDryRun() {
        String stdout = catchStdout(() -> {
            Main.main(new String[]{"--dry-run"});
        });
        assertEquals("", stdout);
    }

    @Test
    public void testWrongParam() {
        String stdout = catchStdout(() -> {
            Main.main(new String[]{"qwe"});
        });
        assertEquals(Utils.HELLO_MESSAGE + System.lineSeparator(), stdout);
    }
}

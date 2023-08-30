package org.example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import static org.example.TestingUtils.catchStdout;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class MainTest {
    @Test
    public void testMain() {
        try (MockedConstruction<Hello> mocks = Mockito.mockConstruction(Hello.class, (mock, context) -> {
            when(mock.doIt()).thenReturn("Bye!");
        })) {
            String stdout = catchStdout(() -> {
                Main.main(new String[0]);
                Main.main(new String[]{"qwe"});
            });
            assertEquals("Bye!" + System.lineSeparator() + "Bye!" + System.lineSeparator(), stdout);
            assertEquals(2, mocks.constructed().size());
            for (Hello mock : mocks.constructed()) {
                verify(mock).doIt();
                verifyNoMoreInteractions(mock);
            }
        }
    }

    @Test
    public void testDryRun() {
        String stdout = catchStdout(() -> {
            Main.main(new String[]{"--dry-run"});
        });
        assertEquals("", stdout);
    }
}
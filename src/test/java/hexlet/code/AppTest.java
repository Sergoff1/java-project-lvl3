package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void testmain() {
        Assertions.assertEquals("Hello World!", App.hello());
    }
}

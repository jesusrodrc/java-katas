import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeypadTest {
    @Test
    public void simpleTest() {
        assertEquals(9, Keypad.presses("VNiaOMfKeX!:dwNi$"));
        assertEquals(13, Keypad.presses("HOW R U"));
    }
}
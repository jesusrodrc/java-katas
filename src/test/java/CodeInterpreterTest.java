import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CodeInterpreterTest {

    @Test
    public void testEchoUntilByte255Encountered() {
        assertThat(new CodeInterpreter(",+[-.,+]").process("Codewars" + ((char) 255)), is("Codewars"));
    }

    @Test
    public void testEchoUntilByte0Encountered() {
        assertThat(new CodeInterpreter(",[.[-],]").process("Codewars" + ((char) 0)), is("Codewars"));
    }

    @Test
    public void testTwoNumbersMultiplier() {
        assertThat(new CodeInterpreter("+>+>,-[-[->+<]<<[->>>>+>+<<<<<]>[->>>>>+>+<<<<<<]>>>[-<<<<+>>>>]>[-<<<+>>>]>[-<<<<<+>>>>>]>[-<<<<<+>>>>>]<<<<]")
                        .process("1"),
                is("1, 1, 2, 3, 5, 8, 13, 21, 34, 55"));
    }
}
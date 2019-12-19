import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExpandedNumberTest {

    @Test
    public void testExpandableNumbers() {
        assertEquals("10 + 2", ExpandedNumber.expandedForm(12));
        assertEquals("40 + 2", ExpandedNumber.expandedForm(42));
        assertEquals("70000 + 300 + 4", ExpandedNumber.expandedForm(70304));
    }

    @Test
    public void testNonExpandableNumbers() {
        assertEquals("10", ExpandedNumber.expandedForm(10));
        assertEquals("40", ExpandedNumber.expandedForm(40));
        assertEquals("70000", ExpandedNumber.expandedForm(70000));
    }
}
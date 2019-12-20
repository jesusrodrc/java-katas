import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaginationHelperTest {
    
    private static List<String> STRINGS = Arrays.asList("ho", "ha", "he", "hi", "ho", "hu");
    private static List<Integer> INTEGERS = Arrays.asList(1,2,3,4,5,6,7);
    private PaginationHelper<String> stringPagination;
    private PaginationHelper<Integer> intPagination;
    
    @Before
    public void setUp() {
        stringPagination = new PaginationHelper<>(STRINGS,3);
        intPagination = new PaginationHelper<>(INTEGERS, 3);
    }
    
    @Test
    public void testItemCount() {
        assertEquals(stringPagination.itemCount(), STRINGS.size());
        assertEquals(intPagination.itemCount(), INTEGERS.size());
    }

    @Test
    public void testPageCount() {
        assertEquals(2, stringPagination.pageCount());
        assertEquals(3, intPagination.pageCount());
    }

    @Test
    public void testPageItemCount() {
        assertEquals(3, stringPagination.pageItemCount(1));
        assertEquals(1, intPagination.pageItemCount(2));
    }

    @Test
    public void testPageIndex() {
        assertEquals(-1, stringPagination.pageIndex(10));
        assertEquals(1, stringPagination.pageIndex(5));
        assertEquals(0, intPagination.pageIndex(2));
    }

}
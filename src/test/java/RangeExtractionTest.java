import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RangeExtractionTest {

    @Test
    public void separatedElements() {
        assertEquals("1,3,5", RangeExtraction.rangeExtraction(new int[] {1,3,5}));
    }

    @Test
    public void fewContiguousElements() {
        assertEquals("1,2", RangeExtraction.rangeExtraction(new int[] {1,2}));
    }

    @Test
    public void manyContiguousElements() {
        assertEquals("1-6", RangeExtraction.rangeExtraction(new int[] {1,2,3,4,5,6}));
    }

    @Test
    public void testRangeExtraction() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", RangeExtraction
                .rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,
                14,15,17,18,19,20}));
        assertEquals("-3--1,2,10,15,16,18-20", RangeExtraction.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
    }

}
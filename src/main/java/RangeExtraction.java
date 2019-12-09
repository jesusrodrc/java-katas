/*
A format for expressing an ordered list of integers is to use a comma separated list of either individual integers
or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.

The range includes all integers in the interval including both endpoints.
It is not considered a range unless it spans at least 3 numbers.
For example ("12, 13, 15-17")

Complete the solution so that it takes a list of integers in increasing order and returns a correctly
formatted string in the range format.
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class RangeExtraction {

    public static String rangeExtraction(int[] arr) {
        StringJoiner joiner = new StringJoiner(",");
        ArrayDeque<Integer> deque = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        while (!deque.isEmpty()) {
            int first = deque.pop();
            int rangeEnd = calculateRangeEnd(first, deque);
            joiner.add(formatRangeString(first, rangeEnd));
        }
        return joiner.toString();
    }

    private static String formatRangeString(int first, int rangeEnd) {
        if (first == rangeEnd) {
            return "" + first;
        } else if (rangeEnd - first >= 2) {
            return first + "-" + rangeEnd;
        } else {
            return "" + first + "," + rangeEnd;
        }
    }

    private static int calculateRangeEnd(int previous, ArrayDeque<Integer> deque) {
        if (!deque.isEmpty() && deque.peek() == previous+1) {
            return calculateRangeEnd(deque.pop(), deque);
        } else {
            return previous;
        }
    }

}

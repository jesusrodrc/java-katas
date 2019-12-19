/*
Kata from CodeWars: Write Number in Expanded Form
Write Number in Expanded Form
You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
NOTE: All numbers will be whole numbers greater than 0.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpandedNumber {

    public static String expandedForm(int num)
    {
       return String.join(" + ", recursiveExpandedForm(num));
    }

    public static List<String> recursiveExpandedForm(int num) {
        if (num == 0) {
            return Arrays.asList("");
        } else {
            String numberString = Integer.toString(num);
            String decompositionStep = numberString.substring(0,1) + "0".repeat(numberString.length() - 1);
            List<String> result = new ArrayList<>();
            result.add(decompositionStep);
            String remainingDigits = numberString.substring(1);
            if (!remainingDigits.isBlank()) {
                result.addAll(recursiveExpandedForm(Integer.parseInt(remainingDigits)).stream().
                        filter(s -> !s.isBlank()).collect(Collectors.toList()));
            }
            return result;
        }
    }
}

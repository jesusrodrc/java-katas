import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {
        List<String> resultList =
               Arrays.stream(array1).filter(s -> isInOriginalArray(s, array2)).collect(Collectors.toList());
        String[] resultArray = new String[resultList.size()];
        Collections.sort(resultList);
        return resultList.toArray(resultArray);
    }

    private static boolean isInOriginalArray(String stringToCheck, String[] array) {
       return Arrays.stream(array).map(s -> s.contains(stringToCheck)).anyMatch(b -> b);
    }

}

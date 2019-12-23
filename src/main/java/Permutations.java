import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static List<String> singlePermutations(String s) {
        Character[] currentSolution = new Character[s.length()];
        Arrays.fill(currentSolution, null);
        return recursiveSinglePermutations(currentSolution, s);
    }

    private static List<String> recursiveSinglePermutations(Character[] currentSolution, String s) {
        if (s.length() == 0) {
            return Arrays.asList(Arrays.stream(currentSolution).map(String::valueOf).collect(Collectors.joining()));
        }
        char character = s.substring(0, 1).toCharArray()[0];
        String remainder = s.substring(1);
        List<String> results = new ArrayList<>();
        for (int i = 0; i<currentSolution.length; i++) {
            if (currentSolution[i] == null) {
                Character[] copyOfCurrentSolution = Arrays.copyOf(currentSolution, currentSolution.length);
                copyOfCurrentSolution[i] = character;
                results.addAll(recursiveSinglePermutations(copyOfCurrentSolution, remainder));
            }
        }
        List<String> deduplicatedStrings = new ArrayList<>();
        for (String result : results) {
            if (!deduplicatedStrings.contains(result)) {
                deduplicatedStrings.add(result);
            }
        }
        return deduplicatedStrings;
    }

}

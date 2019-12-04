import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SpinWords {

    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        List<String> resultList = new ArrayList<>();
        for (String word: words) {
            if (word.length() > 4) {
                resultList.add(reverseWord(word));
            } else {
                resultList.add(word);
            }
        }
        return String.join(" ", resultList);
    }

    private String reverseWord(String word) {
        Stack<Character> characterStack = new Stack<>();
        for (Character c : word.toCharArray()) {
            characterStack.push(c);
        }
        StringBuilder result = new StringBuilder();
        while(!characterStack.isEmpty()) {
            result.append(characterStack.pop());
        }
        return result.toString();
    }
}
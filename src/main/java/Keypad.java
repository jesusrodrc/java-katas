import java.util.Arrays;
import java.util.List;

public class Keypad {

    public static int presses(String phrase) {
        int counter = 0;
        for (char c : phrase.toCharArray()) {
            counter = counter + KeyBoardLayout.calculateNumber(c);
        }
        return counter;
    }

    public enum KeyBoardLayout {
        FIRST(null, null, null, "1", null),
        SECOND("A", "B", "C", "2", null),
        THIRD("D", "D", "F", "3", null),
        FOURTH("G", "H", "I", "4", null),
        FIFTH("J", "K", "L", "5", null),
        SIXTH("M", "N", "O", "6", null),
        SEVENTH("P", "Q", "R", "S", "7"),
        EIGHTH("T", "U", "V", "8", null),
        NINTH("W", "X", "Y", "Z", "9"),
        TENTH("*", null, null, null, null),
        ELEVENTH(" ", "0", null, null, null),
        TWELFTH("#", null, null, null, null);

        private String firstElement;
        private String secondElement;
        private String thirdElement;
        private String fourthElement;
        private String fifthElement;

        KeyBoardLayout(String firstElement, String secondElement, String thirdElement, String fourthElement,
                       String fifthElement) {
            this.firstElement = firstElement;
            this.secondElement = secondElement;
            this.thirdElement = thirdElement;
            this.fourthElement = fourthElement;
            this.fifthElement = fifthElement;
        }

        public List<String> getAllElements() {
            return Arrays.asList(firstElement, secondElement, thirdElement, fourthElement);
        }

        public static int calculateNumber(char character) {
            String characterString = "" + Character.toUpperCase(character);
            for (KeyBoardLayout key: KeyBoardLayout.values()) {
                int i = 1;
                for (String element : key.getAllElements()) {
                    if (element != null && element.equals(characterString)) {
                        return i;
                    }
                    i++;
                }
            }
            return 0;
        }
    }

}

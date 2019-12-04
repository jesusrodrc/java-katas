import java.util.ArrayList;
import java.util.List;

public class LineNumbering {

    public static List<String> number(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add((result.size() + 1) + ": "+ line);
        }
        return result;
    }
}

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DataReverse {

    private static AtomicInteger counter = new AtomicInteger();

    public static int[] DataReverse(int[] data) {
        //get bytes
        counter.set(0);
        List<Integer> copyOfData = new ArrayList<>();
        Arrays.stream(data).forEach(copyOfData::add);
        Collection<List<Integer>> bytesList =
                copyOfData.stream().collect(Collectors.groupingBy(it -> counter.getAndIncrement()/8)).values();
        Stack<List<Integer>> byteStack = new Stack<>();
        bytesList.forEach(byteStack::push);
        int[] result = new int[data.length];
        int i = 0;
        while (!byteStack.isEmpty()) {
            List<Integer> byteLikeList = byteStack.pop();
            for (int bit : byteLikeList) {
                result[i] = bit;
                i++;
            }
        }
        return result;

    }

}
import java.util.Set;
import java.util.TreeSet;


// https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class ex68644 {
    public static int[] solution(int[] numbers) {
        Set<Integer> tree = new TreeSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                tree.add(numbers[i]+numbers[j]);
            }
        }
        
        int[] array = tree.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return array;
    }
}

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ex12910 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/12910
     * 
     * array를 요소를 divisor로 나누어 떨어지는 값 오름차순 정렬
     */

    public static void main(String[] args) {
        int[] a = Solution.solution(new int[]{3,2,6}, 10);

        System.out.println(Arrays.toString(a));
    }

    class Solution {
        public static int[] solution(int[] arr, int divisor) {
            int[] answer = Arrays.stream(arr)
                    .filter(e -> e%divisor == 0)
                    .sorted()
                    .toArray();

            if(answer.length == 0) {
                return new int[]{-1};
            }

            return answer;
        }
    }
}

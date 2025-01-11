import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ex42840 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42840
     * 1번 수포자) 1 2 3 4 5 반복
     * 2번 수포자) 2 1 2 3 2 4 2 5 반복
     * 3번 수포자) 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복
     *
     * 정답이 들어 있는 answers 배열(1만 문제까지 있음)
     * -> 가장 많은 문제를 맞춘 사람은 누구인가?
     *
     * O(n^2) 까지 가능
     */

    public static void main(String[] args) {

        int[] a = {1,3,2,4,2};

        int[] sol = solution(a);

        Arrays.stream(sol).forEach(System.out::println);

    }

    public static int[] solution(int[] answers) {
        int[][] studentList = new int[3][];
        //              int[] a = {1, 3, 2, 4, 2};
        studentList[0] = new int[]{1, 2, 3, 4, 5};
        studentList[1] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        studentList[2] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = new int[3];


        for(int i=0; i<answers.length; i++) {
            for(int j=0; j<studentList.length; j++) {
                if(answers[i] == studentList[j][i % studentList[j].length]) {
                    answer[j]++;
                }
            }
        }

        int max = Arrays.stream(answer).max().orElse(0);
        TreeSet<Integer> tree = new TreeSet<>();

        for(int i=0; i<answer.length; i++) {
            if(answer[i] == max) {
                tree.add(i+1);
            }
        }

        return tree.stream()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;

public class ex87390 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/87390
     * 
     * 입력 : n, left, right
     * 
     * 1. N x N 짜리 2차원 배열 만듬
     * 2. i = 1~N까지 배열을 초기화 하는데 -> i행 i열까지 빈칸을 숫자 i로 초기화
     *   | 1 2 3 |
     *   | 2 2 3 |
     *   | 3 3 3 |
     * 
     * 3. 2차원 배열을 n행으로 나눠서 합침 (하나의 배열로 만들기)
     * 4. 만들어진 1차원 배열의 인덱스가 left ~ right 인 배열 반환
     * 
     * 결과
     * n    left  right
     * 3 	2 	    5 	  [3,2,2,3]
     */

     public static void main(String[] args) {
        int[] a = Solution.solution(3, 2, 5);

        System.out.println(Arrays.toString(a));
     }

    class Solution {
        public static int[] solution(int n, long left, long right) {

            List<Integer> answer = new LinkedList<>();

            
            for(long i=left; i<=right; i++) {
                long row = i / n;
                long column = i % n;

                int result = (int)Math.max(row, column) + 1;

                answer.add(result);
            }

            
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

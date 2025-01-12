import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;

public class ex42889 {

    public static void main(String[] args) {

        int[] v = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});

        Arrays.stream(v).forEach(s -> System.out.println(s));
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42889
     * 
     * 실패율을 구하는 것이 목표
     * -> 스테이지에 도달했는데 클리어 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
     * 
     * 전체 스테이지의 개수 N => 1~500
     * 플레이어가 멈춰있는 스테이지 번호가 담긴 배열 => stages => 1 ~ 20만의 길이, 1 ~ N+1 의 자연수
     * 실패율이 같으면 작은 번호의 스테이지가 먼저 오도록
     * 
     * [2, 1, 2, 6, 2, 4, 3, 3]
     * 
     */

     public static int[] solution(int N, int[] stages) {
        int stagesLength = stages.length;
        

        Map<Integer, Double> map = Arrays.stream(stages)
            .filter(st -> st <= N)
            .boxed()
            .collect(Collectors.groupingBy(
                stage -> stage,
                HashMap::new,
                Collectors.counting()
            ))
            .entrySet().stream()
            .collect(Collectors.toMap(
                Entry::getKey,
                v -> v.getValue().doubleValue()
            ));

        // {1=1, 2=3, 3=2, 4=1, 6=1}
        
        for(int i=1; i<=N; i++) {
            if(map.get(i) == null) {
                map.put(i, 0.0);
            }
            else {
                double preLength = map.get(i);
                map.put(i, (double)preLength/stagesLength);
                stagesLength -= preLength;
            }
        }

        return map.entrySet().stream()
                                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                                .mapToInt(Entry::getKey)
                                .toArray();
     }
    
}

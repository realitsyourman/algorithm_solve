import java.util.*;

public class ex49994 {

    public static void main(String[] args) {
        int answer = solution("LRLR");
        System.out.println(answer);
    }
    // 0,0,0,-1
    // -1,0,0,0 reverse 0 0 0 -1

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/49994
     * 
     * U(위로 한칸), D(아래로 한칸), R(오른쪽 한칸), L(왼쪽 한칸)
     * x 좌표 : -5~5
     * y 좌표 : -5~5
     * 
     * 
     * 캐릭터가 처음 지나는 곳의 걸음 수를 구하기
     * -> 이미 갔던 곳을 한번 더 가면 제거
     * 
     */

     public static int solution(String dirs) {
        int x = 0, y = 0;
        int nextX = x;
        int nextY = y;
        
        int dirsLenth = dirs.length();
        char[] dirsSlice = dirs.toCharArray();
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<dirsLenth; i++) {
            nextX = x;
            nextY = y;

            char command = dirsSlice[i];
            
            if(command == 'U') nextY += 1;
            else if(command == 'D') nextY -= 1;
            else if(command == 'R') nextX += 1;
            else if(command == 'L') nextX -= 1;
            
            
            // 범위 안에 있으면 set에 저장
            if(nextX <= 5 && nextX >= -5 && nextY <= 5 && nextY >= -5) {
                String path = x + "," + y + "," + nextX + "," + nextY;
                String reversePath = nextX + "," + nextY + "," + x + "," + y;
                
                x = nextX;
                y = nextY;
                
                set.add(path);
                set.add(reversePath);
            }
        }


        return set.size()/2;

    }
}

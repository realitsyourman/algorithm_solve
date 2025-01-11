public class ex12949 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/12949
     * 행렬 arr1과 arr2를 곱한 값 반환
     * 
     * 행과 열의 길이는 2~100
     * 행렬의 원소는 -10~20 자연수
     * 
     * | 1 4 |      | 3 3 |
     * | 3 2 |  X   | 3 3 | => 3x2
     * | 4 1 |      
     * 
     * 
     */

     public static int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Row = arr1.length;
        int arr1Column = arr1[0].length;
        int arr2Column = arr2[0].length;

        int[][] answer = new int[arr1Row][arr2Column];

        for(int i=0; i<arr1Row; i++) {
            for(int j=0; j<arr2Column; j++) {
                for(int k=0; k<arr1Column; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
     }
}

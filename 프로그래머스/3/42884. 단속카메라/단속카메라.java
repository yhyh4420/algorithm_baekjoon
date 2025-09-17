import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1,o2) -> Integer.compare(o1[1], o2[1]));
        int answer = 0;
        int cameraPosition = Integer.MIN_VALUE;
        for (int[] route:routes) {
            int start = route[0], end = route[1];
            if (start>cameraPosition){
                cameraPosition=end;
                answer++;
            }
        }
        
        return answer;
    }
}
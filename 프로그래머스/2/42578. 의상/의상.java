import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothMap = new HashMap<>();
        for (String[] cloth : clothes) {
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
        }
        int answer = 1;
        for (int i:clothMap.values()){
            answer *= (i+1);
        }
        return answer-1;
    }
}
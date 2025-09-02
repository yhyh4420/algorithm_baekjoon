import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tMap = new HashMap<>();
        for (int i: tangerine){
            tMap.put(i, tMap.getOrDefault(i,0) + 1);
        }
        List<Integer> values = new ArrayList<>(tMap.values());
        Collections.sort(values, Collections.reverseOrder());
        int sum = 0;
        int answer = 0;
        for (int i:values){
            sum += i;
            answer += 1;
            if (sum >= k){
                break;
            }
        }
        return answer;
    }
}
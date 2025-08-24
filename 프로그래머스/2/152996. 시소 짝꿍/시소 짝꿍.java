import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        Map<Integer, Long> weightData = new HashMap<>();
        Map<Integer, Long> memorizationMap = new HashMap<>();
        long answer = 0;
        for (int i = 0; i < weights.length; i++){
            if (weightData.containsKey(weights[i])){
                weightData.put(weights[i], weightData.get(weights[i])+1L);
            } else{
                weightData.put(weights[i], 1L);
            }
        }
        for (int key : weightData.keySet()){
            long weightCount = weightData.get(key);
            if (weightCount > 1){
                long n = (weightCount*(weightCount-1))/2;
                answer += n;
            }
        }
        for (int i = 0; i<weights.length;i++){
            if (memorizationMap.containsKey(weights[i])) {
                answer += memorizationMap.get(weights[i]);
            } else {
                Long count = 0L;
                for (int j = i+1;j < weights.length; j++){
                    if (weights[i]*3 == weights[j]*2 || 
                        weights[i]*2 == weights[j] || 
                        weights[i]*4 == weights[j]*3){
                        count += 1L;
                    }
                }
                answer += count;
                memorizationMap.put(weights[i],count);
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    Map<String, Integer> parkCar = new HashMap<>();
    Map<String, Integer> feeMap = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        for (String recordString : records){
            String[] record = recordString.split(" ");
            if (record[2].equals("IN")){
                parkCar.put(record[1], calculateMinute(record[0]));
            } else {
                int time = calculateMinute(record[0]) - parkCar.get(record[1]);
                parkCar.remove(record[1]);
                
                feeMap.put(record[1], feeMap.getOrDefault(record[1],0)+time);
            }
        }
        for (String pCar : parkCar.keySet()) {
            int time = calculateMinute("23:59") - parkCar.get(pCar);
            feeMap.put(pCar, feeMap.getOrDefault(pCar, 0)+time);
        }
        List<String> keyList = new ArrayList<>(feeMap.keySet());
        Collections.sort(keyList);
        int[] answer = new int[keyList.size()];
        for (int i=0; i<keyList.size(); i++) {
            int time = feeMap.get(keyList.get(i));
            if (time>fees[0]) {
                int extra = (int) Math.ceil((time - fees[0]) / (double) fees[2]);
                answer[i] = fees[1] + extra * fees[3];
            } else {
                answer[i] = fees[1];
            }
        }
        return answer;
    }
    
    public int calculateMinute(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h*60+m;
    }
}
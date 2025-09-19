import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> reportSet = new HashSet<>();
        Map<String, List<String>> reportMap = new HashMap<>();
        Map<String, Integer> receiverMap = new HashMap<>();
        int[] answer = new int[id_list.length];
        for(String r : report) {
            if (reportSet.contains(r)){
                continue;
            }
            String reporter = r.split(" ")[0];
            String receiver = r.split(" ")[1];
            receiverMap.put(receiver, receiverMap.getOrDefault(receiver, 0)+1);
            List<String> receiverList = reportMap.getOrDefault(reporter, new ArrayList<>());
            receiverList.add(receiver);
            reportMap.put(reporter, receiverList);
            reportSet.add(r);
        }
        for (int i=0; i<id_list.length; i++) {
            String reporter = id_list[i];
            if (!reportMap.keySet().contains(reporter)) continue;
            int sum=0;
            for (String receiver : reportMap.get(reporter)){
                if (receiverMap.get(receiver)>=k){
                    sum++;
                }
            }
            answer[i]=sum;
        }
        return answer;
    }
}
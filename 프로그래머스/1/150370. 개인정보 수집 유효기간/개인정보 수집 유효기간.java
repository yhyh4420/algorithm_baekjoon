import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String s: terms) {
            termMap.put(s.split(" ")[0], Integer.parseInt(s.split(" ")[1]));
        }
        StringTokenizer st = new StringTokenizer(today, ".");
        int todayYear = Integer.parseInt(st.nextToken());
        int todayMonth = Integer.parseInt(st.nextToken());
        int todayDay = Integer.parseInt(st.nextToken());
        
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<privacies.length; i++) {
            String p = privacies[i];
            String privacy = p.split(" ")[1];
            StringTokenizer stp = new StringTokenizer(p.split(" ")[0], ".");
            int pYear = Integer.parseInt(stp.nextToken());
            int pMonth = Integer.parseInt(stp.nextToken());
            int pDay = Integer.parseInt(stp.nextToken());
            
            int addMonth = termMap.get(privacy);
            pMonth += addMonth;
            pYear += (pMonth - 1) / 12;
            pMonth = (pMonth - 1) % 12 + 1;
            pDay -= 1;
            if (pDay == 0) {
                pMonth -= 1;
                if (pMonth == 0) {
                    pMonth = 12;
                    pYear -= 1;
                }
                pDay = 28;
            }
            
            if (pYear < todayYear ||
                (pYear == todayYear && pMonth < todayMonth) ||
                (pYear == todayYear && pMonth == todayMonth && pDay < todayDay)) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
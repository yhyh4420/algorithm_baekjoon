import java.util.*;

class Solution {
    String[] want;
    int[] number;
    
    public int solution(String[] want, int[] number, String[] discount) {
        this.want = want;
        this.number = number;
        
        int answer = 0;
        for (int i=0; i<discount.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j=0; j<10; j++) {
                if (i+j<discount.length) {
                    map.put(discount[i+j], map.getOrDefault(discount[i+j],0)+1);
                }
            }
            boolean isSale = true;
            for (int k=0; k<want.length; k++) {
                int mapValue = map.getOrDefault(want[k],0);
                if (mapValue==0 || mapValue!=number[k]) {
                    isSale = false;
                }
            }
            if (isSale) answer++;
        }
        return answer;
    }
}
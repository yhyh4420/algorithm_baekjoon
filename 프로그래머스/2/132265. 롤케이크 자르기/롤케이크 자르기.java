import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> toppingMap = new HashMap<>();
        for (int i:topping){
            toppingMap.put(i, toppingMap.getOrDefault(i,0)+1);
        }
        int answer = 0;
        Set<Integer> s = new HashSet<Integer>();
        for (int i=0; i<topping.length-1; i++){
            int t = topping[i];
            s.add(t);
            if(toppingMap.get(t)-1 == 0){
                toppingMap.remove(t);
            } else {
                toppingMap.put(t, toppingMap.get(t)-1);
            }
            if (s.size()==toppingMap.values().size()){
                answer++;
            }
        }
        return answer;
    }
}
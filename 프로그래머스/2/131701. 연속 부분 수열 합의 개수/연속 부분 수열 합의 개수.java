import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<elements.length; i++){
            int sum = 0;
            for (int len=1; len <= elements.length; len++){
                sum += elements[(i+len-1)%elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}
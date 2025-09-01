import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i:nums){
            s.add(i);
        }
        if (s.size() > nums.length/2){
            return nums.length / 2;
        } else {
            return s.size();
        }
    }
}
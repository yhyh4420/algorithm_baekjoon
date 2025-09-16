import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long start = 0;
        long end = (long) times[times.length-1] * n;
        while (start <= end) {
            long mid = (start+end)/2;
            long sumValid = 0;
            for (int i:times){
                sumValid+=(mid/(long) i);
            }
            if (sumValid<n){
                start=mid+1;
            } else {
                answer=mid;
                end=mid-1;
            }
        }
        return answer;
    }
}
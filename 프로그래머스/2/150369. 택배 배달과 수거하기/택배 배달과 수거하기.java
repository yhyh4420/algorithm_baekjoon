class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        for (int i = n-1; i>=0;){
            if (deliveries[i]==0 && pickups[i]==0){
                i -= 1;
                continue;
            }
            calculate(i, deliveries, cap);
            calculate(i, pickups, cap);
            
            answer += (i+1)*2;
        }
        return answer;
    }
    private void calculate(int idx, int[] arr, int cap){
        while(idx>=0){
            if (cap >= arr[idx]){
                cap -= arr[idx];
                arr[idx] = 0;
                idx-=1;
            } else {
                arr[idx] -= cap;
                break;
            }
        }
    }
}
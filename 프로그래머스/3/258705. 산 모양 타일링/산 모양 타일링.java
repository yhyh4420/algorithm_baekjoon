class Solution {
    public int solution(int n, int[] tops) {
        int MOD = 10007;
        int[] is_right = new int[n+1]; // 오른쪽 삼각형 마름모로 덮음
        int[] not_right = new int[n+1]; // 오른쪽 삼각형 마름모로 안덮음
        
        if (tops[0]==1){
            is_right[1] = 1;
            not_right[1] = 3;
        } else {
            is_right[1] = 1;
            not_right[1] = 2;
        }
        
        for (int k=2;k<n+1;k++) {
            is_right[k] = is_right[k-1] + not_right[k-1];
            not_right[k] = tops[k-1]==1 ? not_right[k-1]*3+is_right[k-1]*2 : not_right[k-1]*2+is_right[k-1];
            is_right[k] %= MOD;
            not_right[k] %= MOD;
        }
        int answer = (is_right[n] + not_right[n])%MOD;
        return answer;
    }
}
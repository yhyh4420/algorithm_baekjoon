class Solution {
    static int answer = 0;
    public int solution(int n) {
        backtracking(2*n,1,1);
        return answer;
    }
    
    public static void backtracking(int max, int level, int sum){
        if(sum < 0){
            return;
        }
        if(level == max) {
            if (sum==0){
                answer++;
                }
            return;
        }
        backtracking(max, level+1,sum+1);
        backtracking(max, level+1,sum-1);
    }
}
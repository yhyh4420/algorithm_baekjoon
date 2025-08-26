class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int storey) {
        back(storey, 0);
        return answer;
    }
    
    public void back(int storey, int sum){
        if (storey < 10){
            answer = Math.min(answer, Math.min(sum+storey, sum+10-storey+1));
            return;
        }
        int button = storey%10;
        back(storey/10, sum+button);
        back((storey+10)/10, sum+10-button);
    }
}
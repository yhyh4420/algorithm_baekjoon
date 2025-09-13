class Solution {
    public int[] solution(int brown, int yellow) {
        int sumXY = (brown+4)/2;
        int[] answer = new int[2];
        for (int i=1; i<sumXY; i++) {
            if (i*(sumXY-i) == (brown+yellow)) {
                answer[1] = i;
                answer[0] = sumXY-i;
                break;
            }
        }
        return answer;
    }
}
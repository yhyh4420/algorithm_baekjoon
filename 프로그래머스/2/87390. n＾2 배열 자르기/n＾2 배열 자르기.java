class Solution {
    int n;
    public int[] solution(int n, long left, long right) {
        this.n = n;
        int answerLength = (int) (right-left+1);
        int[] answer = new int[answerLength];
        for (int i=0; i<answerLength; i++) {
            answer[i] = calculate(left+i);
        }
        return answer;
    }
    
    public int calculate(long idx) {
        if (idx%n <= idx/n) {
            return (int) (idx/n + 1);
        } else {
            return (int) (idx%n + 1);
        }
    }
}
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        while (true) {
            int row = (num-1)/w;
            int col = (row%2==0) ? (num-1)%w : w-1-(num-1)%w;
            int stepRL = (w-col)*2 - 1;
            int stepLR = col*2 + 1;
            int nextStep = (row%2 == 0) ? stepRL : stepLR;
            num += nextStep;
            if (num > n) {
                return answer;
            }
            answer++;
            System.out.println(num);
        }
    }
}
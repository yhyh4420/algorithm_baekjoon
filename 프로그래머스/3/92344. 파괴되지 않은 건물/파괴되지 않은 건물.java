class Solution {
    int[][] sum;
    int N, M;
    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        sum = new int[N+1][M+1];
        for (int[] s : skill) {
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int degree = s[5] * (s[0]==1 ? -1:1);
            sum[r1][c1] += degree;
            sum[r1][c2+1] -= degree;
            sum[r2+1][c1] -= degree;
            sum[r2+1][c2+1] += degree;
        }
        
        for (int i=1; i<N; i++) {
            for (int j=0; j<M; j++){
                sum[i][j] += sum[i-1][j];
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=1; j<M; j++) {
                sum[i][j] += sum[i][j-1];
            }
        }
        int answer = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++) {
                if (board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}
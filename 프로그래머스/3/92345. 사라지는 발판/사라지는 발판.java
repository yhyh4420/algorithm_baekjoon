class Solution {
    
    class Result {
        boolean win;
        int turn;
        Result(boolean win, int turn) {
           this.win = win;
           this.turn = turn;
        }
    }
    int n;
    int m;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]).turn;
    }
    
    public Result dfs(int[][] board, int ax, int ay, int bx, int by) {
        if (board[ax][ay]==0) {
            return new Result(false, 0); // 진거임
        }
        boolean canMove = false;
        boolean canWin = false;
        int minMove = Integer.MAX_VALUE;
        int maxMove = 0;
        for (int i=0; i<4; i++) {
            int nx = ax+dx[i];
            int ny = ay+dy[i];
            if (!inbound(nx, ny)||board[nx][ny]==0){
                continue;
            }
            canMove = true;
            board[ax][ay]=0;
            Result next = dfs(board, bx, by, nx, ny);
            board[ax][ay]=1;
            if (!next.win){ // 다음으로 두는 사람이 지는거다, 즉 지금 둔 수가 이기는 수다
                canWin = true;
                minMove = Math.min(next.turn+1, minMove);
            } else {
                maxMove = Math.max(next.turn+1, maxMove);
            }
        }
        if (!canMove) {
            return new Result(false,0);
        }
        if (canWin) {
            return new Result(true, minMove);
        }
        return new Result(false, maxMove);
    }
    
    public boolean inbound(int x, int y) {
        return x>=0&&x<n&&y>=0&&y<m;
    }
}

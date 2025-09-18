import java.util.*;

class Solution {
    int n, m, r, c, k;
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] chr = {'d','l','r','u'};
    List<String> answerList = new ArrayList<>();
    String answer = "impossible";
    boolean found = false;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        int dist = Math.abs(x-r) + Math.abs(y-c);
        if (dist>k) return "impossible";
        back("",x,y);
        return answer;
    }
    
    public void back(String s, int x, int y) {
        if (found) return;
        int remain = k-s.length();
        int minDist = Math.abs(x-r)+Math.abs(y-c);
        if (minDist>remain) return;
        if ((remain - minDist) % 2 != 0) return;
        if (s.length()==k) {
            if (x==r && y==c) {
                answer = s;
                found = true;
            }
            return;
        }
        for (int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (1<=nx && nx<=n && 1<=ny && ny<=m){
                back(s+chr[i], nx, ny);
            }
        }
    }
}
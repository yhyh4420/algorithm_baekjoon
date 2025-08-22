import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int col = maps.length;
        int row = maps[0].length();
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        for (int i=0; i<col; i++){
            for (int j=0; j<row; j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'S') {
                    start[0] = i; start[1] = j;
                } else if (ch == 'L') {
                    lever[0] = i; lever[1] = j;
                } else if (ch == 'E') {
                    end[0] = i; end[1] = j;
                }
            }
        }
        
        int a = bfs(maps, start, lever);
        int b = bfs(maps, lever, end);
        if (a != -1 && b != -1) return a+b;
        return -1;
    }
    
    public int bfs(String[] maps, int[] start, int[] end) {
        int col = maps.length;
        int row = maps[0].length();
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] visited = new boolean[col][row];
        int[][] dist = new int[col][row];
        
        q.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];
            
            if (x == end[0] && y == end[1]) {
                return dist[x][y];
            }
            
            for (int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if (nx>=0 && nx<col && ny>=0 && ny<row 
                    && maps[nx].charAt(ny) != 'X'
                    && !visited[nx][ny]) {
                    
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}

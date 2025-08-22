import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j<m; j++){
                if (!visited[i][j] && maps[i].charAt(j) != 'X'){
                    answer.add(bfs(maps, i, j, visited, n, m));
                }
            }
        }
        if (answer.isEmpty()){
            return new int[]{-1};
        }
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    
    public int bfs(String[] maps, int x, int y, boolean[][] visited, int n, int m){
        int count = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        
        while (!q.isEmpty()){
            int[] pos = q.poll();
            int a = pos[0];
            int b = pos[1];
            if (visited[a][b]){
                continue;
            }
            count += maps[a].charAt(b) - '0';
            visited[a][b] = true;
            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};
            for (int i = 0; i < 4; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];
                if ((0<=nx && nx<n) && (0<=ny && ny<m) && !visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}
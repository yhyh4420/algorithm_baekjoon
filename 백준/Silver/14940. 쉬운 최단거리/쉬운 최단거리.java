import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] answer;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        answer = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        List<Integer> start;
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                answer[i][j] = 0;
            }
        }

        while (!q.isEmpty()) {
            int[] p=q.remove();
            for (int d=0; d<4; d++) {
                int nx = p[0]+dx[d];
                int ny = p[1]+dy[d];
                if (nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==1 && answer[nx][ny] == 0) {
                    answer[nx][ny] = answer[p[0]][p[1]]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j]==1 && answer[i][j]==0) {
                    answer[i][j] = -1;
                }
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}

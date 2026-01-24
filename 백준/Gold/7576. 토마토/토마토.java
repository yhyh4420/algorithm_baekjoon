import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        M = Integer.parseInt(arr[0]);
        N = Integer.parseInt(arr[1]);
        StringTokenizer st;
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++) {
                int tomata = Integer.parseInt(st.nextToken());
                map[i][j] = tomata;
                if (tomata==1) {
                    q.add(new int[]{i,j});
                }
            }
        }
        bfs();
        int answer = -1;
        boolean stop = false;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j]-1 > answer) {
                    answer = map[i][j]-1;
                }
                if (map[i][j] == 0) {
                    answer = -1;
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
        }
        System.out.println(answer);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] current = q.remove();
            for (int d=0; d<4; d++) {
                int nx = current[0]+dx[d];
                int ny = current[1]+dy[d];
                if (nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0) {
                    map[nx][ny] = map[current[0]][current[1]]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}

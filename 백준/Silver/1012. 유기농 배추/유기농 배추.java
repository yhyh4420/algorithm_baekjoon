import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visit;
    static int[][] farm;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            visit = new boolean[N][M];
            farm = new int[N][M];

            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int px = Integer.parseInt(st.nextToken());
                int py = Integer.parseInt(st.nextToken());
                farm[py][px] = 1;
            }

            int count = 0;
            for (int x=0; x<M; x++) {
                for (int y=0; y<N; y++) {
                    if (farm[y][x]==1 && !visit[y][x]){
                        count++;
                        dfs(y,x);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int y, int x) {
        visit[y][x]=true;
        for (int d=0; d<4; d++) {
            int cy = y + dy[d];
            int cx = x + dx[d];
            if (isInbound(cx, cy) && farm[cy][cx]==1 && !visit[cy][cx]) {
                dfs(cy,cx);
            }
        }
    } 

    private static boolean isInbound(int x, int y) {
        return (x>=0 && x<M) && (y>=0 && y<N);
    }
    
}
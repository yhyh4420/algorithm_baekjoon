import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i=0; i<N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i][0] = arr[0];
            for (int j=1; j<N; j++) {
                map[i][j] = map[i][j-1] + arr[j];
            }
        }
        for (int k=0; k<M; k++) {
            int answer = 0;
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int x=arr[0]-1; x<arr[2]; x++) {
                int sum;
                if (arr[1]==1) {
                    sum=map[x][arr[3]-1];
                } else {
                    sum=map[x][arr[3]-1]-map[x][arr[1]-2];
                }
                answer += sum;
            }
            System.out.println(answer);
        }
    }
    
}

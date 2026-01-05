import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());;
        }

        Arrays.sort(arr, (e1, e2) -> {
            int cmp = Integer.compare(e1[0], e2[0]);
            if (cmp != 0) return cmp;
            return Integer.compare(e1[1], e2[1]);
        });

        for (int i=0; i<N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}

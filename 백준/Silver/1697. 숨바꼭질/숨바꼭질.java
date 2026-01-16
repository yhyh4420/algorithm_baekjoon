import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int K;
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        N = Integer.parseInt(numbers[0]);
        K = Integer.parseInt(numbers[1]);
        System.out.println(bfs(N));
    }

    private static int bfs(int N) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (cur==K) {
                return arr[cur];
            }
            int[] candidate = {cur-1, cur+1, 2*cur};
            for (int c: candidate) {
                if (c>=0 && c<100001 && arr[c]==0) {
                    arr[c] = arr[cur]+1;
                    q.add(c);
                }
            }
        } return arr[K];
    }
}

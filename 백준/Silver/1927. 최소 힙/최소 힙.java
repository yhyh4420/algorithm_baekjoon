import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<Integer>();
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n==0) {
                printNumber();
            } else {
                pq.add(n);
            }
        }
    }

    private static void printNumber() {
        if (pq.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(pq.poll());
    }
}

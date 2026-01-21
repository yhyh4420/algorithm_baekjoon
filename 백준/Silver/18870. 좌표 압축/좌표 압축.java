import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] arrForSort = arr.clone();
        Arrays.sort(arrForSort);
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i:arrForSort) {
            if (!map.containsKey(i)){
                map.put(i,cnt);
                cnt++;
            } 
        }
        StringBuilder sb = new StringBuilder();
        for (int i:arr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}

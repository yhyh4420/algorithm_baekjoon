import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, "-");
        answer = sum(st.nextToken());
        int sum = 0;
        while (st.hasMoreTokens()) {
            sum+=sum(st.nextToken());
        }
        System.out.println(answer-sum);
    }

    private static int sum(String str) {
        int sum = 0;
        StringTokenizer st = new StringTokenizer(str, "+");
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        return sum;
    }
}

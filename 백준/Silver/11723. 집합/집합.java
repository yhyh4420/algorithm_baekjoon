import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        String command;
        int inputInt;
        int set = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "add":
                    inputInt = Integer.parseInt(st.nextToken());
                    set = set | (1<<inputInt);
                    break;
                case "remove":
                    inputInt = Integer.parseInt(st.nextToken());
                    set = set & ~(1<<inputInt);
                    break;
                case "check":
                    inputInt = Integer.parseInt(st.nextToken());
                    if ((set & (1<<inputInt)) != 0){
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    inputInt = Integer.parseInt(st.nextToken());
                    if ((set & (1<<inputInt)) == 0){
                        set = set |  1<<inputInt;
                    } else  {
                        set = set & ~(1<<inputInt);
                    }
                    break;
                case "all":
                    set = (1<<21) -1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int white=0;
    static int blue=0;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i=0; i<N; i++) {
            map[i] = br.readLine().split(" ");
        }
        divide(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int x, int y, int size) {
        String color = map[x][y];
        boolean same = true;

        for (int i=x;i<x+size;i++) {
            for (int j=y;j<y+size;j++) {
                if (!map[i][j].equals(color)) {
                    same=false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }
        if (same) {
            if (color.equals("0")) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        int newSize = size/2;
        divide(x,y,newSize);
        divide(x+newSize,y,newSize);
        divide(x,y+newSize,newSize);
        divide(x+newSize, y+newSize, newSize);
    }
}

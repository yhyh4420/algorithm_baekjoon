import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<Coordinate> cList = new ArrayList<>();
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a = line[i][0], b = line[i][1], e = line[i][2];
                long c = line[j][0], d = line[j][1], f = line[j][2];

                long det = a * d - b * c;
                if (det == 0) continue;

                long nx = b * f - e * d;
                long ny = e * c - a * f;

                if (nx % det != 0 || ny % det != 0) continue;

                long lx = nx / det;
                long ly = ny / det;

                cList.add(new Coordinate(lx, ly));
                if (lx > maxX) maxX = lx;
                if (lx < minX) minX = lx;
                if (ly > maxY) maxY = ly;
                if (ly < minY) minY = ly;
            }
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(map[i], '.');
        }

        for (Coordinate c : cList) {
            int row = (int) (maxY - c.y);
            int col = (int) (c.x - minX);
            map[row][col] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(map[i]);
        }
        return answer;
    }
}

class Coordinate {
    long x;
    long y;

    Coordinate(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

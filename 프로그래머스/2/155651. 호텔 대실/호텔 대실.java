import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int row = book_time.length;
        Arrays.sort(book_time, (x,y) -> x[0].compareTo(y[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1]-y[1]);
        for (int i=0;i<row;i++){
            int startH = Integer.parseInt(book_time[i][0].split(":")[0]);
            int startM = Integer.parseInt(book_time[i][0].split(":")[1]);
            int endH = Integer.parseInt(book_time[i][1].split(":")[0]);
            int endM = Integer.parseInt(book_time[i][1].split(":")[1]);
            int start = startH*60 + startM;
            int end = endH*60 + endM + 10;
            
            if (pq.isEmpty()) {
                answer++;
                pq.offer(new int[]{start, end});
            } else {
                int[] time = pq.poll();
                int beforeStart = time[0];
                int beforeEnd = time[1];
                if (beforeEnd > start) {
                    answer++;
                    pq.offer(new int[]{start, end});
                    pq.offer(time);
                } else {
                    pq.offer(new int[]{start, end});
                }
            }
        }
        return answer;
    }
}
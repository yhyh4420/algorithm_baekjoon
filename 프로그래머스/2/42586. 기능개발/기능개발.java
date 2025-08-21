import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> progressesQueue = new LinkedList<>();
        Queue<Integer> speedsQueue = new LinkedList<>();
        int arrLength = progresses.length;
        for (int i=0;i<arrLength;i++){
            progressesQueue.add(progresses[i]);
            speedsQueue.add(speeds[i]);
        }
        while (!progressesQueue.isEmpty()) {
            int qSize = progressesQueue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < qSize; i++){
                int prog = progressesQueue.poll();
                int speed = speedsQueue.poll();
                prog += speed;
                temp.add(prog);
                speedsQueue.add(speed);
            }
            for (int t:temp) {
                progressesQueue.add(t);
            }
            int count = 0;
            while (!progressesQueue.isEmpty() && progressesQueue.peek() >= 100) {
                count ++;
                progressesQueue.poll();
                speedsQueue.poll();
            }
            if (count != 0) {
                answer.add(count);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> answerList = new ArrayList<>();
        
        for (int i=0; i<cards.length; i++) {
            if (visited[i]) {
                continue;
            }
            int score = 0;
            int current = cards[i] - 1;
            while (true) {
                if (visited[current]){
                    break;
                }
                score++;
                visited[current] = true;
                current = cards[current]-1;
            }
            answerList.add(score);
        }
        if (answerList.size() < 2){
            return 0;
        }
        Collections.sort(answerList, Collections.reverseOrder());
        return answerList.get(0) * answerList.get(1);
    }
}
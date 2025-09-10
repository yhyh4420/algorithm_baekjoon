import java.util.*;

class Solution {
    int answer = 0;
    int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        boolean[] visited = new boolean[dungeons.length];
        List<Integer> order = new ArrayList<>();
        dfs(k, visited, order);
        return answer;
    }
    
    public void dfs(int k, boolean[] visited, List<Integer> order) {
        if (order.size() == dungeons.length) {
            int sum = 0;
            for (int i=0; i<dungeons.length; i++) {
                int idx = order.get(i);
                if (dungeons[idx][0]>k || dungeons[idx][1]>k){
                    break;
                }
                sum++;
                k -= dungeons[idx][1];
            }
            answer = Math.max(answer, sum);
            return;
        }
        for (int i=0; i<dungeons.length; i++){
            if (!visited[i]){
                visited[i] = true;
                order.add(i);
                dfs(k, visited, order);
                order.remove(order.size()-1);
                visited[i] = false;
            }
        }
    }
}
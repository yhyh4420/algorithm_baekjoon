import java.util.*;

class Solution {
    
    List<List<Integer>> graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList<>();
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<n-1; i++) {
            int u = wires[i][0];
            int v = wires[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i=0; i<n-1; i++) {
            int u = wires[i][0];
            int v = wires[i][1];
            graph.get(u).remove(Integer.valueOf(v));
            graph.get(v).remove(Integer.valueOf(u));
            boolean[] visited = new boolean[n+1];
            int count = bfs(1, visited);
            answer = Math.min(answer, Math.abs(n-count-count));
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return answer;
    }
    
    public int bfs(int u, boolean[] visited) {
        visited[u] = true;
        int count = 1;
        for (int next : graph.get(u)) {
            if (!visited[next]) {
                count += bfs(next, visited);
            }
        }
        return count;
    }
}
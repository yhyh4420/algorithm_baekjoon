import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<info.length; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges){
            graph.get(e[0]).add(e[1]);
        }
        
        List<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(info, graph, next, 0, 0, 0);
        return answer;
    }
    
    public void dfs(int[] info, List<List<Integer>> graph, List<Integer> next, int node, int sheep, int wolf){
        if(info[node]==0){sheep++;}
        else{wolf++;}
        
        if(wolf>=sheep){return;}
        
        answer = Math.max(answer, sheep);
        
        List<Integer> candidates = new ArrayList<>(next);
        candidates.remove(Integer.valueOf(node));
        candidates.addAll(graph.get(node));
        
        for (int n : candidates){
            dfs(info, graph, candidates, n, sheep, wolf);
        }
    }
}
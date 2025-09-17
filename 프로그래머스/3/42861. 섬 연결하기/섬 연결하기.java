import java.util.*;

class Solution {
    int[] parents;
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for (int i=0; i<n; i++){
            parents[i]=i;
        }
        Arrays.sort(costs, (o1,o2)->Integer.compare(o1[2],o2[2]));
        int answer = 0;
        int count = 0;
        for (int i=0; i<costs.length; i++){
            if (count == n-1) break;
            if (union(costs[i][0], costs[i][1])) {
                count++;
                answer+=costs[i][2];
            }
        }
        return answer;
    }
    
    public int find(int x){
        if (parents[x]==x){
            return x;
        } return find(parents[x]);
    }
    
    public boolean union(int x, int y){
        if (find(x)==find(y)){
            return false;
        } parents[find(x)] = find(y);
        return true;
    }
}
import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        addNumbersInSet("", numbers, visited);
        
        boolean[] chae = eratos(numbers);
        int answer = 0;
        for (int number : set) {
            if (chae[number]) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean[] eratos(String numbers) {
        int MAX = (int) Math.pow(10, (numbers.length()));
        boolean[] chae = new boolean[MAX];
        Arrays.fill(chae, true);
        chae[0] = false;
        chae[1] = false;
        for (int i=2; i<MAX; i++){
            if (!chae[i]) continue;
            for (int j=i*2; j<MAX; j+=i) {
                chae[j] = false;
            }
        }
        return chae;
    }
    
    public void addNumbersInSet(String now, String numbers, boolean[] visited) {
        if (now.length() != 0 && !set.contains(Integer.parseInt(now))) {
            set.add(Integer.parseInt(now));
        }
        if (now.length()==numbers.length()) {
            return;
        }
        for (int i=0; i<numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                addNumbersInSet(now+numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
}
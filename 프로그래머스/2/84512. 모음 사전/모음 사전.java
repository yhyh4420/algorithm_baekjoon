import java.util.*;

class Solution {
    
    List<String> dict = new ArrayList<>();
    static String[] aeiou = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        int answer = 1;
        dfs(dict, "", word);
        for (String w : dict) {
            if (w.equals(word)) {
                break;
            }
            else {
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(List<String> dict, String current, String target){
        if(current.length() == 5)
            return;
        for(int i=0; i<5; i++){
            dict.add(current + aeiou[i]);
            dfs(dict, current + aeiou[i], target);
        }
    }
}
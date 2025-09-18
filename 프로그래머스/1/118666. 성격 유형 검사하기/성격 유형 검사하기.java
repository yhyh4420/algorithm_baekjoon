import java.util.*;

class Solution {
    
    Map<Character, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        for (int i=0; i<survey.length; i++){
            grade(survey[i].charAt(0), survey[i].charAt(1), choices[i]);
        }
        String answer = "";
        answer+=(map.getOrDefault('R',0)>=map.getOrDefault('T',0) ? 'R' : 'T');
        answer+=(map.getOrDefault('C',0)>=map.getOrDefault('F',0) ? 'C' : 'F');
        answer+=(map.getOrDefault('J',0)>=map.getOrDefault('M',0) ? 'J' : 'M');
        answer+=(map.getOrDefault('A',0)>=map.getOrDefault('N',0) ? 'A' : 'N');
        return answer;
    }
    
    public void grade(char a, char b, int choice){
        int score = choice-4;
        if (score<0) {
            map.put(a, map.getOrDefault(a,0)+Math.abs(score));
        } else {
            map.put(b, map.getOrDefault(b,0)+Math.abs(score));
        }
    }
}
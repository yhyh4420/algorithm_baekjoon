import java.util.*;

public class Solution {
    public int[] solution(int[] arr) { 
        int[] answer; 
        Stack<Integer> stack = new Stack<>(); 
        for (int i : arr) { 
            if (stack.empty() || !stack.peek().equals(i)){ 
                stack.push(i); 
            } 
        } 
        int stackSize = stack.size();
        answer = new int[stackSize]; 
        for (int i = 0; i<stackSize; i++){ 
            answer[stackSize-i-1] = stack.pop(); 
        } 
        return answer; 
    } 
}
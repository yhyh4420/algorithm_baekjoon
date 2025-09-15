import java.util.*;

class Solution {
    
    int[][] dice;
    List<List<Integer>> comb = new ArrayList<>();
    public int[] solution(int[][] dice) {
        long maxWin = -1;
        this.dice = dice;
        boolean[] visited = new boolean[dice.length];
        back(new ArrayList<>(), visited, 0);
        List<Integer> answer = new ArrayList<>();
        for (List<Integer> c : comb) {
            List<Integer> A = c;
            List<Integer> B = new ArrayList<>();
            for (int i=0; i<dice.length; i++) {
                if (!A.contains(i)) {
                    B.add(i);
                }                
            }
            List<Integer> sumA = new ArrayList<>();
            List<Integer> sumB = new ArrayList<>();
            makeSum(A,0,0,sumA);
            makeSum(B,0,0,sumB);
            long win = countWin(sumA, sumB);
            if (win>maxWin) {
                maxWin = win;
                answer = A;
            }
        }
        return answer.stream().mapToInt(i->i+1).toArray();
    }
    
    public void back(List<Integer> diceList, boolean[] visited, int start){
        if (diceList.size() == dice.length / 2) {
            comb.add(new ArrayList<>(diceList));
            return;
        }
        for (int i=start; i<dice.length; i++) {
            if (!visited[i]){
                diceList.add(i);
                visited[i] = true;
                back(diceList, visited, i+1);
                visited[i] = false;
                diceList.remove(diceList.size()-1);
            }
        }
    }
    
    public void makeSum(List<Integer> diceList, int sum, int idx, List<Integer> result) {
        if (idx == diceList.size()) {
            result.add(sum);
            return;
        }
        int[] diceFace = dice[diceList.get(idx)];
        for (int number : diceFace) {
            makeSum(diceList, sum+number, idx+1, result);
        }
    }
    
    public long countWin(List<Integer> listA, List<Integer> listB) {
        Collections.sort(listB);
        long count = 0;
        for (int a: listA) {
            int idx = binarySearch(listB, a-1);
            count += idx;
        }
        return count;
    }
    
    public int binarySearch(List<Integer> list, int target) {
        int start = 0, end = list.size();
        while (start < end) {
            int mid = (start+end)/2;
            if (list.get(mid) > target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
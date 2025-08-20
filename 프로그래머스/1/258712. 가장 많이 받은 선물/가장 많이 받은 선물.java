import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendsLength = friends.length;
        HashMap<String, Integer> dic = new HashMap<>();
        int[] giftScore = new int[friendsLength];
        int[][] giftMap = new int[friendsLength][friendsLength];
        for (int i = 0; i < friendsLength; i++) {
            dic.put(friends[i], i);
        }
        for (String gift : gifts){
            String[] giftNames = gift.split(" ");
            giftScore[dic.get(giftNames[0])]++;
            giftScore[dic.get(giftNames[1])]--;
            giftMap[dic.get(giftNames[0])][dic.get(giftNames[1])]++;
        }
        
        for (int i=0; i<friendsLength; i++) {
            int num = 0;
            for (int j=0; j<friendsLength;j++) {
                if (i == j) {
                    continue;
                }
                if (
                    (giftMap[i][j] > giftMap[j][i]) || 
                    (giftMap[i][j] == giftMap[j][i] && giftScore[i] > giftScore[j])
                ) {
                    num++;
                }
            }
            if (answer < num) {
                answer = num;
            }
        }
        return answer;
    }
}
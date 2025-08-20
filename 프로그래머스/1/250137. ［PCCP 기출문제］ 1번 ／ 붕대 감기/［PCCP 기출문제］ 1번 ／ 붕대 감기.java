class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int a = 0;
        int recoverTime = 0;
        for (int i = 0; i <= attacks[attacks.length-1][0]; i++) {
            if (i==attacks[a][0]) {
                answer -= attacks[a][1];
                if (answer <= 0) {
                    return -1;
                }
                a += 1;
                recoverTime = 0;
            } else {
                answer = Math.min(answer + bandage[1], health);
                recoverTime += 1;
            }
            if (recoverTime == bandage[0]) {
                recoverTime = 0;
                if (answer + bandage[2] >= health){
                    answer = health;
                } else {
                    answer += bandage[2];
                }
            }
        }
        return answer;
    }
}
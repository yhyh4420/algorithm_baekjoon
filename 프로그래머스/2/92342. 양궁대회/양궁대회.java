import java.util.*;

class Solution {
    int n;
    int[] apeach;
    int[] bestPlan = {-1};
    int bestDiff = 0;

    public int[] solution(int n, int[] info) {
        this.n = n;
        this.apeach = info;

        dfs(0, n, new int[11]);

        return (bestDiff <= 0) ? new int[]{-1} : bestPlan;
    }

    // idx: 현재 점수 인덱스(0~10), remain: 남은 화살 수
    private void dfs(int idx, int remain, int[] plan) {
        if (idx == 11) {
            if (remain > 0) {
                plan[10] += remain; // 남은 화살은 0점에 몰아줌
            }

            int diff = getDiff(plan);

            if (diff > bestDiff) {
                bestDiff = diff;
                bestPlan = plan.clone();
            } else if (diff == bestDiff && tieBreak(plan, bestPlan)) {
                bestPlan = plan.clone();
            }

            if (remain > 0) {
                plan[10] -= remain; // 원상복구
            }
            return;
        }

        // 1. 현재 점수 이기기 (apeach[idx] + 1 발 쏨)
        int need = apeach[idx] + 1;
        if (remain >= need) {
            plan[idx] = need;
            dfs(idx + 1, remain - need, plan);
            plan[idx] = 0; // 백트래킹
        }

        // 2. 현재 점수 포기하기 (0발)
        dfs(idx + 1, remain, plan);
    }

    // 점수 차 계산
    private int getDiff(int[] plan) {
        int ryan = 0, ape = 0;
        for (int i = 0; i < 11; i++) {
            int score = 10 - i;
            if (plan[i] > 0 || apeach[i] > 0) {
                if (plan[i] > apeach[i]) ryan += score;
                else ape += score;
            }
        }
        return ryan - ape;
    }

    // 동점 처리: 낮은 점수(인덱스 10부터)에서 화살이 더 많은 쪽을 선택
    private boolean tieBreak(int[] a, int[] b) {
        if (b == null || b.length == 1 && b[0] == -1) return true;
        for (int i = 10; i >= 0; i--) {
            if (a[i] != b[i]) return a[i] > b[i];
        }
        return false;
    }
}

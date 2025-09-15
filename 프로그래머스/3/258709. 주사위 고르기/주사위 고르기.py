from itertools import combinations
from bisect import bisect

def sumRecursive(i, comb, dice, res, AB):
    if i == len(dice)//2:
        AB.append(res)
        return
    for j in range(6):
        sumRecursive(i+1, comb, dice, res + dice[comb[i]][j], AB)

def anserize(n):
    return n + 1

def solution(dice):
    ans = [[], 0]
    for comb in combinations(range(len(dice)), len(dice)//2):
        A, B = [], []
        sumRecursive(0, comb, dice, 0, A)
        sumRecursive(0, list(set(range(len(dice))) - set(comb)), dice, 0, B)
        B.sort()
        res = 0
        for i in A:
            res += bisect(B, i-1)
        if res > ans[1]:
            ans = [comb, res]
    return list(map(anserize, list(ans[0])))
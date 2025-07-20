from itertools import combinations

def solution(n, q, ans):
    entry = [i+1 for i in range(n)]
    answer_list = list(combinations(entry, 5))
    answer = 0
    
    for candidate in answer_list:
        candidate_set = set(candidate)
        for idx in range(len(q)):
            if len(set(q[idx]) & candidate_set) != ans[idx]:
                break
        else: answer += 1
    return answer
def solution(targets):
    answer = 0
    targets.sort(key=lambda x:x[1])
    end = 0
    for target in targets:
        if target[0] >= end:
            answer += 1
            end = target[1]
    return answer
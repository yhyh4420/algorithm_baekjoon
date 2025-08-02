import math

def solution(r1, r2):
    answer = 0
    for r in range(1, r2):
        high = math.floor((r2**2 - r**2)**0.5)
        if r >= r1:
            low = 1
        else:
            low = math.ceil((r1**2 - r**2)**0.5)
        answer += (high-low+1)
    answer += (r2-r1+1)
    answer *= 4
    return answer
N,M = map(int, input().split())

def backtrack(answer):
    if len(answer) == M:
        print(*answer)
    
    for i in range(1,N+1):
        if not answer:
            backtrack(answer + [i])
        elif max(answer) < i:
            backtrack(answer + [i])

backtrack([])
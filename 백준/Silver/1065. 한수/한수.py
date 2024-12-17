N = int(input())

def isHan(n):
    answer = False
    if n<100:
        answer = True
    else:
        S = list(map(int, str(n)))
        if S[0]-S[1] == S[1]-S[2]:
            answer = True
    return answer

sol = 0
for i in range(1,N+1):
    if isHan(i):
        sol += 1
print(sol)
L = int(input())
S = list(map(int, input().split()))
n = int(input())

def solution(start, end, l):
    dab = 0
    for j in range(start+1, end):
        for k in range(j+1, end):
            if j <= l <= k:
                dab+=1
    return dab

if 1 not in S:
    S.append(0)
if 1000 not in S:
    S.append(1001)
S.sort()
for i in range(len(S)):
    if S[i] <= n <= S[i+1]:
        s, e = S[i], S[i+1]
        break


print(solution(s, e, n))
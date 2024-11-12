N = int(input())
S = [[0]*100 for i in range(100)]
paper = []

for _ in range(N):
    row = list(map(int, input().split()))
    paper.append(row)

for i in range(N):
    for j in range(10):
        for k in range(10):
            S[paper[i][0] + j][paper[i][1] + k] = 1

answer = 0
for i in range(100):
    for j in range(100):
        answer += S[i][j]

print(answer)
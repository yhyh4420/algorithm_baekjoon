A, B = [], []
result = []
N, M = map(int, input().split())
for _ in range(N):
    k = list(map(int, input().split()))
    A.append(k)
for _ in range(N):
    l = list(map(int, input().split()))
    B.append(l)

for i in range(N):
    for j in range(M):
        print(A[i][j] + B[i][j], end = ' ')
    print()
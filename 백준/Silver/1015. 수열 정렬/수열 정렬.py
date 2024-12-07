N = int(input())
A = list(map(int, input().split()))
P = [i for i in range(N)]

idx=0
answer = [0]*N
for i in range(1, 1001):
    for j in range(N):
        if A[j]==i:
            answer[j]=idx
            idx+=1
            
for i in answer:
    print(i, end=" ")
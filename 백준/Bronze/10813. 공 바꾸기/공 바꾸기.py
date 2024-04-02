N, M = map(int, input().split())
box = [i for i in range(1, N+1)]
temp = 0
for _ in range(M):
    i, j = map(int, input().split())
    temp = box[i-1]
    box[i-1] = box[j-1]
    box[j-1] = temp
    
for n in box:
    print(n, end = ' ')
A = []
for _ in range(9):
    l = list(map(int, input().split()))
    A.append(l)
    
max_i = 0
max_j = 0
max = 0

for i in range(9):
    for j in range(9):
        if A[i][j] > max:
            max, max_i, max_j = A[i][j], i, j
            
print(max)
print(max_i+1, max_j+1)
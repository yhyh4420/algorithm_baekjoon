N, M = map(int, input().split())
A = list(map(int, input().split()))
sumA = [0]
sums = 0
for i in range(N):
    sums += A[i]
    sumA.append(sums)

"""
투포인터 한번 써볼까.
"""
count = 0
start, end = 0, 1
while start <= end:
    if end == N+1:
        break
    sum_validation = sumA[end] - sumA[start]
    if sum_validation == M:
        count += 1
        start += 1
        end = start + 1
    elif sum_validation > M:
        start += 1
        end = start + 1
    else:
        end += 1

print(count)
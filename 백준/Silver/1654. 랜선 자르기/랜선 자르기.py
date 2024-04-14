K, N = map(int, input().split())
lan = [int(input())for _ in range(K)]

start, end = 1, max(lan)
while start <= end:
    mid = (start + end) // 2
    line_num = 0
    for i in lan:
        line_num += i // mid
    if line_num < N:
        end = mid-1
    else:
        start = mid+1

print(end)
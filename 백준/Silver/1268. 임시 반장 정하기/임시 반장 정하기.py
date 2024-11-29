n = int(input())
cls = []
for _ in range(n):
    q,w,e,r,t = map(int, input().split())
    cls.append([q,w,e,r,t])

result = [[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        for k in range(5):
            if cls[j][k] == cls[i][k]:
                result[i][j] = 1

result_list = []
for idx, s in enumerate(result):
    result_list.append(s.count(1))

print(result_list.index(max(result_list))+1)
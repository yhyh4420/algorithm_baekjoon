n = int(input())

m = []
for _ in range(n):
    m.append(list(input()))

answer = 1
def max_count():
    max_count = 1
    for i in range(n):
        garo_count = 1
        for j in range(n-1):
            if m[i][j] == m[i][j+1]:
                garo_count+=1
            else:
                garo_count=1
            max_count = max(max_count, garo_count)

        sero_count = 1
        for j in range(n-1):
            if m[j][i] == m[j+1][i]:
                sero_count+=1
            else:
                sero_count=1
            max_count = max(max_count, sero_count)
    return max_count

answer = 1
for i in range(n):
    for j in range(n-1):
        m[i][j], m[i][j+1] = m[i][j+1], m[i][j]
        answer = max(answer, max_count())
        m[i][j], m[i][j + 1] = m[i][j + 1], m[i][j]
        m[j][i], m[j+1][i] = m[j+1][i], m[j][i]
        answer = max(answer, max_count())
        m[j][i], m[j + 1][i] = m[j + 1][i], m[j][i]
print(answer)
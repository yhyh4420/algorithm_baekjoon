n = int(input())

candy = [list(input()) for _ in range(n)]

def max_count():
    max_cnt = 1
    for i in range(n):
        count = 1
        for j in range(1,n):
            if candy[i][j-1] == candy[i][j]:
                count += 1
            else:
                count = 1
            max_cnt = max(max_cnt, count)

        count = 1
        for j in range(1,n):
            if candy[j-1][i] == candy[j][i]:
                count += 1
            else:
                count = 1
            max_cnt = max(max_cnt, count)

    return max_cnt


answer = 1
for i in range(n):
    for j in range(1,n):
        candy[i][j-1], candy[i][j] = candy[i][j], candy[i][j-1]
        answer = max(answer, max_count())
        candy[i][j - 1], candy[i][j] = candy[i][j], candy[i][j - 1]
        candy[j-1][i], candy[j][i] = candy[j][i], candy[j-1][i]
        answer = max(answer, max_count())
        candy[j - 1][i], candy[j][i] = candy[j][i], candy[j - 1][i]

print(answer)
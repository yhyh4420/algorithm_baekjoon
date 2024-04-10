M, N = map(int, input().split())
chess = []
for i in range(M):
    row = input()
    chess.append(row)
answer = []
for a in range(M-7):
    for c in range(N-7):
        b_start = 0
        w_start = 0
        for i in range(a, a+8):
            for j in range(c, c+8):
                if (i+j)%2 == (a+c)%2: # b먼저 칠함
                    if chess[i][j] == 'W':
                        b_start += 1
                else:
                    if chess[i][j] == 'B':
                        b_start += 1
                if (i+j)%2 == (a+c)%2: # w먼저 칠함
                    if chess[i][j] == 'B':
                        w_start += 1
                else:
                    if chess[i][j] == 'W':
                        w_start += 1
        answer.append(w_start)
        answer.append(b_start)
print(min(answer))
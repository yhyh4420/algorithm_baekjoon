import sys

N = int(sys.stdin.readline())
steps = []
for i in range(N):
    steps.append(int(sys.stdin.readline().strip()))

dp=[0]*N
if N == 1:
    dp[0] = steps[0]
elif N == 2:
    dp[0] = steps[0]
    dp[1] = dp[0] + steps[1]
elif N == 3:
    dp[0] = steps[0]
    dp[1] = dp[0] + steps[1]
    dp[2] = max(steps[1]+steps[2], steps[0]+steps[2])
else:
    dp[0] = steps[0]
    dp[1] = dp[0] + steps[1]
    dp[2] = max(steps[1] + steps[2], steps[0] + steps[2])
    for i in range(3, N):
        dp[i] = max(dp[i - 3] + steps[i - 1] + steps[i], dp[i - 2] + steps[i])
print(dp[N-1])
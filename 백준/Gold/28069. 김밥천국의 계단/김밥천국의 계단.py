import math

N,K = map(int, input().split())
dp = [float('INF') for _ in range(N+1)]
dp[0] = 0
for i in range(1,N+1):
    dp[i] = min(dp[i],dp[i-1]+1)
    if i+i//2 <= N:
        dp[i+i//2] = min(dp[i]+1, dp[i+i//2])

if dp[-1] <= K:
    print('minigimbob')
else:
    print('water')
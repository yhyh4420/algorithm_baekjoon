N = int(input())
cannon = []
for i in range(1,N+1):
    ball = i*(i+1)*(i+2)//6
    if ball > N:
        break
    cannon.append(ball)

dp = [float('inf')]*(N+1)
dp[0] = 0
for c in cannon:
    for i in range(c, N+1):
        if dp[i-c]+1 < dp[i]:
            dp[i] = dp[i-c]+1

print(dp[-1])
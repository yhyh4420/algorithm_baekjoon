N = int(input())
damage = list(map(int, input().split()))
happy = list(map(int, input().split()))

dp = [0] * 101

for i in range(N):
    next_dp = dp[:]
    for hp in range(damage[i],101):
        next_dp[hp] = max(dp[hp], dp[hp-damage[i]] + happy[i])
    dp = next_dp

print(dp[99])
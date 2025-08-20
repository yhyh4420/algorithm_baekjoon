C,N = map(int,input().split())
city = []
for _ in range(N):
    cost, customer = map(int, input().split())
    city.append([cost, customer])

dp = [float('inf')]*(C+1000)
dp[0] = 0

for i in range(1,C+1000):
    for cost, customer in city:
        if i>=customer:
            dp[i] = min(dp[i], dp[i-customer]+cost)

print(min(dp[C:]))
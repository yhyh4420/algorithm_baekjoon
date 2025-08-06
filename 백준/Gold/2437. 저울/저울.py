N = int(input())
weights = list(map(int, input().split()))
weights.sort()

target = 1
for weight in weights:
    if weight > target:
        break
    target += weight
print(target)
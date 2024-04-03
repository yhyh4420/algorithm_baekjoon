n = int(input())
score = list(map(int, input().split()))
Max = max(score)
sum = 0
for i in range(n):
    sum += ((score[i]/Max) * 100)
    
print(sum/n)
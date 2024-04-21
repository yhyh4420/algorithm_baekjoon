N = int(input())
number = list(map(int, input().split()))
answer = 0
count = 0
for i in number:
    if i == 1:
        continue
    for j in range(2, i+1):
        if i%j == 0:
            if j == i:
                count = 1
            else:
                count = 0
                break
        else:
            count = 1
    if count == 1:
        answer += 1
        
print(answer)
X = int(input())
count = 0
while X != 0:
    if X % 2 != 0:
        count += 1
    X = X // 2
        
print(count)
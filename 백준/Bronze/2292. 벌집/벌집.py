N = int(input())
k = 1
count = 1
while N>count:
    k += 1
    count += (k-1)*6
print(k)
N = int(input())
def fact(k):
    multi = 1
    for i in range(1,k+1):
        multi *= i
    return multi

count = 0
str_N = str(fact(N))
i = 1
while True:
    if str_N[len(str_N)-i] == '0':
        count += 1
        i += 1
    else:
        break
print(count)
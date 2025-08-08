def fibo(n):
    if n==1:
        return 1
    if n==2:
        return 1
    if n==3:
        return 1
    a,b,c = 1,1,1
    for _ in range(n-1):
        a,b,c = b,c,a+c
    return a

n = int(input())
print(fibo(n))
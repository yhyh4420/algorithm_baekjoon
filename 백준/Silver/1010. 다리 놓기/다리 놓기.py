T = int(input())
def fact(n):
    k = 1
    for i in range(1,n+1):
        k *= i
    return k
    
for _ in range(T):
    N, M = map(int, input().split())
    print((fact(M) // (fact(N)*fact(M-N))))
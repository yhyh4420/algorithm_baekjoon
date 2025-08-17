T = int(input())
def solution(n,m):
    d = m-n
    if d == 1:
        return 1
    elif d == 2:
        return 2
    else:
        for n in range(1,2**16):
            if (n-1)**2<d<=n**2:
                if d-(n-1)**2 > n**2 - d:
                    return 2*n - 1
                else:
                    return 2*(n-1)
                
for _ in range(T):
    n,m = map(int, input().split())
    print(solution(n,m))
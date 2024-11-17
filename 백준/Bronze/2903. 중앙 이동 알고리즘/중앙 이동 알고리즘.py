def func(N):
    if N == 0:
        return 2
    return (2*func(N-1)-1)

N = int(input())
print(func(N)**2)
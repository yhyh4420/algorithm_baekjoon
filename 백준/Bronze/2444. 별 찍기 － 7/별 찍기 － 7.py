N = int(input())

for i in range(1, 2*N):
    if i <= N:
        print(' '*(N-i) + '*'*(2*i-1))
    else:
        print(' '*(i-N) + '*'*(4*N+2*(-i)-1))
import sys

T = int(input())

for _ in range(T):
    n = int(sys.stdin.readline())
    a,b = 1,0
    for _ in range(n):
        a,b = b,a+b
    print(a,b)
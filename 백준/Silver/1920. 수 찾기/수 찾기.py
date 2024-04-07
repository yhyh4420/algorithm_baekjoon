import sys

N = int(sys.stdin.readline())
answer = set(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
inp = list(map(int, sys.stdin.readline().split()))

for i in inp:
    if i in answer:
        print(1)
    else:
        print(0)
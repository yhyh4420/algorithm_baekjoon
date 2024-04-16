import sys
N = int(sys.stdin.readline())
l = [0] * 10001
for _ in range(N):
    l[int(sys.stdin.readline())] += 1
for i in range(len(l)):
    if l[i] != 0:
        for j in range(l[i]):
            print(i)
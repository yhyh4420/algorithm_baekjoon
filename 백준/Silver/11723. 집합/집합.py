import sys

N = int(input())

S = set()

for _ in range(N):
    method_list = list(sys.stdin.readline().split())
    method = method_list[0]
    if method == "add":
        S.add(int(method_list[1]))
    elif method == "remove":
        S.discard(int(method_list[1]))
    elif method == "check":
        if int(method_list[1]) in S:
            print(1)
        else:
            print(0)
    elif method == "toggle":
        if int(method_list[1]) in S:
            S.discard(int(method_list[1]))
        else:
            S.add(int(method_list[1]))
    elif method == "all":
        S = set([i+1 for i in range(20)])
    elif method == "empty":
        S = set()
import sys

sys.setrecursionlimit(10**6)

input = sys.stdin.readline

N = int(input())

tree = [[] for _ in range(N+1)]
parents = [0]*(N+1)
for _ in range(N-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

def dfs(current, p):
    parents[current] = p
    for child in tree[current]:
        if parents[child] == 0:
            dfs(child, current)

dfs(1, 0)

for p in parents[2:]:
    print(p)
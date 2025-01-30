N, M = map(int, input().split())
grid = [list(map(int, input().strip())) for _ in range(N)]

max_size = 0

for i in range(N):
    for j in range(M):
        for size in range(1, min(N, M) + 1):
            if i + size - 1 < N and j + size - 1 < M:
                if (grid[i][j] == grid[i + size - 1][j] == grid[i][j + size - 1] == grid[i + size - 1][j + size - 1]):
                    max_size = max(max_size, size)

print(max_size**2)

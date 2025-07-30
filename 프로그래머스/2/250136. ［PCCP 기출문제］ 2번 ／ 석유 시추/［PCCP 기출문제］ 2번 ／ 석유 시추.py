def solution(land):
    answer = 0
    n,m = len(land), len(land[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    oil_sum = [0]*m
    
    def dfs(posx,posy):
        count = 0
        dx, dy = [-1,1,0,0], [0,0,-1,1]
        q = [[posx, posy]]
        cols = set()
        while q:
            node = q.pop()
            if visited[node[0]][node[1]]:
                continue
            visited[node[0]][node[1]] = True
            cols.add(node[1])
            count += 1
            for i in range(4):
                nx,ny = node[0]+dx[i], node[1]+dy[i]
                if 0<=nx<len(land) and 0<=ny<len(land[0]):
                    if not visited[nx][ny] and land[nx][ny] == 1:
                        q.append([nx,ny])
        return count, cols

    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visited[i][j]:
                count, cols = dfs(i,j)
                for col in cols:
                    oil_sum[col] += count
    print(oil_sum)
    return max(oil_sum)
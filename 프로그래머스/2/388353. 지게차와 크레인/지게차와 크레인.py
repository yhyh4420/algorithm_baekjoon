from collections import deque

def solution(storage, requests):
    storage = [list(row) for row in storage]
    for request in requests:
        storage = dfs(request, storage)
    answer = 0
    for rows in storage:
        for row in rows:
            if row != "0":
                answer+=1
    return answer

def dfs(request, storage):
    if len(request) == 2:
        for i in range(len(storage)):
            for j in range(len(storage[0])):
                if storage[i][j] == request[0]:
                    storage[i][j] = "0"
        return storage

    n, m = len(storage), len(storage[0])
    visited = [[False] * m for _ in range(n)]
    target = request[0]
    mark = []
    q = deque()

    '''
    dfs 아이디어
    먼저 외곽을 순회한다
    외곽을 순회하면서 "0"으로 매핑된 값을 찾아서 visited 처리하고 q에 넣는다. 이때 타겟과 같으면 리스트에 넣는다
    q에서 값들을 꺼내가면서 아래 로직을 수행한다.
        1. 먼저 상하좌우를 확인한다.
        2-1. 만약 상하좌우 애들 중 0이 있다면 큐에 넣는다
        2-2. 만약 타겟이 있다면 리스트에 저장해놓는다.
        3. 리스트의 값들을 모두 0으로 매핑한다
    '''
    for i in range(n):
        for j in range(m):
            if (i == 0 or i==n-1 or j==0 or j==m-1): # 외곽 순회
                if storage[i][j] == target: # 외곽 요소 중 타겟과 같으면 리스트에 넣기
                    mark.append((i,j))
                    visited[i][j] = True
                if storage[i][j] == '0':
                    q.append((i, j))
                    visited[i][j] = True
    
    dx, dy = [-1,1,0,0], [0,0,-1,1]
    while q: # 큐 만들어졌으니 dfs 시작
        x,y = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if 0<=nx<n and 0<=ny<m: # 먼저 이웃하는 컨테이너가 유효한 인덱스인지
                if not visited[nx][ny]: # 방문하지 않은 인덱스인지 체크
                    if storage[nx][ny] == target:
                        mark.append((nx, ny))
                        visited[nx][ny] = True
                    if storage[nx][ny] == '0':
                        q.append((nx, ny))
                        visited[nx][ny] = True
    
    for x,y in mark: # 다 조회하고 mark에 남은 인덱스들 0 처리
        storage[x][y] = '0'
    return storage

from collections import deque
import sys
"""
최소 - bfs
"""
def solution(board):
    N = len(board)
    M = len(board[0])
    for i in range(N):
        for j in range(M):
            if board[i][j] == "R":
                start_x, start_y = i,j
                break
    dist = [[sys.maxsize for _ in range(M)] for _ in range(N)]
    q = deque()
    q.append((start_x,start_y,0))
    
    dx, dy = [-1,1,0,0], [0,0,-1,1]
    while q:
        x,y,c = q.popleft()
        if board[x][y] == "G":
            return c
        for d in range(4):
            nx, ny = x, y
            while (0<=nx+dx[d]<N and 0<=ny+dy[d]<M) and board[nx+dx[d]][ny+dy[d]] != "D":
                nx+=dx[d]
                ny+=dy[d]
            if c+1 < dist[nx][ny]:
                dist[nx][ny] = c+1
                q.append((nx, ny, c+1))
            
    return -1
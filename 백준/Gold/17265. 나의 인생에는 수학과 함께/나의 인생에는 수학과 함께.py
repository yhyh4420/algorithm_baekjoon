N = int(input())
ground = [list(input().split()) for _ in range(N)]
for i in range(N):
    for j in range(N):
        if ground[i][j].isdigit():
            ground[i][j] = int(ground[i][j])

dx, dy = [0,1], [1,0]
MAX, MIN = float('inf')*(-1), float('inf')
stack = []
stack.append((0,0,[ground[0][0]]))

def calc(arrs):
    start = arrs[0]
    i = 1
    while i < len(arrs):
        ops = arrs[i]
        next = arrs[i+1]
        if ops == "+":
            start += next
        elif ops == "*":
            start *= next
        else:
            start -= next
        i += 2
    return start
while stack:
    x,y,now = stack.pop()
    if x == N-1  and y == N-1:
        now_number = calc(now)
        MAX, MIN = max(MAX, now_number), min(MIN, now_number)
    for d in range(2):
        nx, ny = x+dx[d], y+dy[d]
        if 0<=nx<N and 0<=ny<N:
            stack.append((nx, ny, now + [ground[nx][ny]]))

print(MAX, MIN)
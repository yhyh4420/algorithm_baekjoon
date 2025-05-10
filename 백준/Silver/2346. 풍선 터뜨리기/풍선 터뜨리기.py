from collections import deque

N = int(input())
moves = list(map(int, input().split()))
deq = deque((i+1, moves[i]) for i in range(N))

while deq:
    idx, move = deq.popleft()
    print(idx, end=" ")
    if not deq:
        break
    if move > 0:
        deq.rotate(-(move-1))
    else:
        deq.rotate(-move)
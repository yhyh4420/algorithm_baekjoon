from collections import deque

N,M = map(int, input().split())
position = list(map(int, input().split()))
deq = deque([i+1 for i in range(N)])

count=0
for item in position:
    while True:
        if deq[0] == item:
            deq.popleft()
            break
        else:
            if deq.index(item) < len(deq)/2:
                while deq[0] != item:
                    deq.append(deq.popleft())
                    count += 1
            else:
                while deq[0] != item:
                    deq.appendleft(deq.pop())
                    count += 1

print(count)
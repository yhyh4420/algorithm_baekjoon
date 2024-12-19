from collections import deque

N,K=map(int, input().split())

queue = deque([i+1 for i in range(N)])
answer = []
count = 0

while queue:
    temp = queue.popleft()

    queue.append(temp)
    count += 1

    if count == K:
        answer.append(temp)
        queue.pop()
        count=0

print("<", end='')
for item in answer:
    if answer.index(item) == N-1:
        print(item, end="")
    else:
        print(item, end=", ")
print(">")
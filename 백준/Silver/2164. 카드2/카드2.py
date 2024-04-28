from collections import deque

N = int(input())
card = deque([i+1 for i in range(N)])

while(len(card) != 1):
    card.popleft()
    temp = card.popleft()
    card.append(temp)

print(card[0])
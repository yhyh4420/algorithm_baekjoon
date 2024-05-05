N = int(input())
stack = []
answer = []
k = 1
b = 1

for i in range(N):
    a = int(input())
    while k <= a:
        stack.append(k)
        answer.append('+')
        k += 1
    if stack[-1] == a:
        stack.pop()
        answer.append('-')
    else:
        print("NO")
        b = 0
        break

for i in answer:
    if b == 1:
        print(i)
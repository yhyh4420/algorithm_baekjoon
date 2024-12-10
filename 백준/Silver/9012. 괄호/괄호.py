N = int(input())
def isVPS(a):
    stack = []
    for s in a:
        if s == "(":
            stack.append(s)
        elif s == ")":
            if stack:
                stack.pop()
            else:
                print("NO")
                break
    else:
        if stack:
            print("NO")
        else:
            print("YES")

for i in range(N):
    a = input()
    isVPS(a)
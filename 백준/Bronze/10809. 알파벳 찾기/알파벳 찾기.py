a = input()
answer = 'abcdefghijklmnopqrstuvwxyz'
for i in answer:
    if i in a:
        print(a.index(i), end = ' ')
    else:
        print(-1, end = ' ')
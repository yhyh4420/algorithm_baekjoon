import sys

T = int(input())

def solution(x1,y1,r1,x2,y2,r2):
    r_val_square = max(r1,r2)
    d = ((x1-x2)**2+(y1-y2)**2)**0.5
    if d==0:
        if r1==r2:
            return -1
        else:
            return 0
    elif r_val_square > d:
        if abs(r1-r2) < d:
            return 2
        elif abs(r1-r2) == d:
            return 1
        else:
            return 0
    else:
        if r1+r2 > d:
            return 2
        elif r1+r2 == d:
            return 1
        else:
            return 0

for _ in range(T):
    x1,y1,r1,x2,y2,r2 = map(int, sys.stdin.readline().split())
    print(solution(x1,y1,r1,x2,y2,r2))

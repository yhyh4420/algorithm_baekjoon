import sys

N, point, vol = map(int, sys.stdin.readline().split())
N_list = list(map(int, sys.stdin.readline().split()))

def count_rank(list, point):
    count = 1
    list.append(point)
    list.sort(reverse=True)
    for item in list:
        if item > point:
            count += 1
    return count

if N == vol:
    if N_list[-1] >= point:
        print(-1)
    else:
        print(count_rank(N_list, point))
else:
    print(count_rank(N_list, point))
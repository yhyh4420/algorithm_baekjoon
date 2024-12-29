import sys

def solution(N, soldiers):
    m = {}
    for soldier in soldiers:
        if soldier in m:
            m[soldier] += 1
        else:
            m[soldier] = 1
    answer_list = [key for key, value in m.items() if value > N / 2]
    if answer_list:
        print(answer_list[0])
    else:
        print('SYJKGW')

N = int(sys.stdin.readline())
for _ in range(N):
    war = list(map(int, sys.stdin.readline().split()))
    num_soldier, soldier = war[0], war[1:]
    solution(num_soldier, soldier)


n = int(input())

tri = []
for i in range(1, 46):
    tri.append(i*(i+1)/2)

eurekaa = []
for i in tri:
    for j in tri:
        for k in tri:
            eurekaa.append(i+j+k)

def solution(k):
    if k in eurekaa:
        return 1
    else:
        return 0

for _ in range(n):
    i = int(input())
    print(solution(i))
import sys

N = int(sys.stdin.readline().strip())

n_list = []
for _ in range(N):
    student = sys.stdin.readline().strip()
    n_list.append(student)

def list_k(n_list,k):
    return_list = []
    for item in n_list:
        return_list.append(item[len(item)-k:])
    return return_list

for i in range(1, len(n_list[0])+1):
    val_list = list_k(n_list,i)
    val_set = set(val_list)
    if len(val_set) == N:
        print(i)
        break
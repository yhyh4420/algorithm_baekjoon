count = 0
while True:
    n = int(input())
    if n == 0:
        break
    else:
        count += 1
    student = []
    for _ in range(n):
        student.append(input())

    val_list = []
    for _ in range(2*n - 1):
        a,b = input().split()
        a = int(a)
        if a in val_list:
            val_list.remove(a)
        else:
            val_list.append(a)
    print(count, student[val_list[0]-1])
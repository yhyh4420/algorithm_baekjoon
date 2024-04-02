student = [i for i in range(1,31)]
lazy = []
for _ in range(28):
    i = int(input())
    student.remove(i)

student.sort()
for i in range(2):
    print(student[i])
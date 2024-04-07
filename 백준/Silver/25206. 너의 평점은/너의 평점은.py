grade = ['A+', 'A0', 'B+', 'B0', 'C+', 'C0', 'D+', 'D0', 'F']
score = [4.5, 4, 3.5, 3, 2.5, 2, 1.5, 1, 0]

sum_cross = 0
sum = 0
for _ in range(20):
    n, a, b = input().split()
    a = float(a)
    if b != 'P':
        sum_cross += score[grade.index(b)] * a
        sum += a
    else:
        continue
        
print(sum_cross/sum)
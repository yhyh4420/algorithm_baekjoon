A = []
length = []
for _ in range(5):
    row = input()
    length_row = len(row)
    A.append(row)
    length.append(length_row)

rst = ''
for j in range(max(length)):
    for i in range(5):
        if j < length[i]:
            rst += A[i][j]
            
print(rst)
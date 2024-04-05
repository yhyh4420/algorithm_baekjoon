num = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
sum = 0
a = input()
for i in num:
    for j in a:
        if j in i:
            sum += (num.index(i)+3)
            
print(sum)
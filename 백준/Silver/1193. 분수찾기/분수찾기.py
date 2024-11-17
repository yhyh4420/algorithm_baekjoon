N = int(input())
k=1
row=1
while N>k:
    row+=1
    k+=row
if row%2==0:
    print(f'{N-(k-row)}/{row+1-(N-(k-row))}')
else:
    print(f'{row+1-(N-(k-row))}/{N-(k-row)}')
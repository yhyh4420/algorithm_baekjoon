list = []

for i in range(9):
    list.append(int(input()))
    
max = list[0]
a = 0

for i in range(len(list)):
    if list[i] > max:
        max = list[i]
        a = i
        
print(max)
print(a + 1)
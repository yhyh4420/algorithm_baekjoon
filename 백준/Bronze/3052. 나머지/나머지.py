num = []
for _ in range(10):
    i = int(input())
    num.append(i % 42)
    
x = []
for i in num:
    if i not in x:
        x.append(i)
print(len(x))
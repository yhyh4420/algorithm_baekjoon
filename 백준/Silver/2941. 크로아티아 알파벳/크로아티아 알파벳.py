word = input()
cta = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for i in cta:
    word = word.replace(i, '*')

print(len(word))
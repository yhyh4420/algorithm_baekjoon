a, b = input().split()
a_inv = int(a[::-1])
b_inv = int(b[::-1])
if a_inv > b_inv:
    print(a_inv)
else:
    print(b_inv)
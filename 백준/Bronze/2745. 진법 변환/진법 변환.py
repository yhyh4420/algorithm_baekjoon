N, B = input().split()
B = int(B)

num_list = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
answer = 0
for i, a in enumerate(N):
    k = (num_list.index(a))*(B**(len(N)-i-1))
    answer += k

print(answer)
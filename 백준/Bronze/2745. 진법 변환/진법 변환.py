N, B = input().split()
B = int(B)
num_list = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
answer = 0
for i in range(len(N)):
    a = num_list.index(N[i])
    answer_i = a*(B**(len(N)-i-1))
    answer += answer_i
    
print(answer)
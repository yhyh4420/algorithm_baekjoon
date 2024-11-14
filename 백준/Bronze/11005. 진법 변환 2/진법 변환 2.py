num_list = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

n, b = map(int, input().split())
answer = ""

while n != 0:
    answer+=num_list[n%b]
    n//=b

print(answer[::-1])
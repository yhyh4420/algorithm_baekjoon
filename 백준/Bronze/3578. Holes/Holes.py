N = int(input())

if N==0:
    answer = '1'
elif N==1:
    answer = '0'
else:
    a = N//2
    b = N%2
    answer = '4'*b + '8'*a

print(answer)
        
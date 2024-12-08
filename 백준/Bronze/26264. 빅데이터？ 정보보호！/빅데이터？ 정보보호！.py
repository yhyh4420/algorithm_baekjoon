N = int(input())
memo = input()

s=0
b=0
for _ in range(N):
    if memo[0] == 's':
        s+=1
        memo=memo[8:]
    else:
        b+=1
        memo=memo[7:]

if s>b:
    print('security!')
elif b>s:
    print('bigdata?')
else:
    print('bigdata? security!')
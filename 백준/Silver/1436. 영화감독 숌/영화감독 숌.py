import sys
N = int(sys.stdin.readline())
result = 666
cnt = 0
while True:
    if '666' in str(result):
        cnt += 1
    if cnt == N:
        break
    result += 1
        
print(result)
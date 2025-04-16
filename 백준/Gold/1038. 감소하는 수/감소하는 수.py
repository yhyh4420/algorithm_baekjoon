"""
규칙이 있는듯. 한자리수는 무조건 감소하는 수이고, 두자리수는 1이면 10, 2이면 21, 20, 3이면 32, 31, 30,....
그러면 n이 주어지면 이게 몇자리수인지 알 수 있음.
몇자리수인지 알게되면 거기서 재귀?
근데 맥시멈은 9876543210임. 이게 몇번째 수인지 알면 이것보다 큰 n은 무조건 -1처리하면 됨
"""
from itertools import combinations

n = int(input())

num = []
for i in range(1,11):
    for j in list(combinations(range(10),i)):
        number = ""
        j = sorted(list(j), reverse=True)
        for k in j:
            number += str(k)
        num.append(int(number))
num = list(set(num))
num.sort()
if n >= len(num):
    print(-1)
else:
    print(num[n])
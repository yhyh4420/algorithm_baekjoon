money_tot = int(input())
T = int(input())

money_calc = 0
for i in range(1, T+1):
    a, b = map(int, input().split())
    money_calc += a*b
    
if money_calc == money_tot:
    print('Yes')
else:
    print('No')
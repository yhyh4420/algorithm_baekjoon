new_case = int(input())
hospital = int(input())

if new_case <= 50 and hospital <= 10:
    answer = 'White'
elif hospital > 30:
    answer = 'Red'
else:
    answer = 'Yellow'

print(answer)
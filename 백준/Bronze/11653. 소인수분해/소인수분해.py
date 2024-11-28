number = int(input())

d = 2

while number > 1:
    if number%d == 0:
        print(d)
        number = number//d
    else:
        d += 1
        if d > int(number**0.5):
            d = number
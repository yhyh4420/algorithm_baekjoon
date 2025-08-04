def solution(phone_book):
    phoneSet = set(phone_book)
    for number in phone_book:
        for i in range(1,len(number)):
            if number[:i] in phoneSet:
                return False
    return True
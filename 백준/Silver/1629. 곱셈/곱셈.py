a,b,c = map(int,input().split())

def devide(a,b):
    if b==1:
        return a%c
    else:
        temp = devide(a,b//2)
        if b%2==0:
            return temp*temp%c
        else:
            return temp*temp*a%c

print(devide(a,b))
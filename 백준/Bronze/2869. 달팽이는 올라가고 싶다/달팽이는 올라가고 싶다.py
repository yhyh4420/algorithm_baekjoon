A,B,V = map(int, input().split(" "))
import math
date = math.ceil((V-A)/(A-B)) + 1
print(date)
y_t,m_t,d_t = map(int, input().split())
y_d,m_d,d_d = map(int, input().split())
def yunyear(y):
    answer = False
    if (y%4==0):
        answer = True
    if y%100==0:
        answer = False
    if ((y%400)==0):
        answer = True
    return answer

def count_day(y,m,d):
    date_per_month = [0,31,28,31,30,31,30,31,31,30,31,30,31]
    if yunyear(y):
        date_per_month[2] = 29
    return sum(date_per_month[:m]) + d

def solution(y_t,m_t,d_t,y_d,m_d,d_d):
    today = count_day(y_t,m_t,d_t)
        
    if y_t == y_d:
        d_day = count_day(y_d,m_d,d_d)
    else:
        year_list = [i for i in range(y_t,y_d)]
        d_day=0
        for year in year_list:
            if yunyear(year):
                d_day+=366
            else:
                d_day+=365
        d_day+=count_day(y_d,m_d,d_d)
    if y_d-y_t>1000:
        return 'gg'
    if y_d-y_t==1000 and (count_day(0,m_d,d_d)-count_day(0,m_t,d_t) >=0):
        return 'gg'
    return f'D-{d_day-today}'

print(solution(y_t,m_t,d_t,y_d,m_d,d_d))
from collections import deque

N = input() 

skill = list(map(int, input().split(" ")))

dq = deque()

num = 1
temp = 0

for i in range(len(skill)):
    if skill[len(skill)-1-i]==1:
        dq.appendleft(num)
    elif skill[len(skill)-1-i]==2:
        temp = dq.popleft()
        dq.appendleft(num)
        dq.appendleft(temp)
    elif skill[len(skill)-1-i]==3:
        dq.append(num)
    num = num + 1

for i in dq:
    print(i, end = " ")


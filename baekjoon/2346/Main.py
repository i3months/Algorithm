from collections import deque
from operator import index

N = int(input())
dq = deque(enumerate(map(int,input().split(" ")), start=1))
ans = []

while dq:
    index, cycle = dq.popleft()
    ans.append(index)
    if cycle>0:
        dq.rotate(-(cycle-1))
    else:
        dq.rotate(-cycle)

for i in ans:
    print(i, end=" ")


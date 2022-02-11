from collections import deque
from operator import index

dq = deque([1,2,3,4,5])
dq.rotate(-1)

print(dq)
from collections import deque
import sys

N = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split(" ")))
ans = [-1] * N

st = []
stidx = []

for i in range(N):
  while st and st[-1] < arr[i]:
    ans[stidx[-1]] = arr[i]
    st.pop()
    stidx.pop()
  st.append(arr[i])
  stidx.append(i)

while stidx:
  ans[stidx[-1]] = -1
  stidx.pop()

ans[N-1] = -1

for i in ans:
  print(i, end=" ")

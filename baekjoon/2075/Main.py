import sys
input = sys.stdin.readline
import heapq

N = int(input())

pq = []

for i in range(N):
  temp = list(map(int, input().split(" ")))

  if not pq:
    for j in temp:
      heapq.heappush(pq, j)
  else:
    for j in temp:
      heapq.heappush(pq,j)
      heapq.heappop(pq)

print(pq[0])
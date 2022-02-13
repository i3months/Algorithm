import heapq
import sys

N = int(input())
heap = []

for i in range(N):
    command = int(sys.stdin.readline())
    if command == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, command)
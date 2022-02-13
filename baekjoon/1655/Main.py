import heapq
import sys

N = int(input())
maxheap = []
minheap = []


for i in range(N):
    command = int(sys.stdin.readline())
    if(len(minheap) == len(maxheap)):
        heapq.heappush(maxheap, -command)
    else:
        heapq.heappush(minheap, command)
    
    if(minheap and maxheap):
        if(maxheap[0]*-1 > minheap[0]):
            temp = heapq.heappop(minheap) 
            heapq.heappush(minheap, heapq.heappop(maxheap)*-1)
            heapq.heappush(maxheap, temp*-1)
    print(maxheap[0]*-1)

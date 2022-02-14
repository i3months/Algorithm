import sys

N,M = map(int, sys.stdin.readline().split(" "))

S = set([sys.stdin.readline() for i in range(N)])

count = 0

for i in range(M):
  str = sys.stdin.readline()
  if str in S:
    count = count + 1

print(count)

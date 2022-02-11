import sys
input = sys.stdin.readline

N,M = map(int, input().split(" "))

pokemon = {}

for i in range(1, N+1):
  a = input().rstrip()
  
  pokemon[i] = a
  pokemon[a] = i

for i in range(M):
  quiz = input().rstrip()
 
  if quiz.isdigit():
    print(pokemon[int(quiz)])
  else:
    print(pokemon[quiz])

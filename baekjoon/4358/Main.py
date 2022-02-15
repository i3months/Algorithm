import sys
input = sys.stdin.readline

tree = {}
count = 0

while True:
  str = input().rstrip()

  if not str:
    break
  
  if str not in tree:
    tree[str] =1
  else:
    tree[str] = tree[str] + 1
  
  count = count + 1

tree2 = list(tree.keys())
tree2.sort()

for i in tree2:
  print('%s %.4f' %(i, tree[i] / count * 100.0))



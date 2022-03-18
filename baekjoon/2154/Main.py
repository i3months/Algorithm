N = int(input())
ans = ""

for i in range(1,N+1):
    ans+=str(i)
print(ans.find(str(N))+1)
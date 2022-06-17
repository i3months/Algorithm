N, M = map(int, input().split(' '))

tmp = []
for i in range(N):
    tmp.append(int(input()))
for i in range(1, M+1):    
    for idx in range(1, len(tmp)):    
        if tmp[idx-1] % i > tmp[idx] % i:            
            tmp[idx-1], tmp[idx] = tmp[idx], tmp[idx-1]
for num in tmp:
    print(num)
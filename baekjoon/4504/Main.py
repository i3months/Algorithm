N = int(input())
ans = ""

while True:
    temp = int(input())
    if(temp == 0):
        break;
    
    if(temp % N == 0):
        print("%d is a multiple of %d." %(temp,N))
    else:
        print("%d is NOT a multiple of %d." %(temp,N))
    
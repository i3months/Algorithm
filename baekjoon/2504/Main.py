


str = list(input())

st = []
ans =0
temp =1

for i in range(len(str)):

    if str[i] == '(':
        st.append('(')
        temp = temp * 2

    elif str[i] == '[':
        st.append('[')
        temp = temp * 3

    elif str[i] == ')':
        if not st or st[-1] != '(':
            ans = 0
            break
        elif str[i-1] == '(':
            ans = ans + temp
        st.pop()
        temp = temp / 2

    elif str[i] ==']':
        if not st or st[-1] != '[':
            ans = 0
            break
        elif str[i-1] == '[':
            ans = ans + temp
        del st[-1]
        temp = temp / 3

if(st):
    print(0)
else:
    print(int(ans))
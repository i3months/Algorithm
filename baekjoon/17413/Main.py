str = input()

check = False
ans = ""
temp = ""

for i in str:
    if check == False:
        if i == "<":
            check = True
            temp = temp + i
        elif i == " ":
            temp = temp + i
            ans = ans + temp
            temp = ""
        else:
            temp = i + temp
    else:
        temp = temp + i
        if i == '>':
            check = False
            ans = ans + temp
            temp = ''


print(ans + temp)
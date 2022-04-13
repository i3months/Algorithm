#include <stdio.h>
#include <string.h>

int main()
{
    char str[101];

    scanf("%s", str);

    for(int i=0; i<strlen(str); i++){
        if(str[i] >= 'A' && str[i] <= 'Z'){
            printf("%c", str[i]);
        }
    }
}

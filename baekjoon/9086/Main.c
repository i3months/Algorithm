#include<stdio.h>
#include <string.h> 

int main()
{
    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){
        char str[1001];
        scanf("%s", str);
        
        printf("%c%c\n", str[0], str[strlen(str)-1]);

    }

}

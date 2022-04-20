#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {        

    int N;
    scanf("%d", &N);

    char str[21];

    for(int i=0; i<N; i++){
        scanf("%s", str);

        for(int j=0; j<strlen(str); j++){
            if(str[j] >= 'a' && str[j] <= 'z'){
                printf("%c", str[j]);
            }else{
                printf("%c", str[j] + 32);
            }
        }
        printf("\n");
    }

    

}

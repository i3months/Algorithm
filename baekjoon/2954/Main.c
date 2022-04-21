#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void solve(char str[], int len){
    char decode[101];

    int idx = 0;

    for(int i=0; i<len; i++){
        int a = 0;
        
        if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u'){            
            if(str[i+1] == 'p'){
                if(str[i+2] == str[i]){
                    a = 1;
                    decode[idx] = str[i];
                    idx = idx + 1;
                    i = i + 2;
                }
            }
        }

        if(a == 0){
            decode[idx] = str[i];
            idx = idx + 1;
        }

    }

    for(int i=0; i<idx; i++){
        printf("%c", decode[i]);
    }
    
}

int main() {
    char arr[105];

    gets(arr);

    solve(arr, strlen(arr));
    
}
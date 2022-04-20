#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int solve(char * str, int len){
    int check[26];

    for(int i=0; i<26; i++){
        check[i] = 0;
    }

    for(int i=0; i<len; i++){
        check[str[i] - 'a']++;
    }

    for(int i=0; i<26; i++){
        if(check[i] == 0){
            return 0;
        }
    }    

    return 1;
}

int main() {
    
    while(1){
        char str1[205];
        gets(str1);

        char * str = str1;

        
        if(strcmp(str,"*") == 0){
            break;
        }

        int len = strlen(str);        

        int ans = solve(str, len);

        if(ans){
            printf("Y\n");
        }else{
            printf("N\n");
        }
        
    }

    
}
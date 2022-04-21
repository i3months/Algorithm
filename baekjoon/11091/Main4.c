#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void solve(char * str, int len){
    int check[1000];

    for(int i=0; i<1000; i++){
        check[i] = 0;
    }

    for(int i=0; i<len; i++){
        if(str[i] >= 'a' && str[i] <= 'z'){
          check[str[i] - 'a']++;
        }

        if(str[i] >= 'A' && str[i] <= 'Z'){
          check[str[i] - 'A']++;
        }
        
    }

    int chk = 1;
    
    char arr[26];

    int cnt = 0;

    for(int i=0; i<26; i++){
        if(check[i] == 0){
          chk = 0;
          
          arr[cnt] = i + 'a';
          cnt++;
        }               
    }    

    if(chk == 1){
      printf("pangram\n");
      return;
    }else{
      printf("missing ");
      for(int i=0; i<cnt; i++){
        printf("%c", arr[i]);
      }
      printf("\n");
    }

    
}

int main() {

    int N;
    scanf("%d", &N);
    
    char a[2];
    gets(a);

    for(int i=0; i<N; i++){
    
        char str1[205];
        gets(str1);

        char * str = str1;                

        int len = strlen(str);        

        solve(str, len);

        
    
    }
    
}
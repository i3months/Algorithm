#include<stdio.h>
#include <string.h> 

int main()
{
   char s1[101];  
   scanf("%s", s1);
    int cnt = 0;
   for(int i=0; i<strlen(s1); i++){
       if(s1[i] == ','){
           cnt++;
       }
   }

    printf("%d", cnt+1);
    
}

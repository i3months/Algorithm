#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    
    int N;
    scanf("%d", &N);

    int cnt = 0;
    int minus = 1;

    while(1){

      if(N == 0){
        break;
      }  
      
      if((N - minus) >= 0){
        N = N - minus;
        minus++;
        cnt++;
      } 
      
      if(N - minus < 0){
        minus = 1;
      }

    }

    printf("%d", cnt);

    
}
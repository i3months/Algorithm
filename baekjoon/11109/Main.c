#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    
    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){
      int a,b,c,d;
      scanf("%d %d %d %d", &a, &b, &c, &d);

      if(a + b * d > b * c){
        printf("do not parallelize\n");
      }else if(a + b * d < b * c){
        printf("parallelize\n");
      }else{
        printf("does not matter\n");
      }
    
      
    }
}